package Version_Kotlin

import java.time.LocalDate

class Juice (name: String, cost: Double, date: LocalDate) : Drinks(name, cost, date, 2){
    override fun toString() ="Version_Java.Beer{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", date=" + date +
                ", expiration=" + expiration +
                '}'

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + cost.hashCode()
        result = 31 * result + date.hashCode()
        result = 31 * result + expiration
        return result
    }

    override fun equals(o: Any?): Boolean {
        return super.equals(o)
    }
}