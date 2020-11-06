package Version_Java;

import java.time.LocalDate;
import java.util.LinkedList;

public class West2FriedChickenRestaurant implements FriedChickenRestaurant{

    private double amount;
    private final LinkedList<Beer> beers = new LinkedList<Beer>();
    private final LinkedList<Juice> juices = new LinkedList<Juice>();
    private final LinkedList<SetMeal> meals = new LinkedList<SetMeal>();
    // Answer:
    // 使用 LinkedList 也就是 链表结构 添加 和 删除 更为高效

    public West2FriedChickenRestaurant() {
            amount = 12; // 初始资金
            meals.add(
                    new SetMeal("SuperChicken",70.0,"WhiteChicken",
                            new Juice("Snow",4.0,
                                    LocalDate.of(2020,11,1)))
            );
            meals.add(
                new SetMeal("NiceChicken",50.0,"GreenChicken",
                        new Beer("Sun",4.0,
                                LocalDate.of(2020,10,1),10))
            );
            meals.add(
                new SetMeal("GoodChicken",30.0,"BlackChicken",
                        new Beer("Rain",4.0,
                                LocalDate.of(2020,10,1),10))
            );
    }

    private void use (Beer beer) {
        boolean success = false;
        LinkedList<Beer> dellist = new LinkedList<>();
        for (Beer value : beers) {
            if (value.isOverDate(LocalDate.now()))
                dellist.add(value);
        }
        beers.removeAll(dellist);
        for (int i=0;i<beers.size();i++)
            if (beers.get(i).equals(beer)) {
                beers.remove(i);
                success = true;
                break;
            }
        if (!success) throw new IngredientSortOutException(beer);
    }

    private void use (Juice juice) {
        boolean success = false;
        LinkedList<Juice> dellist = new LinkedList<>();
        for (Juice value : juices) {
            if (value.isOverDate(LocalDate.now()))
                dellist.add(value);
        }
        juices.removeAll(dellist);
        for (int i=0;i<juices.size();i++)
            if (juices.get(i).equals(juice)) {
                juices.remove(i);
                success = true;
                break;
            }
        if (!success) throw new IngredientSortOutException(juice);
    }


    @Override
    public void SellMeal(SetMeal meal) {
        Drinks drink = meal.getDrink();
        try {
            if (drink instanceof Beer)
                use((Beer) drink);
            else
                use((Juice) drink);
            amount += meal.getPrice();
        } catch (IngredientSortOutException e) {
            System.out.println("No "+e.getDrink());
        }
    }

    @Override
    public void GetGoods(LinkedList<Drinks> drinks) {
        try {
            for (Drinks drink : drinks){
                if (amount < drink.cost)
                    throw new OverdraftBalanceException(amount);
                else
                    amount -= drink.cost;
                if (drink instanceof Beer) {
                    beers.add((Beer) drink);
                    System.out.printf("Get a %s%n",drink.name);
                }
                else if (drink instanceof Juice){
                    juices.add((Juice) drink);
                    System.out.printf("Get a %s%n",drink.name);
                }
            }
        } catch (OverdraftBalanceException e) {
            System.out.printf("Only %.2f yuan. Cannot afford.%n",e.getAmount());
        }
    }

    public static void main(String[] args) {
        West2FriedChickenRestaurant west = new West2FriedChickenRestaurant();
        // 初始化中无 Version_Java.Drinks
        LinkedList<Drinks> initDrinks = new LinkedList<Drinks>();
        initDrinks.add(new Juice("Snow",4.0,
                LocalDate.of(2020,11,1)));
        initDrinks.add(new Beer("Sun",4.0,
                LocalDate.of(2020,11,6),10));
        initDrinks.add(new Beer("Rain",4.0,
                LocalDate.of(2020,11,6),10));
        west.GetGoods(initDrinks);
        west.SellMeal(new SetMeal("GoodChicken",30.0,"BlackChicken",
                new Beer("Rain",4.0,
                        LocalDate.of(2020,10,1),10)));
        west.SellMeal(new SetMeal("GoodChicken",30.0,"BlackChicken",
                new Beer("Rain",4.0,
                        LocalDate.of(2020,10,1),10)));
        west.GetGoods(initDrinks);
        west.GetGoods(initDrinks);
        west.GetGoods(initDrinks);
    }
}
