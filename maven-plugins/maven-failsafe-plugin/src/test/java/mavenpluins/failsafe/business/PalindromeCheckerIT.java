package mavenpluins.failsafe.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
 * Failing tests will not break the build
 *
 * ---------------------------------------------------------------------------------
 * Naming
 * ---------------------------------------------------------------------------------
 * IT*.java, *IT.java, *ITCase.java
 *
 * ---------------------------------------------------------------------------------
 * Reports
 * ---------------------------------------------------------------------------------
 * plugin generates XML reports in the directory `target/failsafe-reports`
 *
 * ---------------------------------------------------------------------------------
 * Run with surefire
 * ---------------------------------------------------------------------------------
 * - mvn verify
 *
 */
class PalindromeCheckerIT {

    @Test
    void isPalindrome() {
        assertTrue(PalindromeChecker.isPalindrome(""));
    }
}