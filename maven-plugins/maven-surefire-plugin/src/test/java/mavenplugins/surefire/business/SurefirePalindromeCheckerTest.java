package mavenplugins.surefire.business;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/*
 * Failing tests immediately break the build
 *
 * ---------------------------------------------------------------------------------
 * Naming
 * ---------------------------------------------------------------------------------
 * Test*.java, *Test.java, *Tests.java, *TestCase.java
 *
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
 */
class SurefirePalindromeCheckerTest {

    @Test
    void isPalindrome() {
        assertTrue(SurefirePalindromeChecker.isPalindrome(""));
    }
}