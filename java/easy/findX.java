/**
 *
 Given a value N. Find number of values X ( 1<=X<=N) which satisfy the equation.
 X + S(F(X)) + S(F(S(F(X))) = N
 where F(X) is a function which returns the product of digits of X, and S(X) is a function which returns sum of digits of X.

 Input:

 First line of test case contains an integer T, denoting number of the test cases. Each line of the test case contains an integer N.

 Output:

 For each of the test case print the answer in separate line.

 Constraints:
 1<=T<=10^4
 1<=N<=10^5

 Example:
 Input:
 1
 6

 Output:
 1
 */

package interview.interview.java.easy;

import java.util.*;
import java.lang.*;
import java.io.*;

class findX {
    private static HashMap<Integer, Integer> prodMap = new HashMap<>();
    private static HashMap<Integer, Integer> sumMap = new HashMap<>();
    private static HashMap<Integer, Integer> xMap = new HashMap<>();

    public static void main (String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("./src/interview/interview/java/easy/findX_input.txt"));
        int test_cases = sc.nextInt();

        for ( int i = 0; i < test_cases; i++ ) {
            System.out.println(findX(sc.nextInt()));
        }
    }

    public static int findX(int N) {
        int result = 0;

        for( int i = 1; i <= N; i++ ) {
            int value;
            if(xMap.containsKey(i)) {
                value = xMap.get(i);
            } else {
                value = i + sum(prod(i)) + sum(prod(sum(prod(i))));
                xMap.put(i, value);
            }

            if(value == N) {
                result++;
            }
        }
        return result;
    }

    public static int sum(int num) {
        if(sumMap.containsKey(num)) return sumMap.get(num);

        int value = 0;
        int orgNum = num;

        while(num != 0) {
            value += num % 10;
            num /= 10;
        }

        sumMap.put(orgNum, value);
        return value;
    }

    public static int prod(int num) {
        if(prodMap.containsKey(num)) return prodMap.get(num);
        if(num == 0) return num;

        int value = 1;
        int orgNum = num;

        while(num != 0) {
            value *= num % 10;
            num /= 10;
        }

        prodMap.put(orgNum, value);
        return value;
    }
}