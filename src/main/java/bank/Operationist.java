package bank;

import utils.Utils;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Operationist extends Thread {

    private Bank bank;

    private Queue<Client> clients;

    private List<Operationist> operationists;

    public synchronized Queue<Client> getClients() {
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

    public synchronized void addClient(Client client) {
        clients.add(client);
        System.out.println("Клиент встал в очередь: " + client);
        System.out.println("Длина очереди: " + clients.size());
        notify();
    }

    @Override
    public void run() {
        Client client;
        LinkedList<Client> queue;
        ClientAction action;
        int sum;
        while (true) {
            queue = (LinkedList<Client>) this.getClients();
            if (queue.size() > 0) {
                client = queue.getFirst();
                System.out.println("Начал обработку клиента " + client);
                action = client.getClientAction();
                sum = client.getMoney();
                try {
                    Thread.sleep(client.getTimeOfService());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (action == ClientAction.putMoney) {
                    this.bank.bringIn(sum);
                    System.out.println("Внес сумму: " + sum);
                    System.out.println("Остаток хранилища: " + this.bank.getSum());
                } else {
                    if (this.bank.bringOut(sum)) {
                        System.out.println("Снял сумму: " + sum);
                        System.out.println("Остаток хранилища: " + this.bank.getSum());
                    } else {
                        System.out.println("В хранилище недостаточно средств для клиента: " + client);
                        queue.removeFirst();
                        System.out.println("Клиент: " + client + " вышел из очереди");
                        Utils.addClientInMinQueue(this.operationists, client);
                        continue;
                    }
                }
                queue.removeFirst();
                System.out.println("Закончил обработку клиента " + client);
                System.out.println("Длина очереди - " + queue.size());
            } else {
                try {
                    synchronized (this) {
                        wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setOperationists(List<Operationist> operationists) {
        this.operationists = operationists;
    }

    public List<Operationist> getOperationists() {
        return operationists;
    }
}
