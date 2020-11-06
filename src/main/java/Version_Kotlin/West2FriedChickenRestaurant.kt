package Version_Kotlin
import java.time.LocalDate
import java.util.*

class West2FriedChickenRestaurant : FriedChickenRestaurant {
    private var amount = 12.0 // 起始资金
    private val beers = LinkedList<Beer>()
    private val juices = LinkedList<Juice>()
    private val meals = LinkedList<SetMeal>()
    // Answer:
    // 使用 LinkedList 也就是 链表结构 添加 和 删除 更为高效

    init {
        meals.add(
                SetMeal("SuperChicken", 70.0, "WhiteChicken",
                        Juice("Snow", 4.0,
                                LocalDate.of(2020, 11, 1)))
        )
        meals.add(
                SetMeal("NiceChicken", 50.0, "GreenChicken",
                        Beer("Sun", 4.0,
                                LocalDate.of(2020, 10, 1), 10F))
        )
        meals.add(
                SetMeal("GoodChicken", 30.0, "BlackChicken",
                        Beer("Rain", 4.0,
                                LocalDate.of(2020, 10, 1), 10F))
        )
    }

    private fun use(beer: Beer) {
        var success = false
        val delList = LinkedList<Beer>()
        for (br in beers) {
            if (br.isOverDate(LocalDate.now())) {
                delList.add(br)
            }
        }
        beers.removeAll(delList)
        for (i in beers.indices)
            if (beers[i].equals(beer)) {
                beers.removeAt(i)
                success = true
                break
            }
        if (!success) throw IngredientSortOutException(beer)
    }

    private fun use(juice: Juice) {
        var success = false
        val delList = LinkedList<Juice>()
        for (je in juices) {
            if (je.isOverDate(LocalDate.now())) {
                delList.add(je)
            }
        }
        juices.removeAll(delList)
        for (je in juices) {
            if (je.isOverDate(LocalDate.now())) {
                println(je.toString())
                juices.remove(je)
            }
        }
        for (i in juices.indices)
            if (juices[i].equals(juice)) {
                juices.removeAt(i)
                success = true
                break
            }
        if (!success) throw IngredientSortOutException(juice)
    }

    override fun SellMeal(meal: SetMeal) {
        val drink: Drinks = meal.drink
        try {
            when (drink) {
                is Beer -> use(drink)
                is Juice -> use(drink)
            }
            println("Have sold one meal with " + drink.javaClass.toString())
            amount += meal.price
        } catch (e: IngredientSortOutException) {
            println("No " + e.getDrink())
        }
    }

    override fun GetGoods(drinks: LinkedList<Drinks>) {
        try {
            for (drink in drinks) {
                if (amount < drink.cost)
                    throw OverdraftBalanceException(amount)
                else amount -= drink.cost
                if (drink is Beer) {
                    beers.add(drink)
                    println(String.format("Get a %s", drink.name))
                } else if (drink is Juice) {
                    juices.add(drink)
                    println(String.format("Get a %s", drink.name))
                }
            }
        } catch (e: OverdraftBalanceException) {
            println(String.format("Only %.2f yuan. Cannot afford.", e.amount))
        }
    }


}