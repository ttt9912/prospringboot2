package mavenplugins.verifier.business;

/*
 * checks for existence of this file and input-resources/welcome.txt
 * check is to the integration-thest phase
 * breaks the build if test fails
 *
 * ---------------------------------------------------------------------------------
 * Verifier file
 * ---------------------------------------------------------------------------------
 * Default location: src/test/verifier/verifications.xml
 * (change with `<verificationFile>` in `<configuration>` section)
 *
 * ---------------------------------------------------------------------------------
 * run
 * ---------------------------------------------------------------------------------
 * - click: Plugins -> verifier -> verifier:verify
 * - mvn verify
 */
public class VerfierPalindromeChecker {

    public static boolean isPalindrome(String inputString) {
        if (inputString.length() == 0) {
            return true;
        } else {
            char firstChar = inputString.charAt(0);
            char lastChar = inputString.charAt(inputString.length() - 1);
            String mid = inputString.substring(1, inputString.length() - 1);
            return (firstChar == lastChar) && isPalindrome(mid);
        }
    }

}
