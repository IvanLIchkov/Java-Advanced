package ExamJune2022;

import java.util.*;

public class ItsChocolateTime {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Double> milk = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split(" ")).mapToDouble(Double::parseDouble).forEach(milk::offer);
        ArrayDeque<Double> cacao = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split(" ")).mapToDouble(Double::parseDouble).forEach(cacao::push);
        Map<String, Integer> chocolates = new TreeMap<>();
        chocolates.put("Milk Chocolate", 0);
        chocolates.put("Dark Chocolate", 0);
        chocolates.put("Baking Chocolate", 0);

        while (milk.size() != 0 && cacao.size() != 0) {
            double sum = cacao.peek() / (cacao.peek() + milk.peek()) * 100;
            if (sum == 30 || sum == 50 || sum == 100) {
                cacao.remove();
                milk.pop();
                if (sum == 30.0) {
                    chocolates.put("Milk Chocolate", chocolates.get("Milk Chocolate") + 1);
                } else if (sum == 50.0) {
                    chocolates.put("Dark Chocolate", chocolates.get("Dark Chocolate") + 1);
                } else {
                    chocolates.put("Baking Chocolate", chocolates.get("Baking Chocolate") + 1);
                }
            } else {
                cacao.remove();
                double tempMilkValue = milk.peek();
                milk.pop();
                milk.addLast(tempMilkValue + 10);
            }
        }
        if (chocolates.entrySet().stream().noneMatch(c -> c.getValue() == 0)) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }
        chocolates.entrySet().stream().filter(c -> c.getValue() > 0).forEach(c -> System.out.printf(" # %s --> %d%n", c.getKey(), c.getValue()));
    }
}
