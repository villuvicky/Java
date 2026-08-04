package patterns;

public class CharacterPattern {

    public static void main(String[] args) {

        int n = 3;

        /*
         * Q1: Print a pattern for a given N number of rows, where every
         * row prints the SAME sequence of letters: A, B, C, ... up to N
         * letters (column-based — same letter appears in the same column
         * on every row).
         *
         * Pattern for N = 3
         * ABC
         * ABC
         * ABC
         */
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= n; j++) {
                // 64 + j maps j=1,2,3... to 'A','B','C'... (ASCII 'A' = 65)
                char value = (char) (64 + j);
                System.out.print(value);
            }
            System.out.println();
        }


        System.out.println("*****************");


        /*
         * Q2: Print a pattern for a given N number of rows, where row i
         * repeats a SINGLE letter (based on the row number) N times
         * (row-based — one letter per row, unlike Q1 which was column-based).
         *
         * Pattern for N = 3
         * AAA
         * BBB
         * CCC
         */
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= n; j++) {
                // 64 + i stays constant for the whole row since i doesn't
                // change inside the inner loop
                char value = (char) (64 + i);
                System.out.print(value);
            }
            System.out.println();
        }

        System.out.println("*****************");


        /*
         * Q3: Print a pattern for a given N number of rows, where row i
         * starts from the i-th letter of the alphabet and prints N
         * consecutive letters from there (a "sliding window" of letters).
         *
         * Pattern for N = 3
         * ABC
         * BCD
         * CDE
         */
        for (int i = 1; i <= n; i++) {
            // starting letter shifts forward by one for each new row
            char ith = (char) (65 + i - 1);
            for (int j = 1; j <= n; j++) {

                System.out.print(ith);
                ith = (char) (ith + 1); // move to the next letter
            }
            System.out.println();
        }
        System.out.println("*****************");


        /*
         * Q4: Print a pattern for a given N number of rows, where the
         * letters keep advancing continuously across the ENTIRE grid
         * (not resetting per row) — an alphabet version of the
         * "continuously increasing number grid" pattern.
         *
         * IMPORTANT NOTE: "ch" is declared OUTSIDE the loop, so it is
         * never reset to 'A' between rows. This is exactly the same
         * behavior as the "count" variable used in the continuous number
         * patterns — declaring the counter outside the loop is what makes
         * the sequence continuous instead of restarting each row.
         *
         * ALSO NOTE: because "ch" is never reset after this block either,
         * it carries a leftover value ('J' for N=3, since 3x3=9 letters
         * were printed starting from 'A') into Q6 further down, where it
         * causes an unintended side effect — see the note on Q6.
         *
         * Pattern for N = 3
         * ABC
         * DEF
         * GHI
         */
        char ch = 'A';
        // int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= n; j++) {
                System.out.print(ch);
                ch++;
            }

            System.out.println();
        }
        System.out.println("*****************");


        /*
         * Q5: Print a pattern for a given N number of rows, where row i
         * contains the LAST i letters of the N-letter alphabet range
         * (row i shows letters counting up to 'A' + N - 1).
         *
         * NOTE: There is no leading-space padding in this loop (unlike the
         * star/number triangles earlier), so the rows are printed
         * left-aligned even though the letters conceptually represent a
         * "right-aligned" shrinking triangle — row 1 shows only the last
         * letter, and the final row shows the full alphabet range.
         *
         * Pattern for N = 3
         * C
         * BC
         * ABC
         */
        for (int i = 1; i <= n; i++) {
            char ch2 = 'A';
            // shift starting letter based on how many rows remain
            ch2 = (char) (ch2 + n - i);
            for (int j = 1; j <= i; j++) {
                System.out.print(ch2);
                ch2 = (char) (ch2 + 1);
            }
            System.out.println();
        }


        System.out.println("*****************");


        /*
         * Q6: Intended to print a left-aligned decreasing triangle of
         * letters (row i prints (i-1) letters counting down from the last
         * letter of the alphabet range).
         *
         * IMPORTANT BUG NOTE: "System.out.println(ch)" at the end of this
         * loop is printing the OUTER "ch" variable left over from Q4
         * (which ended at 'J' for N=3) instead of "ch3" (the variable
         * actually used inside this loop). This means every row gets an
         * extra stray 'J' character appended before the line break —
         * almost certainly a copy-paste typo. The fix is to change it to
         * "System.out.println();" (no argument) if no trailing letter is
         * wanted, or "System.out.println(ch3);" if the last computed
         * letter should be shown.
         *
         * ACTUAL output for N = 3 (with the bug, "ch" still holding 'J'):
         * J
         * CJ
         * CBJ
         *
         * INTENDED output (if fixed to System.out.println();):
         * (empty line)
         * C
         * CB
         */
        for (int i = 1; i <= n; i++) {
            char ch3 = (char) ('A' + n - 1); // resets to the last letter every row
            for (int j = 1; j < i; j++) {

                System.out.print(ch3);
                ch3--;

            }
            System.out.println(ch); // BUG: should reference ch3, not the outer ch
        }
    }

}