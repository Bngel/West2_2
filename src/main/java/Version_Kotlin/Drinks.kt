package Version_Kotlin

import java.time.LocalDate
import java.time.temporal.ChronoUnit

abstract class Drinks(val name: String, val cost: Double, val date: LocalDate, val expiration: Int) {

    open fun isOverDate(nowdate: LocalDate) = nowdate.isAfter(date.plus(expiration.toLong(), ChronoUnit.DAYS))

    override fun toString() = "Version_Java.Drinks{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", date=" + date +
                ", expiration=" + expiration +
                '}'


    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val drinks = o as Drinks
        return name == drinks.name
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + cost.hashCode()
        result = 31 * result + date.hashCode()
        result = 31 * result + expiration
        return result
    }
}