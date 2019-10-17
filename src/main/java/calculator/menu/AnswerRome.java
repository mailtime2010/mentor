package calculator.menu;

import calculator.operators.Actions;

/**
 * AnswerRome.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/17/2019
 */
class AnswerRome extends AnswersStore {
    /**
     * Method to get the calculate result.
     *
     * @param menu  the menu
     * @param split the data array
     * @return the result
     */
    public final String getResult(final Menu menu, final String[] split) {
        final Actions action = menu.getAction(split[2]);
        final var o1 = menu.getRomes().get(split[0]);
        final var o2 = menu.getRomes().get(split[1]);
        final int one = Integer.parseInt(o1);
        final int two = Integer.parseInt(o2);
        final String tmp = String.valueOf(action.execute(one, two));
        return this.getRomeNumber(tmp);
    }

    /**
     * Method to to get the romes numbers.
     *
     * @param aTmp a tmp arab number
     * @return a result by a roman number.
     */
    private String getRomeNumber(final String aTmp) {
        final int number = Integer.parseInt(aTmp);
        return convert(number);
    }

    /**
     * Method to compute the roman digit.
     *
     * @param n     a count the numbers in tmp data
     * @param ones  the Ones
     * @param fives the Fives
     * @param tens  the Tens
     * @return roman numbers
     */
    private String romanDigit(final int n, final String ones,
                              final String fives, final String tens) {
        final int one = 1;
        final int two = 2;
        final int three = 3;
        final int four = 4;
        final int five = 5;
        final int six = 6;
        final int seven = 7;
        final int eight = 8;
        final int nine = 9;

        if (n >= one) {
            if (n == one) {
                return ones;
            } else if (n == two) {
                return ones + ones;
            } else if (n == three) {
                return ones + ones + ones;
            } else if (n == four) {
                return ones + fives;
            } else if (n == five) {
                return fives;
            } else if (n == six) {
                return fives + ones;
            } else if (n == seven) {
                return fives + ones + ones;
            } else if (n == eight) {
                return fives + ones + ones + ones;
            } else if (n == nine) {
                return ones + tens;
            }

        }
        return "";
    }

    /**
     * Method to convert data to the rome numbers.
     *
     * @param number number for a convert
     * @return result
     */
    private String convert(final int number) {
        int tmp = number;
        final int ten = 10;
        String ones = romanDigit(tmp % ten, "I", "V", "X");
        tmp /= ten;
        String tens = romanDigit(tmp % ten, "X", "L", "C");
        tmp /= ten;
        String hundreds = romanDigit(tmp % ten, "C", "D", "M");
        return hundreds + tens + ones;
    }
}
