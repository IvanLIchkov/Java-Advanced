package ExamDecember2020;

import java.util.*;

public class Cooking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] input = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        for (int i = 0; i < input.length; i++) {
            liquids.offer(input[i]);
        }
        input = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> ingredient = new ArrayDeque<>();
        for (int i = 0; i < input.length; i++) {
            ingredient.push(input[i]);
        }
        Map<String, Integer> products = new TreeMap<>();
        products.put("Bread", 0);
        products.put("Cake", 0);
        products.put("Fruit Pie", 0);
        products.put("Pastry", 0);
        while (liquids.size() != 0 && ingredient.size() != 0) {
            int sum = liquids.peek() + ingredient.peek();
            switch (sum) {
                case 25:
                    products.put("Bread", products.get("Bread") + 1);
                    liquids.remove();
                    ingredient.pop();
                    break;
                case 50:
                    products.put("Cake", products.get("Cake") + 1);
                    liquids.remove();
                    ingredient.pop();
                    break;
                case 75:
                    products.put("Pastry", products.get("Pastry") + 1);
                    liquids.remove();
                    ingredient.pop();
                    break;
                case 100:
                    products.put("Fruit Pie", products.get("Fruit Pie") + 1);
                    liquids.remove();
                    ingredient.pop();
                    break;
                default:
                    liquids.remove();
                    int ingredientBeforeIncrease = ingredient.peek();
                    ingredient.pop();
                    ingredient.addFirst(ingredientBeforeIncrease + 3);
                    break;
            }
        }
        if (products.entrySet().stream().noneMatch(p -> p.getValue().equals(0))) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
            printLiquids(liquids, ingredient);
            printProducts(products);
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
            printLiquids(liquids, ingredient);
            printProducts(products);
        }
    }

    private static void printProducts(Map<String, Integer> products) {
        products.entrySet().stream().forEach(p -> System.out.printf("%s: %d%n", p.getKey(), p.getValue()));
    }

    private static void printLiquids(ArrayDeque<Integer> liquids, ArrayDeque<Integer> ingredient) {
        if (liquids.size() == 0) {
            System.out.println("Liquids left: none");
        } else {
            System.out.print("Liquids left: ");
            String[] liquidAsString = liquids.stream().map(String::valueOf).toArray(String[]::new);
            System.out.println(String.join(", ", liquidAsString));
        }
        if (ingredient.size() == 0) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.print("Ingredients left: ");
            String[] ingredientsAsString = ingredient.stream().map(String::valueOf).toArray(String[]::new);
            System.out.println(String.join(", ", ingredientsAsString));
        }
    }
}
