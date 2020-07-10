package mavenplugins.compiler.business;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/*
 * see PalindromeChecker
 */
class CompilerPalindromeCheckerTest {

    @Test
    void isPalindrome() {
        assertTrue(CompilerPalindromeChecker.isPalindrome(""));
    }
}