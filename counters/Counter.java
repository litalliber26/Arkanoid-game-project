package counters;
// 208000414 Lital Liber
/**
 * @author Lital Liber <lital.liber@live.biu.ac.il>
 * @version 1.0
 * @since 2023-05-24
 */
/**
 * Counter is a simple class that is used for counting things.
 */
public class Counter {
    private static final int ZERO = 0;
    //Fields.
    // The counter.
    private double count = ZERO;
    // add number to current count.
    /**
     * The function add number to current count.
     * @param number The number added to the counter.
     */
    public void increase(double number) {
        this.count = this.count + number;
    }
    // subtract number from current count.
    /**
     * The function subtract number to current count.
     * @param number The number that is subtracted from the counter.
     */
    public void decrease(int number) {
        this.count = this.count - number;
    }
    // get current count.
    /**
     * @return The current count.
     */
    public double getValue() {
        return this.count;
    }
}
