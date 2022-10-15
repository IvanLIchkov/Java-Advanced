package ExamJune2021;

import java.util.Scanner;

public class Python {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size=Integer.parseInt(scan.nextLine());
        String[] commands=scan.nextLine().split(", ");
        String[][] field=new String[size][size];
        for (int i = 0; i <size ; i++) {
            String[] line=scan.nextLine().split(" ");
            field[i]=line;
        }
        int sRow=0; int sCow=0;
        int numberOfFood=0;
        for (int row = 0; row < size; row++) {
            for (int cow = 0; cow < size; cow++) {
                if (field[row][cow].equals("s")){
                    sRow=row;
                    sCow=cow;
                }else if (field[row][cow].equals("f")){
                    numberOfFood++;
                }
            }
        }
        int pythonLength=1;
        for (int i = 0; i < commands.length; i++) {
            String command=commands[i];
            String letter="";
            field[sRow][sCow]="*";
            boolean isKilled=false;
            switch (command){
                case "up":
                    sRow--;
                    if (isInField(sRow,size)){
                        letter=field[sRow][sCow];
                        if (letter.equals("f")){
                            pythonLength++;
                            numberOfFood--;
                        }if (letter.equals("e")){
                            isKilled=true;
                        }
                    }else{
                        sRow=size-1;
                        letter=field[sRow][sCow];
                        if (letter.equals("f")){
                            pythonLength++;
                            numberOfFood--;
                        }if (letter.equals("e")){
                            isKilled=true;
                        }
                    }
                    break;
                case "down":
                    sRow++;
                    if (isInField(sRow,size)){
                        letter=field[sRow][sCow];
                        if (letter.equals("f")){
                            pythonLength++;
                            numberOfFood--;
                        }if (letter.equals("e")){
                            isKilled=true;
                        }
                    }else{
                        sRow=0;
                        letter=field[sRow][sCow];
                        if (letter.equals("f")){
                            pythonLength++;
                            numberOfFood--;
                        }if (letter.equals("e")){
                            isKilled=true;
                        }
                    }
                    break;
                case "right":
                    sCow++;
                    if (isInField(sCow,size)){
                        letter=field[sRow][sCow];
                        if (letter.equals("f")){
                            pythonLength++;
                            numberOfFood--;
                        }if (letter.equals("e")){
                            isKilled=true;
                        }
                    }else{
                        sCow=0;
                        letter=field[sRow][sCow];
                        if (letter.equals("f")){
                            pythonLength++;
                            numberOfFood--;
                        }if (letter.equals("e")){
                            isKilled=true;
                        }
                    }
                    break;
                case "left":
                    sCow--;
                    if (isInField(sCow,size)){
                        letter=field[sRow][sCow];
                        if (letter.equals("f")){
                            pythonLength++;
                            numberOfFood--;
                        }if (letter.equals("e")){
                            isKilled=true;
                        }
                    }else{
                        sCow=size-1;
                        letter=field[sRow][sCow];
                        if (letter.equals("f")){
                            pythonLength++;
                            numberOfFood--;
                        }if (letter.equals("e")){
                            isKilled=true;
                        }
                    }
                    break;
            }
            if (isKilled){
                System.out.println("You lose! Killed by an enemy!");
                return;
            }
            if (numberOfFood==0){
                System.out.println("You win! Final python length is "+pythonLength);
                return;
            }
        }if (numberOfFood>0) {
            System.out.println("You lose! There is still "+numberOfFood+" food to be eaten.");
        }
    }

    private static boolean isInField(int n, int size) {
        if (n>=0&&n<=size-1){
            return true;
        }else {
            return false;
        }
    }
}
