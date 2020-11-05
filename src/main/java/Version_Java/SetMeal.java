package Version_Java;

public class SetMeal {
    private String name;
    private double price;
    private String chicken;
    Drinks drink;

    public SetMeal(String name, double price, String chicken, Drinks drink) {
        this.name = name;
        this.price = price;
        this.chicken = chicken;
        this.drink = drink;
    }

    public Drinks getDrink() {
        return drink;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Version_Java.SetMeal{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", chicken='" + chicken + '\'' +
                ", drink=" + drink.getClass().toString() +
                '}';
    }
}
