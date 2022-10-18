package ExamFebrurary2022;

import java.util.*;
import java.util.stream.Collectors;

public class FoodFinder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input=scan.nextLine().split(" ");
        ArrayDeque<String> vowels=new ArrayDeque<>();
        for (String c : input) {
            vowels.offer(c);
        }
        input=scan.nextLine().split(" ");
        ArrayDeque<String> consonants=new ArrayDeque<>();
        for (String c : input) {
            consonants.push(c);
        }
        String[] words={"pear", "flour", "pork", "olive"};
        Set<String> usedLetters=new HashSet<>();
        while (consonants.size()!=0){
            String vowel= vowels.peek();
            vowels.pop();
            vowels.addLast(vowel);
            String consonant=consonants.peek();
            consonants.remove();
            for (String word : words) {
                if (word.contains(vowel)){
                   usedLetters.add(vowel);
                }if (word.contains(consonant)){
                    usedLetters.add(consonant);
                }
            }
        }
        Set<String> outputWords=new LinkedHashSet<>();
        for (String word : words) {
            for (int i = 0; i <word.length() ; i++) {
                List<String> wordAsArr= Arrays.stream(word.split("")).collect(Collectors.toList());
                if (usedLetters.containsAll(wordAsArr)){
                    outputWords.add(word);
                }
            }
        }
        System.out.printf("Words found: %d%n",outputWords.size());
        outputWords.forEach(System.out::println);
    }
}
