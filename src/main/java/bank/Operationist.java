package bank;

import java.util.Queue;

public class Operationist extends Thread {

    private Bank bank;

    private Queue<Client> clients;

    public Queue<Client> getClients() {
        return clients;
    }

    public void setClients(Queue<Client> clients) {
        this.clients = clients;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Operationist(Queue<Client> clients, Bank bank) {
        this.clients = clients;
        this.bank = bank;
    }

    @Override
    public void run() {
        for (Client client : clients) {
            if (client.getClientAction().equals(ClientAction.putMoney)) {
                bank.setSum(bank.getSum() + client.getMoney());
                System.out.println("Клиент положил " + client.getMoney());
                System.out.println("Денег в банке: " + bank.getSum());
                client.setMoney(0);
            } else if (client.getClientAction().equals(ClientAction.takeMoney)) {
                if (bank.getSum() <= 0) {
                    System.out.println("Клиент хотел взять: " + client.getMoney());
                    System.out.println("Денег нет!");
                    continue;
                } else if (bank.getSum() < client.getMoney()) {
                    System.out.println("Клиент хотел взять: " + client.getMoney());
                    System.out.println("Меньше денег, чем требуют!");
                    continue;
                }
                bank.setSum(bank.getSum() - client.getMoney());
                System.out.println("Клиент взял " + client.getMoney());
                System.out.println("Денег в банке: " + bank.getSum());
                client.setMoney(2 * client.getMoney());
            }
            try {
                sleep(client.getTimeOfService());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
