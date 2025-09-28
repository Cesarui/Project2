// Cesar Pimentel & Baheeja Muntasser

import java.io.IOException;

public class Project2 {
    public static void main(String[] args) throws IOException {
        try {
            System.out.print("Enter an odd-length binary number: ");
            int[] digits = Onion.readBinaryDigits(System.in);
            Onion.checkOddLength(digits);

            Onion onion = new Onion(digits);
            System.out.println(onion);

        } catch (IOException e) {
            System.out.println("Error reading input: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: " + e.getMessage());
        }
    }
}
