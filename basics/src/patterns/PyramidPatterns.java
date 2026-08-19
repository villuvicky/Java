package patterns;

public class PyramidPatterns {

    public static void main(String[] args) {

        int n = 4;

        /*
         * Q1: Print a right-aligned triangle of stars for a given N number
         * of rows, where row i contains i stars separated by spaces,
         * padded on the left with (N-i) spaces.
         *
         * Pattern for N = 4
         *    *
         *   * *
         *  * * *
         * * * * *
         */
        for (int i = 1; i <= n; i++) {
            // print leading spaces to right-align the row
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            // print i stars, each followed by a space
            for (int j = 1; j <= i; j++) {
                System.out.print("*" + " ");
            }
            System.out.println();
        }

        System.out.println("********** Q1 **********");


        /*
         * Q2: Print a right-aligned triangle of stars for a given N number
         * of rows, where row i contains i stars with NO space between them,
         * padded on the left with (N-i) spaces.
         *
         * Pattern for N = 4
         *    *
         *   **
         *  ***
         * ****
         */
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("********** Q2 **********");


        /*
         * Q3: Print a right-aligned number pyramid for a given N number of
         * rows, where the numbers keep increasing continuously across rows
         * (not resetting per row), and row i has (2*i - 1) numbers.
         *
         * Pattern for N = 4
         *              1
         *            2 3 4
         *          5 6 7 8 9
         *      10 11 12 13 14 15  16 
         */
        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            // row i has (2*i - 1) numbers, counting continues from previous row
            for (int j = 1; j <= 2 * i - 1; j++) {
                count = count + 1; 
                System.out.print(count);
            }
            System.out.println();
        }

        System.out.println("********** Q3 **********");


        /*
         * Q4: Print a right-aligned number pyramid for a given N number of
         * rows, where each row restarts counting from 1 up to (2*i - 1).
         *
         * Pattern for N = 4
         *        1
         *      123
         *    12345
         *  1234567
         */
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            // resets to 1 at the start of every row
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print(j);
            }
            System.out.println();
        }

        System.out.println("********** Q4 **********");


        /*
         * Q5: Print a right-aligned pyramid for a given N number of rows,
         * where row i repeats the row number i exactly (2*i - 1) times.
         *
         * Pattern for N = 4
         *        1
         *      222
         *    33333
         *  4444444
         */
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print(i);
            }
            System.out.println();
        }

        System.out.println("********** Q5 **********");


        /*
         * Q6: Print a right-aligned triangle for a given N number of rows,
         * where row i repeats the row number i, i times, separated by
         * spaces, padded on the left with (N-i) spaces.
         *
         * Pattern for N = 4
         *    1
         *   2 2
         *  3 3 3
         * 4 4 4 4
         */
        for (int i = 1; i <= n; i++) {

            // Print leading spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            // Print numbers
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }

            // Move to next line
            System.out.println();

        }

        System.out.println("********** Q6 **********");


        /*
         * Q7: Print a left-aligned triangle for a given N number of rows,
         * where row i counts down from i to 1.
         *
         * Pattern for N = 4
         * 1
         * 21
         * 321
         * 4321
         */
        for (int i = 1; i <= n; i++) {
            for (int j = i; j >= 1; j--) {
                System.out.print(j);
            }
            System.out.println();
        }

        System.out.println("********** Q7 **********");


        /*
         * Q8: Print an inverted right-angled triangle of stars for a given
         * N number of rows, where row i is padded with (i-1) leading spaces
         * and then filled with stars from column i to N.
         *
         * Pattern for N = 4
         * * * * *
         *  * * *
         *   * *
         *    *
         */
        for (int i = 1; i <= n; i++) {

            // leading spaces increase as i increases
            for (int j = 1; j < i; j++) {
                System.out.print(" ");
            }
            // stars printed from position i to n (shrinks each row)
            for (int j = i; j <= n; j++) {
                System.out.print("* ");
            }
   
            System.out.println();
        }

        System.out.println("********** Q8 **********");


        /*
         * Q9: Print a right-aligned star pyramid for a given N number of
         * rows, where row i has (2*i - 1) stars padded with (N-i) leading
         * spaces (classic pyramid shape).
         *
         * Pattern for N = 4
         *    *
         *   ***
         *  *****
         * *******
         */
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("********** Q9 **********");


        /*
         * Q10: Print Pascal's Triangle for a given N number of rows using
         * the binomial coefficient formula, where each value is derived
         * from the previous value in the same row:
         * next = current * (i - j) / (j + 1)
         *
         * Pattern for N = 4
         *    1
         *   1 1
         *  1 2 1
         * 1 3 3 1
         */
        for (int i = 0; i < n; i++) {
            int number = 1; // first value in every row is always 1

            // leading spaces to center-align the triangle
            for (int space = 0; space < n - i - 1; space++) {
                System.out.print(" ");
            }

            // compute and print each binomial coefficient in row i
            for (int j = 0; j <= i; j++) {
                System.out.print(number + " ");
                number = number * (i - j) / (j + 1); // formula for next coefficient
            }

            System.out.println();
        }

        System.out.println("********** Q10 **********");


        /*
         * Q11: Print a left-aligned triangle of stars for a given N number
         * of rows, where row i contains exactly i stars.
         *
         * Pattern for N = 4
         * *
         * **
         * ***
         * ****
         */
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("********** Q11 **********");


        /*
         * Q12: Print an inverted right-angled triangle of stars for a given
         * N number of rows, where row i has (i-1) leading spaces and then
         * stars filled from column i to N.
         *
         * NOTE: This looks similar to Q8 above, but here stars are printed
         * WITHOUT a trailing space between them (System.out.print("*") vs
         * "* "), so the visual width per row is smaller. Always check
         * whether the expected output has spaces between stars before
         * copying loop conditions.
         *
         * Pattern for N = 4
         * ****
         *  ***
         *   **
         *    *
         */
        for (int i = 1; i <= n; i++) {

            // leading spaces increase as i increases (i-1 spaces)
            for (int j = 1; j < i; j++) {
                System.out.print(" ");
            }
            // stars printed from column i to n -> row shrinks each time
            for (int j = i; j <= n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("********** Q12 **********");


        /*
         * Q13: Print a solid N x N square filled entirely with stars.
         *
         * Pattern for N = 4
         * ****
         * ****
         * ****
         * ****
         */
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("********** Q13 **********");


        /*
         * Q14: Print an inverted left-aligned triangle of stars for a given
         * N number of rows, where row i contains (N - i + 1) stars
         * (the first row has the most stars, decreasing by 1 each row).
         *
         * NOTE: The loop bound "n - i + 1" is a common source of off-by-one
         * mistakes. Compare with Q11: Q11 grows with i (n-i not needed),
         * while this pattern sh rinks with i, hence n-i+1 (the "+1" ensures
         * the LAST row still prints exactly 1 star instead of 0).
         *
         * Pattern for N = 4
         * ****
         * ***
         * **
         * *
         */
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("********** Q14 **********");
    }
}