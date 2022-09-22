package SetsAndMapsAdvanced_7;

public class DemoSets2 {
    public static void main(String[] args) {

        String first="Hello from Java";
        String second="The quick brown fox";
        String third="jumps over the lazy dog";

        int firstHash=first.hashCode();
        int secondHash=second.hashCode();
        int thirdHash=third.hashCode();

        System.out.println(firstHash);
        System.out.println(secondHash);
        System.out.println(thirdHash);
    }
}
