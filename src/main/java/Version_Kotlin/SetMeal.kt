package Version_Kotlin


class SetMeal(private val name: String, val price: Double, private val chicken: String, var drink: Drinks) {

    override fun toString() =  "SetMeal{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", chicken='" + chicken + '\'' +
                ", drink=" + drink.javaClass.toString() +
                '}'
}