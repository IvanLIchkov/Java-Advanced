package SetsAndMapsAdvanced_7;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String reservation = scan.nextLine();
        TreeSet<String> guests = new TreeSet<>();


        while (!reservation.equals("PARTY")) {

                guests.add(reservation);



            reservation = scan.nextLine();
        }
        String guestReservation = scan.nextLine();
        while (!guestReservation.equals("END")) {
            guests.remove(guestReservation);


            guestReservation = scan.nextLine();
        }
        System.out.println(guests.size());
        if (!guests.isEmpty()) {
            System.out.println(String.join(System.lineSeparator(), guests));
        }
    }
}
