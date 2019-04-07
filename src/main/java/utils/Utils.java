package utils;

import bank.Client;
import bank.ClientAction;
import bank.Operationist;

import java.util.List;
import java.util.Random;

public class Utils {

    public static void addClientInMinQueue(List<Operationist> operationists, Client client) {
        int minIndex = 0;
        int minSize = operationists.get(0).getClients().size();
        for (Operationist operationist : operationists) {
            if (operationist.getClients().size() < minSize) {
                minSize = operationist.getClients().size();
                minIndex = operationists.indexOf(operationist);
            }
        }
        operationists.get(minIndex).addClient(client);
    }

    public static Client generate() {
        Client result;
        Integer randomIntOne;
        Integer randomIntTwo;
        ClientAction action;

        Random random = new Random();
        randomIntOne = random.nextInt(2);
        if (randomIntOne == 1) {
            action = ClientAction.takeMoney;
        } else {
            action = ClientAction.putMoney;
        }
        randomIntOne = random.nextInt(1500);
        randomIntTwo = random.nextInt(1000);
        result = new Client(randomIntOne, action, randomIntTwo);

        return result;
    }
}
