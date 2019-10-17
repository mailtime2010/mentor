package calculator.menu;

import calculator.operators.Actions;

/**
 * AnswerDigit.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/16/2019
 */
public class AnswerDigit extends AnswersStore {
    /**
     * Method to get the calculate result.
     *
     * @param menu  the menu
     * @param split the data array
     * @return the result
     */
    public final String getResult(final Menu menu, final String[] split) {
        final Actions action = menu.getAction(split[2]);
        final int one = Integer.parseInt(split[0]);
        final int two = Integer.parseInt(split[1]);
        return String.valueOf(action.execute(one, two));
    }
}
