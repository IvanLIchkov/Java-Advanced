package ExamApril2022;

import java.util.*;
import java.util.stream.Collectors;

public class Blacksmith {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> steel = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(steel::offer);
        ArrayDeque<Integer> carbon = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(carbon::push);
        Map<String, Integer> swords = new TreeMap<>();
        swords.put("Gladius", 0);
        swords.put("Shamshir", 0);
        swords.put("Katana", 0);
        swords.put("Sabre", 0);
        while (steel.size() != 0 && carbon.size() != 0) {
            int sum = steel.peek() + carbon.peek();
            switch (sum) {
                case 70:
                    swords.put("Gladius", swords.get("Gladius") + 1);
                    steel.remove();
                    carbon.pop();
                    break;
                case 80:
                    swords.put("Shamshir", swords.get("Shamshir") + 1);
                    steel.remove();
                    carbon.pop();
                    break;
                case 90:
                    swords.put("Katana", swords.get("Katana") + 1);
                    steel.remove();
                    carbon.pop();
                    break;
                case 110:
                    swords.put("Sabre", swords.get("Sabre") + 1);
                    steel.remove();
                    carbon.pop();
                    break;
                default:
                    steel.remove();
                    int carbonValue = carbon.peek();
                    carbon.pop();
                    carbon.addFirst(carbonValue + 5);
                    break;
            }
        }
        int forgedNumber = swords.values().stream().mapToInt(i -> i).sum();
        if (forgedNumber > 0) {
            System.out.printf("You have forged %d swords.%n", forgedNumber);
        } else {
            System.out.println("You did not have enough resources to forge a sword.");
        }
        if (steel.size() == 0) {
            System.out.println("Steel left: none");
        } else {
            System.out.printf("Steel left: ");
            printDeque(steel);
        }
        if (carbon.size() == 0) {
            System.out.println("Carbon left: none");
        } else {
            System.out.printf("Carbon left: ");
            printDeque(carbon);
        }
        swords.entrySet().stream()
                .filter(s -> s.getValue() > 0)
                .forEach(s -> System.out.printf("%s: %d%n", s.getKey(), s.getValue()));
    }

    private static void printDeque(ArrayDeque<Integer> deque) {
        System.out.println(String.join(", ", deque.stream().map(e -> e + "").collect(Collectors.toList())));
    }
}
