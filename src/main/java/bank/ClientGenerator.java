package bank;

import java.util.List;
import java.util.Random;

public class ClientGenerator extends Thread {

    private static ClientGenerator instance = new ClientGenerator();

    private List<Client> clients;

    private ClientGenerator(List<Client> clients) {
        this.clients = clients;
    }

    public static ClientGenerator getInstance() {
        return instance;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (;;) {
            Client client = new Client(random.nextInt(1000),  ,random.nextLong());
            clients.add(new Client())
        }
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
