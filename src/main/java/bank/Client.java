package bank;

/**
 * Client class
 *
 * @author Кушнеренко Виктор
 */
public class Client {

    private Integer money;

    private ClientAction clientAction;

    private long timeOfService;

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public ClientAction getClientAction() {
        return clientAction;
    }

    public void setClientAction(ClientAction clientAction) {
        this.clientAction = clientAction;
    }

    public long getTimeOfService() {
        return timeOfService;
    }

    public void setTimeOfService(long timeOfService) {
        this.timeOfService = timeOfService;
    }

    public Client(Integer money, ClientAction clientAction, long timeOfService) {
        this.money = money;
        this.clientAction = clientAction;
        this.timeOfService = timeOfService;
    }
}
