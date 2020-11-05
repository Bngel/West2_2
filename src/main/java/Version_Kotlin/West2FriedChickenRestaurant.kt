package Version_Kotlin
import java.util.*

class West2FriedChickenRestaurant : FriedChickenRestaurant {
    private var amount = 12.0 // 起始资金
    private val beers = LinkedList<Beer>()
    private val juices = LinkedList<Juice>()
    private val meals = LinkedList<SetMeal>()
    // Answer:
    // 使用 LinkedList 也就是 链表结构 添加 和 删除 更为高效

    private fun use(beer: Beer) {
        var success = false
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
            amount += meal.price
        } catch (e: IngredientSortOutException) {
            println("No " + e.getDrink())
        }
    }

    override fun GetGoods(drinks: LinkedList<Drinks>) {
        try {
            for (drink in drinks) {
                if (drink is Beer) {
                    beers.add(drink)
                    println(String.format("Get a %s", drink.name))
                } else if (drink is Juice) {
                    juices.add(drink)
                    println(String.format("Get a %s", drink.name))
                }
                if (amount < drink.cost)
                    throw OverdraftBalanceException(amount)
                else amount -= drink.cost
            }
        } catch (e: OverdraftBalanceException) {
            println(String.format("Only %.2f yuan. Cannot afford.%n", e.amount))
        }
    }


}