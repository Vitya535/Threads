package bank;

/**
 * Bank class
 *
 * @author Кушнеренко Виктор
 */
public class Bank {
    private int sum; // всего наличных

    public Bank(Integer sum) {
        this.sum = sum;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public synchronized boolean bringOut(int sum) {
        if (sum <= 0) {
            throw new Error("Incorrect sum");
        }
        if (sum > this.sum) {
            return false;
        } else {
            this.sum -= sum;
            return true;
        }
    }

    public synchronized void bringIn(int sum) {
        if (sum <= 0) {
            throw new Error("Incorrect sum");
        }
        this.sum += sum;
    }
}
