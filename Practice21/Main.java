package Practice21;

public class Main {
    public static void main(String[] args) {
        ResourceShare shareResource = new ResourceShare();
        Producer producer = new Producer(shareResource);
        Consumer consumer = new Consumer(shareResource);

        producer.start();
        consumer.start();
    }
}
