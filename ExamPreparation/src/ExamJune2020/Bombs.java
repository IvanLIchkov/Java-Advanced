package ExamJune2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Bombs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] first = Arrays.stream(scan.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> firstBomb = new ArrayDeque<>();
        for (int i : first) {
            firstBomb.offer(i);
        }
        int[] second = Arrays.stream(scan.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> secondBomb = new ArrayDeque<>();
        for (int i : second) {
            secondBomb.push(i);
        }
        int datura = 0;
        int cherry = 0;
        int decoy = 0;
        while (firstBomb.size() != 0 && secondBomb.size() != 0) {
            int sum = firstBomb.peek() + secondBomb.peek();
            switch (sum) {
                case 40:
                    datura++;
                    firstBomb.remove();
                    secondBomb.pop();
                    break;
                case 60:
                    cherry++;
                    firstBomb.remove();
                    secondBomb.pop();
                    break;
                case 120:
                    decoy++;
                    firstBomb.remove();
                    secondBomb.pop();
                    break;
                default:
                    int bombCasing = secondBomb.peek();
                    secondBomb.pop();
                    secondBomb.addFirst(bombCasing - 5);
                    break;
            }
            if (datura >= 3 && cherry >= 3 && decoy >= 3) {
                System.out.println("Bene! You have successfully filled the bomb pouch!");
                if (!firstBomb.isEmpty()) {
                    System.out.printf("Bomb Effects: ");
                    List<String> first1=firstBomb.stream().map(e->e.toString()).collect(Collectors.toList());
                    System.out.println(String.join(", ",first1));

                } else {
                    System.out.printf("Bomb Effects: empty%n");
                }
                if (!secondBomb.isEmpty()) {
                    System.out.printf("Bomb Casings: ");
                    List<String> second2=secondBomb.stream().map(e->e.toString()).collect(Collectors.toList());
                    System.out.println(String.join(", ",second2));
                } else {
                    System.out.printf("Bomb Casings: empty%n");
                }
                System.out.println("Cherry Bombs: "+cherry);
                System.out.println("Datura Bombs: "+datura);
                System.out.println("Smoke Decoy Bombs: "+decoy);
                return;
            }
        }
            System.out.println("You don't have enough materials to fill the bomb pouch.");
            if (!firstBomb.isEmpty()) {
                System.out.printf("Bomb Effects: ");
                List<String> first1=firstBomb.stream().map(e->e.toString()).collect(Collectors.toList());
                System.out.println(String.join(", ",first1));
            } else {
                System.out.printf("Bomb Effects: empty%n");
            }
            if (!secondBomb.isEmpty()) {
                System.out.printf("Bomb Casings: ");
                List<String> second2=secondBomb.stream().map(e->e.toString()).collect(Collectors.toList());
                System.out.println(String.join(", ",second2));
            } else {
                System.out.printf("Bomb Casings: empty%n");
            }
            System.out.println("Cherry Bombs: " + cherry);
            System.out.println("Datura Bombs: " + datura);
            System.out.println("Smoke Decoy Bombs: " + decoy);
        }
    }
