package Version_Kotlin

import java.time.LocalDate
import java.util.*

fun main(args: Array<String>) {
    val west = West2FriedChickenRestaurant()
    val initDrinks = LinkedList<Drinks>()
    initDrinks.add(Juice("Snow", 4.0,
            LocalDate.of(2010, 11, 1)))
    initDrinks.add(Beer("Sun", 4.0,
            LocalDate.of(2010, 10, 1), 10.0F))
    initDrinks.add(Beer("Rain", 4.0,
            LocalDate.of(2010, 10, 1), 10.0F))
    west.GetGoods(initDrinks)
    west.SellMeal(SetMeal("GoodChicken", 30.0, "BlackChicken",
            Beer("Rain", 4.0,
                    LocalDate.of(2020, 10, 1), 10F)))
    west.SellMeal(SetMeal("GoodChicken", 30.0, "BlackChicken",
            Beer("Rain", 4.0,
                    LocalDate.of(2020, 10, 1), 10F)))
    west.GetGoods(initDrinks)
    west.GetGoods(initDrinks)
    west.GetGoods(initDrinks)
}