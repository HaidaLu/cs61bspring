import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    OffByOne testOffByOne = new OffByOne();
    OffByN testOffByN = new OffByN(5);
    @Test
    public void testEqualChars() {
        char a = 'a';
        char a2 = 'a';

        //assertTrue(testOffByOne.equalChars(a, a2));
        //assertFalse(testOffByOne.equalChars(a,'b'));
        System.out.print(testOffByOne.equalChars('a', 'B'));
        //System.out.print(testOffByN.equalChars('a','f'));

    }
}
