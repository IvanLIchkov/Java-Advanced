package ExamOctober2021;

import java.util.*;

public class AutumnCocktails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] input = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        for (int i : input) {
            ingredients.offer(i);
        }
        input = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> freshness = new ArrayDeque<>();
        for (int i : input) {
            freshness.push(i);
        }
        Map<String, Integer> cocktails = new TreeMap<>();
        cocktails.put("Pear Sour", 0);
        cocktails.put("The Harvest", 0);
        cocktails.put("Apple Hinny", 0);
        cocktails.put("High Fashion", 0);
        while (ingredients.size() != 0 && freshness.size() != 0) {
            if (ingredients.peek() != 0) {
                int level = ingredients.peek() * freshness.peek();
                switch (level) {
                    case 150:
                        cocktails.put("Pear Sour", cocktails.get("Pear Sour") + 1);
                        ingredients.remove();
                        freshness.pop();
                        break;
                    case 250:
                        cocktails.put("The Harvest", cocktails.get("The Harvest") + 1);
                        ingredients.remove();
                        freshness.pop();
                        break;
                    case 300:
                        cocktails.put("Apple Hinny", cocktails.get("Apple Hinny") + 1);
                        ingredients.remove();
                        freshness.pop();
                        break;
                    case 400:
                        cocktails.put("High Fashion", cocktails.get("High Fashion") + 1);
                        ingredients.remove();
                        freshness.pop();
                        break;
                    default:
                        freshness.pop();
                        int temp = ingredients.peek();
                        ingredients.remove();
                        ingredients.addLast(temp + 5);
                        break;
                }
            } else {
                ingredients.remove();
            }
        }
        if (cocktails.entrySet().stream().anyMatch(c->c.getValue()==0)){
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }else{
            System.out.println("It's party time! The cocktails are ready!");
        }
        if (ingredients.size()>0){
            int sumIngredients=ingredients.stream().reduce(0,Integer::sum);
            System.out.printf("Ingredients left: %d%n",sumIngredients);
        }
        cocktails.entrySet().stream().filter(c->c.getValue()!=0).forEach(c-> System.out.printf(" # %s --> %d%n",c.getKey(),c.getValue()));
    }
}
