package Version_Kotlin

class IngredientSortOutException(private var drink: Drinks) : RuntimeException() {

    fun getDrink() = when(drink) {
        is Beer -> "Beer"
        is Juice -> "Juice"
        else -> "Error"
    }
}