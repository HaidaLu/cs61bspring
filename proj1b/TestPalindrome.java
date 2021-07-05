import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testisPalindrome() {
        //Deque polindromeWord = palindrome.wordToDeque("racecar");
        boolean actual1 = palindrome.isPalindrome("racecar");
        assertTrue(actual1);

        boolean actual2 = palindrome.isPalindrome("a");
        assertTrue(actual2);

        boolean actual3 = palindrome.isPalindrome("aaab");
        assertFalse(actual3);


    }

    @Test
    public void testIsPalindromeOffByOne() {
        //Deque polindromeWord = palindrome.wordToDeque("racecar");
        OffByOne obo = new OffByOne();
        boolean actual1 = palindrome.isPalindrome("flake", obo);
        assertTrue(actual1);

        //boolean actual2 = palindrome.isPalindrome("a", obo);
        //assertTrue(actual2);

        //boolean actual3 = palindrome.isPalindrome("aaab", obo);
        //assertFalse(actual3);


    }
}
