package bank;

/**
 * Bank class
 *
 * @author Кушнеренко Виктор
 */
public class Bank {
    private Integer sum; // всего наличных

    public Bank(Integer sum) {
        this.sum = sum;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }
}
