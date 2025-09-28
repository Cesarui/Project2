// Cesar Pimentel & Baheeja Muntasser

import org.junit.Test;
import static org.junit.Assert.*;

public class Tester {

    @Test
    public void testBasicFlipping() {
        int[] digits = {1, 0, 1};
        Onion onion = new Onion(digits);
        int[] expected = {0, 1, 0};
        assertArrayEquals(expected, onion.getResult());
    }

    // This should throw an IllegalArgumentException since the digits length isn't odd.
    @Test(expected = IllegalArgumentException.class)
    public void testEvenLengthInput() {
        int[] digits = {1, 0, 1, 0};
        Onion.checkOddLength(digits);
    }

    @Test
    public void testSingleDigit() {
        int[] digits = {0};
        Onion onion = new Onion(digits);
        int[] expected = {1};
        assertArrayEquals(expected, onion.getResult());
    }
}

