package ExamAugust2021;

import java.util.*;
import java.util.stream.Collectors;

public class PastryShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] input = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        for (int i : input) {
            liquids.offer(i);
        }
        input = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        for (int i : input) {
            ingredients.push(i);
        }
        Map<String, Integer> foods = new LinkedHashMap<>();
        foods.put("Biscuit", 0);
        foods.put("Cake", 0);
        foods.put("Pie", 0);
        foods.put("Pastry", 0);
        while (liquids.size() != 0 && ingredients.size() != 0) {
            int sum = liquids.peek() + ingredients.peek();
            switch (sum) {
                case 25:
                    foods.put("Biscuit", foods.get("Biscuit") + 1);
                    liquids.remove();
                    ingredients.pop();
                    break;
                case 50:
                    foods.put("Cake", foods.get("Cake") + 1);
                    liquids.remove();
                    ingredients.pop();
                    break;
                case 75:
                    foods.put("Pastry", foods.get("Pastry") + 1);
                    liquids.remove();
                    ingredients.pop();
                    break;
                case 100:
                    foods.put("Pie", foods.get("Pie") + 1);
                    liquids.remove();
                    ingredients.pop();
                    break;
                default:
                    liquids.remove();
                    int value = ingredients.peek();
                    ingredients.pop();
                    ingredients.addFirst(value + 3);
            }
        }
        if (isCooked(foods)) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }
        if (liquids.size() == 0) {
            System.out.println("Liquids left: none");
        } else {
            System.out.print("Liquids left: ");
            printDeque(liquids);
        }
        if (ingredients.size() == 0) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.print("Ingredients left: ");
            printDeque(ingredients);
        }
        for (var food : foods.entrySet()) {
            System.out.printf("%s: %d%n", food.getKey(), food.getValue());
        }

    }

    private static void printDeque(ArrayDeque<Integer> deque) {
        System.out.println(deque.stream().map(e -> e + "").collect(Collectors.joining(", ")));

    }

    private static boolean isCooked(Map<String, Integer> foods) {
        if (foods.entrySet().stream().anyMatch(f -> f.getValue() == 0)) {
            return false;
        }
        return true;
    }
}
