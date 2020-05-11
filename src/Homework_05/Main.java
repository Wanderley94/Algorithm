package Homework_05;

import java.util.ArrayList;
import java.util.List;

public class Main {
   //task_01
   public static float summ = 1;
   public static int degree_recursion = 0;
   public static float temp = 1;

   //task_02
   private Item[] items;
   private int capacity;



    public static List<Item> list;
    public static List<Item> comb_fill_backpack;


    public static void main(String[] args) {

       testExponentiation(2, 0); // task_01
       testKnapsack(); //task_02
    }

    private static void testKnapsack() {

        Item[] items = {new Item("Ноутбук", 4, 12),
                new Item("Бинокль", 2, 1),
                new Item("МP3 плеер", 2, 2),
                new Item("Детская игрушка", 1, 1),
                new Item("Телевизор", 10, 4)};

        Knapsack knapsack = new Knapsack(items, 15);
        knapsack.display();
        Solution solution = knapsack.solve();
        solution.display();


    }

    public static void testExponentiation(int number, int degree) {
        System.out.println(Exponentiation(number, degree));
    }

    private static float Exponentiation(int number, int degree) {

        if (degree == 0) {
            return summ;
        }
        else if (degree < 0){
            temp = temp * number;
            summ = 1/(temp) ;
            degree_recursion = degree + 1;
        }else {
            summ = summ * number;
            degree_recursion = degree - 1;
        }
        return Exponentiation(number, degree_recursion);
    }

}




