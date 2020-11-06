package Version_Java;

import java.time.LocalDate;
import java.util.Objects;

public class Beer extends Drinks{
    private float alcohol;

    public Beer(String name, double cost, LocalDate date, float alcohol) {
        super(name, cost, date, 30);
        this.alcohol = alcohol;
    }

    @Override
    public String toString() {
        return "Version_Java.Beer{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", date=" + date +
                ", expiration=" + expiration +
                ", alcohol=" + alcohol +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Beer beer = (Beer) o;
        return beer.name.equals(this.name) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(alcohol);
    }
}
