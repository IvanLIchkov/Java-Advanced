package FunctionalProgramming_12_exc;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class FunctionalProgramingDemoExc {
    public static void main(String[] args) {
        //Lambdas
        Function<String, Integer> myFunc = Integer::parseInt;
        BiFunction<String, Integer, Integer>biFunction= (text, number)->text.length()+number;

        //UnaryOperator<T>==Function<T, T> каквото приема унарния оператор това и връща
        Function<String, String> func = s -> s + "Bravo";
        UnaryOperator<String> unary = s -> s + "Bravo";
        BinaryOperator<String> binaryOperator=(text, text2)->text+text2;

        Predicate<String> pred=s->s.equals("Pesho");
        BiPredicate<String, Integer> biPredicate=(text, number)->text.length()>number;

        Supplier<String> sup=()-> "Gosho";

        Consumer<String> prin=s -> System.out.println(s);
        BiConsumer<String, Integer> biConsumer=(text, number)-> System.out.println(text+number);


        //TODO create functional interface
        SimpleFunctionalInterfaceDemo text=(String myText)-> Integer.parseInt(myText);
        System.out.println(text.parse("12"));

        // Разлика между функция и метод- разликата е че метода винаги е обварзан с даден клас

        //TODO other functions
        ToIntFunction<String> toIntFunction=s->Integer.parseInt(s);
        Function<String, Integer> intFunction=s-> Integer.parseInt(s);
        List<String> numbers=new ArrayList<>();
        numbers.add("1");
        numbers.add("2");
        numbers.add("3");
//        numbers.stream().map(intFunction) Stream<Integer>
//        numbers.stream().mapToInt(toIntFunction) IntStream //TODO долния стрийм връща малкия int(примитивния) а другия големия Integer
        //разликата е че примитивните стриймове имат различни методи
    }
    //Function<приема, връща>
    //UnaryOperator<Приема/връща (същия тип който приема го и връща)>
    //Predicate<приема> връща boolean
    //Supplier<връща>
    //Consumer<приема> не връща нищо
}
