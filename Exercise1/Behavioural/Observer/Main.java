public class Main {
    public static void main(String[] args) {
        Stock appleStock = new Stock("AAPL", 150.0);

        Trader t1 = new ConcreteTrader("Alice");
        Trader t2 = new ConcreteTrader("Bob");

        appleStock.attach(t1);
        appleStock.attach(t2);

        appleStock.setPrice(155.0);
        appleStock.setPrice(160.0);

        appleStock.detach(t1);

        appleStock.setPrice(165.0);
    }
}
