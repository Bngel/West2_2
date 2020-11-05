package Version_Kotlin

import java.time.LocalDate

class Beer (name: String, cost: Double, date: LocalDate, val alcohol: Float) : Drinks (name,cost,date,30){

    override fun toString() = "Version_Java.Beer{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", date=" + date +
                ", expiration=" + expiration +
                "alcohol=" + alcohol +
                '}'

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val beer = o as Beer
        return beer.name == name
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + alcohol.hashCode()
        return result
    }
}