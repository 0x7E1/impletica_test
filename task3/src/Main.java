import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * @author mr_robot
 * @project impletica_test
 * @since 5/19/17
 */

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.print("Enter factorial (number): ");
            int f = Integer.parseInt(reader.readLine());

            BigInteger factorial = findFactorial(f);
            System.out.println("Factorial " + f + "! = " + factorial);

            int result = sumOfDigits(deleteZeros(factorial.toString()));

            System.out.println("Sum of the digits in " + f + "! = " + result);
        } catch (IOException | NumberFormatException e) {
            System.err.println("ERROR! Invalid input data.\n");
        }
    }

    /**
     * findFactorial method calculate factorial for input number (n) and returns this value.
     * @param n takes value of the factorial (e.g. number 100 means as 100!).
     * @return calculated value of the factorial (in BigInteger type).
     */
    private static BigInteger findFactorial(int n)
    {
        BigInteger factorial;

        if (n == 0) return BigInteger.ONE;
        factorial = BigInteger.valueOf(n).multiply(findFactorial(n-1));
        return factorial;
    }

    /**
     * sumOfDigits method just sum all the digits up of the factorial value.
     * @param source takes string value of factorial (in this case after all zeros deleting).
     * @return the value of the int type of all summed digits.
     */
    private static int sumOfDigits(String source) {
        int result = 0;

        for (int i = 0; i < source.length(); i++) {
            String temp = String.valueOf(source.charAt(i));
            result += Integer.parseInt(temp);
        }

        return result;
    }

    /**
     * deleteZeros method delete all zeros in the calculated factorial and this way preparing it to sumOfDigits method
     * without useless digits (zeros) for more optimization.
     * @param s is source string. Value of factorial for a start convert to the String type
     *          and then transmitting to this method like a parameter [s].
     * @return new string of digits already without zeros.
     */
    private static String deleteZeros(String s) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp != 48) //0 in ASCII is 48. 48 can be replaced by '0'
                builder.append(temp);
        }

        return builder.toString();
    }
}
