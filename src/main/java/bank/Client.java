package bank;

/**
 * Client class
 *
 * @author Кушнеренко Виктор
 */
public class Client {

    private Integer money;

    private ClientAction clientAction;

    private Integer timeOfService;

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

    public Integer getTimeOfService() {
        return timeOfService;
    }

    public void setTimeOfService(Integer timeOfService) {
        this.timeOfService = timeOfService;
    }

    public Client(Integer money, ClientAction clientAction, Integer timeOfService) {
        this.money = money;
        this.clientAction = clientAction;
        this.timeOfService = timeOfService;
    }

    @Override
    public String toString() {
        return "Client{" +
                "money=" + money +
                ", clientAction=" + clientAction +
                ", timeOfService=" + timeOfService +
                '}';
    }
}
