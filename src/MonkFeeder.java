public class MonkFeeder{

    public synchronized void feed(int count) {
        System.out.printf("Философ %s закончил думать%n", Thread.currentThread().getName());
        System.out.printf("Философ %s начал есть%n", Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
            System.out.printf("Философ %s закончил есть%n", Thread.currentThread().getName());
            this.notify();
            System.out.printf("Философ %s начал думать%n", Thread.currentThread().getName());
            if (count<3) this.wait();
            else Thread.currentThread().interrupt();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
