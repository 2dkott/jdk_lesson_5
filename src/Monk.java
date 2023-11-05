public class Monk implements Runnable {

    MonkFeeder feeder;
    public Monk(MonkFeeder feeder) {
        this.feeder = feeder;
    }

    @Override
    public void run() {
        int counter = 0;
        while (counter<=3) {
            feeder.feed(counter);
            counter++;
        }
    }
}
