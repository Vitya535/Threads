package main;

import bank.Bank;
import bank.Client;
import bank.Operationist;
import utils.Utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Entry point for bank app
 *
 * @author Кушнеренко Виктор
 */
public class MainBank {

    // ToDo - клиентов генерировать в случайные моменты времени, со случайными значениями и в отдельном потоке

    public static void main(String[] args) {
        Bank bank = new Bank(10000);

        List<Operationist> operationists = new ArrayList<>();
        operationists.add(new Operationist(new LinkedList<>(), bank));
        operationists.add(new Operationist(new LinkedList<>(), bank));
        operationists.add(new Operationist(new LinkedList<>(), bank));
        operationists.add(new Operationist(new LinkedList<>(), bank));
        operationists.add(new Operationist(new LinkedList<>(), bank));

        startWork(operationists);
    }

    private static void startWork(List<Operationist> operationists) {
        Random random = new Random();

        for (Operationist operationist : operationists) {
            operationist.setOperationists(operationists);
            operationist.start();
        }

        while (true) {
            Client randomClient = Utils.generate();
            System.out.println("Пришел клиент " + randomClient);
            Utils.addClientInMinQueue(operationists, randomClient);
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
