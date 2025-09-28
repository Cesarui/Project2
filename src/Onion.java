// Cesar Pimentel & Baheeja Muntasser

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * The Onion class recursively flips the outer digits of a binary number
 * until a single digit is reached, then reconstructs the number with
 * flipped values. Designed for odd-length binary numbers only.
 */
public class Onion {
    private int[] digits; // original binary digits
    private int[] result; // flipped result

    /**
     * Recursively peels the binary number by removing outer digits,
     * flipping them, and reconstructing the number.
     *
     * @param digits The binary digits to process.
     * @return The flipped binary digits as an int array.
     */
    private int[] peel(int[] digits) {
        if (digits.length == 1) {
            return new int[]{flip(digits[0])};
        } else {
            int[] smallArr = new int[digits.length - 2];
            for (int i = 1; i < digits.length - 1; i++) {
                smallArr[i - 1] = digits[i];
            }

            Onion inner = new Onion(smallArr);
            int[] innerResult = inner.getResult();

            int[] full = new int[innerResult.length + 2];
            full[0] = flip(digits[0]);
            for (int i = 0; i < innerResult.length; i++) {
                full[i + 1] = innerResult[i];
            }
            full[full.length - 1] = flip(digits[digits.length - 1]);

            return full;
        }
    }

    /**
     * Constructs an Onion object and immediately processes the
     * provided binary digits.
     *
     * @param digits Odd-length array of binary digits.
     */
    public Onion(int[] digits) {
        this.digits = digits;
        this.result = peel(digits);
    }

    /**
     * Validates that the provided array has an odd number of digits.
     *
     * @param arr Array of binary digits.
     * @throws IllegalArgumentException if the number of digits is even or array is empty.
     */
    public static void checkOddLength(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("No input detected. Please enter binary digits.");
        }
        if (arr.length % 2 == 0) {
            throw new IllegalArgumentException("Number of digits must be odd!");
        }
    }

    /**
     * Flips a binary digit: 0 becomes 1, 1 becomes 0.
     *
     * @param number Binary digit to flip.
     * @return Flipped binary digit.
     */
    private int flip(int number) {
        return 1 - number;
    }

    /**
     * Returns the processed flipped binary number.
     *
     * @return Array of flipped binary digits.
     */
    public int[] getResult() {
        return result;
    }

    /**
     * Reads binary digits from an InputStream, until
     * a newline or carriage return is detected. Only 0 and 1 are allowed.
     *
     * @param in InputStream to read from.
     * @return Array of binary digits entered.
     * @throws IOException if reading from the InputStream fails.
     * @throws IllegalArgumentException if non-binary characters are entered or input is empty.
     */
    public static int[] readBinaryDigits(InputStream in) throws IOException {
        ArrayList<Integer> list = new ArrayList<>();
        int inputChar;

        while ((inputChar = in.read()) != -1) {
            if (inputChar == '0' || inputChar == '1') {
                list.add(inputChar - '0');
            } else if (inputChar == '\n' || inputChar == '\r') {
                break;
            } else if (!Character.isWhitespace(inputChar)) {
                throw new IllegalArgumentException("Only binary digits 0 or 1 are allowed.");
            }
        }

        if (list.isEmpty()) {
            throw new IllegalArgumentException("No input detected. Please enter binary digits.");
        }

        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    /**
     * Returns a string representation of the flipped binary number.
     *
     * @return String showing the flipped binary digits.
     */
    @Override
    public String toString() {
        return "Flipped: " + Arrays.toString(result);
    }
}
