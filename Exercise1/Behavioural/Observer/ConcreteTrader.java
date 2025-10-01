public class ConcreteTrader implements Trader {
    private String name;

    public ConcreteTrader(String name) {
        this.name = name;
    }

    @Override
    public void update(String stockSymbol, double stockPrice) {
        System.out.println("Trader " + name + " notified: " + stockSymbol + " price is now " + stockPrice);
    }
}
