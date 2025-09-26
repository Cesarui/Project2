// Cesar Pimentel & Baheeja Muntasser

import java.util.Scanner;

public class Project2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Type the number you'd like to flip: ");
        int userNum = scanner.nextInt();

        int[] userNumArr = Onion.numIntoArray(userNum);

        Onion onion1 = new Onion(userNumArr);

        System.out.println(onion1);

    }
}
