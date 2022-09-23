package SetsAndMapsAdvanced_7;

import java.util.*;
import java.util.stream.Stream;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=Integer.parseInt(scan.nextLine());
        Map<String, List<Double>> students=new TreeMap<>();
        while (n-- >0) {
            String[] input = scan.nextLine().split("\\s+");
            String studName = input[0];
            double studGrade = Double.parseDouble(input[1]);
            students.putIfAbsent(studName, new ArrayList<>());
            List<Double> grades = students.get(studName);
            grades.add(studGrade);
        }

        students.entrySet()
                .forEach(entry->{
                    String name= entry.getKey();
                    List<Double> grades=entry.getValue();
                    double average=0;
                    for (Double grade : grades) {
                        average+=grade;
                    }
                    average/=grades.size();
                    System.out.printf("%s -> ",name);
                    for (Double grade : grades) {
                        System.out.printf("%.2f ",grade);
                    }
                    System.out.printf("(avg: %.2f)",average);
                    System.out.println();
                });
    }
}
