package mavenplugins.surefire.business;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/*
 * ---------------------------------------------------------------------------------
 * Reports
 * ---------------------------------------------------------------------------------
 * plugin generates XML reports in the directory `target/surefire-reports`
 *
 * ---------------------------------------------------------------------------------
 * Run with surefire
 * ---------------------------------------------------------------------------------
 * - click: Plugins -> surefire -> surefire:test
 * - mvn test
 *
 */
class PalindromeCheckerTest {

    @Test
    void isPalindrome() {
        assertTrue(PalindromeChecker.isPalindrome(""));
    }
}