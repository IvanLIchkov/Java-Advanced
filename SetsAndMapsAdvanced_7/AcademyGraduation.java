package SetsAndMapsAdvanced_7;

import java.text.DecimalFormat;
import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=Integer.parseInt(scan.nextLine());
        Map<String, double[]> studentAndGrades=new TreeMap<>();
        for (int i = 0; i <n ; i++) {
            String name= scan.nextLine();
            double[] grades= Arrays.stream(scan.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
            studentAndGrades.putIfAbsent(name,grades);

        }
        studentAndGrades.entrySet()
                .forEach(entry->{
                    double average=0;
                    for (double grade : entry.getValue()) {
                        average+=grade;
                    }
                    average/=entry.getValue().length;
                    DecimalFormat format=new DecimalFormat("#.###########################");
                    System.out.printf("%s is graduated with %s%n",entry.getKey(),format.format(average));

                });
    }
}
