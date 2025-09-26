import java.util.Arrays;

public class Onion {
    int[] digits;
    int[] result;

    private int[] Peel(int[] digits) {
        if (digits.length == 1) {
            return new int[] {flip(digits[0])};
        }
        else {
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

    public Onion(int[] digits) {
        this.digits = digits;
        this.result = Peel(digits);

    }

    public static void OddOrEven (int[] arr) {
        if (arr.length % 2 != 0) throw new IllegalArgumentException("Number of digits must be odd!");
    }

    private int flip(int number) {
        return 1 - number;
    }

    public int[] getResult() {
        return result;
    }

    public static int[] numIntoArray(int num) {
        String numString = String.valueOf(num);
        int[] newArr = new int[numString.length()];

        for (int i = 0; i < numString.length(); i++) {
            newArr[i] = numString.charAt(i) - '0';
            if (newArr[i] != 1 && newArr[i] != 0) {
                throw new IllegalArgumentException("Numbers can only be either 0 or 1");
            }
        }
        return newArr;
    }

    @Override
    public String toString() {
        return "Flipped: " + Arrays.toString(result);
    }

}
