package Version_Java;

public class IngredientSortOutException extends RuntimeException {

    private Drinks drink;

    public IngredientSortOutException(Drinks drink) {
        this.drink = drink;
    }

    public String getDrink() {
        if (drink instanceof Beer)
            return "Beer";
        else if(drink instanceof Juice)
            return "Juice";
        else
            return "Error";
    }
}
