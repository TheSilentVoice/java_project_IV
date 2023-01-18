import java.util.Timer;
import java.util.concurrent.*;

public class resources {

    static double mana_value;
    static double wood_value;
    static double food_value;

    static double wood_cabins;
    static double cabin_cost;
    static double wood_cap=20;
    static double deposit_cost;


    static double farms;
    static double farm_cost;
    static double food_cap=20;
    static double stock_cost;


    static double pop_value;
    static double pop_cap=40;

    static double church_level = 1;
    static double church_cost;
    static double hall_level=1;

    private static final ScheduledExecutorService sch = Executors.newSingleThreadScheduledExecutor();
;
    public static void increment_mana () {
        mana_value = mana_value + church_level;
    }

    public static void increment_wood () {
        if(wood_value <= wood_cap){
        wood_value = wood_value +1*wood_cabins;
        }
    }

    public static void increment_food (){
        if(food_value <= food_cap) {
            food_value = food_value + 1 * farms;
        }
    }

    public static void increment_pop(){
        if(pop_value <= pop_cap) {
            pop_value = pop_value + 0.25 * wood_value + hall_level + food_value * 1.25;
        }
    }
    public static void buy_farms(){
        if(mana_value >= farm_cost){
            mana_value = mana_value - farm_cost;
            farms++;
            farm_cost = farm_cost + cabin_cost*0.5;
        }
    }

    public static void buy_wood_cabins(){
        if(mana_value >= cabin_cost){
            mana_value = mana_value - cabin_cost;
            wood_cabins++;
            cabin_cost = cabin_cost + 2;
        }
    }


    public static void buy_church(){
        if(mana_value >= church_cost && wood_value >= church_cost) {
            wood_value = wood_value - church_cost;
            mana_value = mana_value - church_cost;
            church_level = church_level + 1;
            church_cost = 50* church_level;
        }
    }

    public static void buy_homes(){
        if(mana_value >= pop_value){
            mana_value = mana_value - pop_value;
            wood_value = wood_value * 0.5;
            food_value = food_value * 0.15;
            increment_pop();
        }
    }
    public static void buy_hall(){
        if(pop_value >= hall_level*30){
            hall_level++;
            wood_value = wood_value * 0.25;
            mana_value = 0;
            food_cap = food_cap / pop_cap;
            pop_cap = pop_cap + 30;
        }
    }

    public static void buy_wood_deposit(){
        if(wood_value > 0 && wood_value >= deposit_cost) {
            wood_value = wood_value - deposit_cost;
            deposit_cost = wood_cap / wood_value;
            wood_cap = wood_cap + 20;
        }
    }

    public static void buy_food_stocks(){
        if(food_value > 0 && wood_value >= stock_cost) {
            wood_value = wood_value - stock_cost;
            stock_cost = food_cap / food_value;
            food_cap = food_cap + 20;
        }
    }



}
