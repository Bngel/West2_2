package Version_Java;

import java.time.LocalDate;

public class Juice extends Drinks{
    public Juice(String name, double cost, LocalDate date) {
        super(name, cost, date, 2);
    }

    @Override
    public String toString() {
        return "Version_Java.Beer{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", date=" + date +
                ", expiration=" + expiration +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
