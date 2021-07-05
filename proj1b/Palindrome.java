public class Palindrome {

    /* Given a String, wordtoDeque should return a Deque
            where the characters appear in the same order as in the String
    *  For example, if the word is "persiflage",
        then the returned Deque should have 'p' at the front, followed by 'e', and so forth.
    * */
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> wordByCharactor = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            wordByCharactor.addLast(word.charAt(i));
        }
        return wordByCharactor;
    }
    public boolean isPalindrome(String word) {
        Deque<Character> wordDeque = wordToDeque(word);
        if (wordDeque.size() == 0 || wordDeque.size() == 1) {
            return true;
        }

        return isPalindromeRecursiveHelper(wordDeque);

    }

    private boolean isPalindromeRecursiveHelper(Deque<Character> wordDeque) {
        if (wordDeque.isEmpty() || wordDeque.size() == 1) {
            return true;
        }

        if (wordDeque.removeFirst() != wordDeque.removeLast()) {
            return false;
        }
        boolean isPal = isPalindromeRecursiveHelper(wordDeque);
        return isPal;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        int wordLength = word.length();
        if (wordLength == 0 || wordLength == 1) {
            return true;
        }
        for (int i = 0; 2 * i < wordLength - 1; i++) {
            if (!cc.equalChars(word.charAt(i), word.charAt(wordLength - 1 - i))) {
                return false;
            }
        }
        return true;
    }
}
