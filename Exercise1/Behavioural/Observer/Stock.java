import java.util.ArrayList;
import java.util.List;

public class Stock {
    private String symbol;
    private double price;
    private List<Trader> traders = new ArrayList<>();

    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }

    public void attach(Trader trader) {
        traders.add(trader);
    }

    public void detach(Trader trader) {
        traders.remove(trader);
    }

    public void setPrice(double price) {
        this.price = price;
        notifyTraders();
    }

    public void notifyTraders() {
        for (Trader trader : traders) {
            trader.update(symbol, price);
        }
    }
}
