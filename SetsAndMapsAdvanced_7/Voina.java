package SetsAndMapsAdvanced_7;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Voina {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

//        String[] split= scan.nextLine().split("\\s+");
//        Stream<String> stream= Arrays.stream(split);
//        Stream<Integer> intStream=stream.map(Integer::parseInt);
//        Set<Integer> firstDeck = intStream.collect(Collectors.toSet());//TODO stream API разбит за по-лесно разбиране.
        Set<Integer> firstDeck = Arrays.stream(scan.nextLine()
                        .split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        Set<Integer> secondDeck = Arrays.stream(scan.nextLine()
                        .split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        int rounds = 0;
        while (!firstDeck.isEmpty() && !secondDeck.isEmpty()) {
            rounds++;
            if (rounds == 50) {
                break;
            }
            Iterator<Integer> firstIterator = firstDeck.iterator();

            int firstCard = firstIterator.next();
            firstIterator.remove();

            Iterator<Integer> secondIterator = secondDeck.iterator();
            int secondCard =secondIterator.next();
            secondIterator.remove();

            if (firstCard>secondCard){
                firstDeck.add(firstCard);
                firstDeck.add(secondCard);
            }else if (secondCard>firstCard){
                secondDeck.add(firstCard);
                secondDeck.add(secondCard);
            }
        }
        if (firstDeck.size()> secondDeck.size()) {
            System.out.println("First player win!");
        }else if (secondDeck.size()> firstDeck.size()){
            System.out.println("Second player win!");
        }else{
            System.out.println("Draw");
        }
    }
}
