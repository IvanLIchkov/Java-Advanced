package RetakeExamDec2019;

import java.util.*;
import java.util.stream.Collectors;

public class SantaPresentFactory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> materials = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> magicValues = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        int i = materials.size() - 1;
        int j = 0;
        Map<String, Integer> presents=new TreeMap<>();
        while (i >= 0 && j <= magicValues.size() - 1) {
            int result = materials.get(i) * magicValues.get(j);
            if (result < 0) {
                result = materials.get(i) + magicValues.get(j);
                materials.remove(i);
                magicValues.remove(j);
                materials.add(result);
            } else if (materials.get(i) == 0 && magicValues.get(j) == 0) {
                materials.remove(i);
                magicValues.remove(j);
                i--;
            } else if (materials.get(i) == 0) {
                materials.remove(i);
                i--;
            } else if (magicValues.get(j) == 0) {
                magicValues.remove(j);
            } else {
                switch (result) {
                    case 150:
                        materials.remove(i);
                        magicValues.remove(j);
                        i--;
                        if (presents.containsKey("Doll")){
                            presents.put("Doll",presents.get("Doll")+1);
                        }else{
                            presents.put("Doll",1);
                        }
                        break;
                    case 250:
                        materials.remove(i);
                        magicValues.remove(j);
                        i--;
                        if (presents.containsKey("Wooden train")){
                            presents.put("Wooden train",presents.get("Wooden train")+1);
                        }else{
                            presents.put("Wooden train",1);
                        }
                        break;
                    case 300:
                        materials.remove(i);
                        magicValues.remove(j);
                        i--;
                        if (presents.containsKey("Teddy bear")){
                            presents.put("Teddy bear",presents.get("Teddy bear")+1);
                        }else{
                            presents.put("Teddy bear",1);
                        }
                        break;
                    case 400:
                        materials.remove(i);
                        magicValues.remove(j);
                        i--;
                        if (presents.containsKey("Bicycle")){
                            presents.put("Bicycle",presents.get("Bicycle")+1);
                        }else{
                            presents.put("Bicycle",1);
                        }
                        break;
                    default:
                        magicValues.remove(j);
                        materials.set(i,materials.get(i)+15);
                        break;

                }
            }
        }
        if (presents.get("Doll")!=null&&presents.get("Wooden train")!=null|| presents.get("Teddy bear")!=null&& presents.get("Bicycle")!=null){
            System.out.printf("The presents are crafted! Merry Christmas!%n");
            if (!materials.isEmpty()){
                System.out.printf("Materials left: ");
                List<String> collect = materials.stream().map(String::valueOf).collect(Collectors.toList());
                Collections.reverse(collect);
                System.out.print(String.join(", ",collect));
                System.out.println();
            }else if (!magicValues.isEmpty()) {
                System.out.printf("Magic left: ");
                List<String> collect = magicValues.stream().map(String::valueOf).collect(Collectors.toList());
                Collections.reverse(collect);
                System.out.print(String.join(", ", collect));
                System.out.println();
            }
            for (Map.Entry<String, Integer> stringIntegerEntry : presents.entrySet()) {
                System.out.println(stringIntegerEntry.getKey()+": "+stringIntegerEntry.getValue());
            }

        }else{
            System.out.println("No presents this Christmas!");
            if (!materials.isEmpty()){
                System.out.printf("Materials left: ");
                List<String> collect = materials.stream().map(String::valueOf).collect(Collectors.toList());
                Collections.reverse(collect);
                System.out.print(String.join(", ",collect));
                System.out.println();
            }else if (!magicValues.isEmpty()) {
                System.out.printf("Magic left: ");
                List<String> collect = magicValues.stream().map(String::valueOf).collect(Collectors.toList());
                Collections.reverse(collect);
                System.out.print(String.join(", ", collect));
                System.out.println();
            }
            for (Map.Entry<String, Integer> stringIntegerEntry : presents.entrySet()) {
                System.out.println(stringIntegerEntry.getKey()+": "+stringIntegerEntry.getValue());
            }
        }

    }
}
