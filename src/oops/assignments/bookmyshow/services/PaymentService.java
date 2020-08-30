package oops.assignments.bookmyshow.services;

public class PaymentService {

    public boolean makePayment(int amount) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return _75PercentProbability();
    }

    private boolean _75PercentProbability() {
        return _50PercentProbability() | _50PercentProbability();
    }

    private boolean _50PercentProbability() {
        return ((int) (10 * Math.random()) & 1) == 1;
    }
}
