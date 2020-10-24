package hello;

public class Order {

    private final int id;
    private String enrich;
    public Order(final int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                '}';
    }

    public Order setEnrich(final int id) {
        enrich = String.valueOf(id);
        return this;
    }
}

