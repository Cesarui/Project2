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
        if (digits.length % 2 == 0) throw new IllegalArgumentException("Array lenght must be odd");
        this.digits = digits;
        this.result = Peel(digits);

    }

    public int flip(int number) {
        if (number == 1) return 0;
        else return 1;
    }

    public int[] getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "Flipped: " + Arrays.toString(result);
    }

}
