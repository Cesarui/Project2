import org.junit.Test;

public class Tester {
    @Test
    public void test() {
        int[] myNums = {1,0,1,0,1};

        Onion onion1 = new Onion(myNums);

        System.out.println(onion1);
    }
}
