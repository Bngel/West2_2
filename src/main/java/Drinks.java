import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public abstract class Drinks {
    protected String name; // 名称
    protected double cost; // 成本
    protected LocalDate date; // 生产日期
    protected int expiration; // 保质期

    public Drinks(String name, double cost, LocalDate date, int expiration) {
        this.name = name;
        this.cost = cost;
        this.date = date;
        this.expiration = expiration;
    }

    public boolean isOverDate(LocalDate nowdate){
        LocalDate latestdate = date.plus(expiration, ChronoUnit.DAYS);
        return nowdate.isAfter(latestdate);
    }

    @Override
    public String toString() {
        return "Drinks{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", date=" + date +
                ", expiration=" + expiration +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drinks drinks = (Drinks) o;
        return name.equals(drinks.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cost, date, expiration);
    }
}
