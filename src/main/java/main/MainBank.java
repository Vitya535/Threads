package main;

import bank.Bank;
import bank.Client;
import bank.ClientAction;
import bank.Operationist;

import java.util.*;

/**
 * Entry point for bank app
 *
 * @author Кушнеренко Виктор
 */
public class MainBank {

    // ToDo - клиентов генерировать в случайные моменты времени, со случайными значениями и в отдельном потоке

    public static void main(String[] args) {
        List<Client> clients = new ArrayList<Client>();
        clients.add(new Client(200, ClientAction.putMoney, 900));
        clients.add(new Client(50, ClientAction.takeMoney, 900));
        clients.add(new Client(10, ClientAction.putMoney, 900));
        clients.add(new Client(100, ClientAction.takeMoney, 900));
        clients.add(new Client(250, ClientAction.takeMoney, 900));
        clients.add(new Client(40, ClientAction.putMoney, 900));
        clients.add(new Client(30, ClientAction.putMoney, 900));
        clients.add(new Client(100, ClientAction.putMoney, 900));
        clients.add(new Client(150, ClientAction.putMoney, 900));
        clients.add(new Client(3000, ClientAction.takeMoney, 900));
        clients.add(new Client(4000, ClientAction.takeMoney, 900));
        clients.add(new Client(5000, ClientAction.takeMoney, 900));
        clients.add(new Client(1000, ClientAction.takeMoney, 900));
        clients.add(new Client(2000, ClientAction.takeMoney, 900));
        clients.add(new Client(500, ClientAction.takeMoney, 900));
        clients.add(new Client(250, ClientAction.takeMoney, 900));
        clients.add(new Client(300, ClientAction.putMoney, 900));
        clients.add(new Client(400, ClientAction.putMoney, 900));
        clients.add(new Client(270, ClientAction.takeMoney, 900));
        clients.add(new Client(770, ClientAction.takeMoney, 900));
        clients.add(new Client(310, ClientAction.putMoney, 900));

        Bank bank = new Bank(10000);

        List<Operationist> operationists = new ArrayList<Operationist>();
        operationists.add(new Operationist(new LinkedList<Client>(), bank));
        operationists.add(new Operationist(new LinkedList<Client>(), bank));
        operationists.add(new Operationist(new LinkedList<Client>(), bank));
        operationists.add(new Operationist(new LinkedList<Client>(), bank));
        operationists.add(new Operationist(new LinkedList<Client>(), bank));

        for (Client client : clients) {
            int currentIndex = 0;
            for (int j = 0; j < operationists.size() - 1; j++) {
                if (operationists.get(j).getClients().size() < operationists.get(j + 1).getClients().size()) {
                    currentIndex = j;
                } else {
                    currentIndex = j + 1;
                }
            }
            operationists.get(currentIndex).getClients().offer(client);
        }

        for (Operationist operationist : operationists) {
            operationist.start();
        }

        for (Operationist operationist : operationists) {
            try {
                operationist.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
