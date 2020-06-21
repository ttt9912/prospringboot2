package mavenplugins.compiler.business;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/*
 * see PalindromeChecker
 */
class PalindromeCheckerTest {

    @Test
    void isPalindrome() {
        assertTrue(PalindromeChecker.isPalindrome(""));
    }
}