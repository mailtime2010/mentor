package calculator.menu;

/**
 * public abstract class AnswersStore {.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/16/2019
 */
abstract class AnswersStore implements Answer {
    /**
     * Method to get the calculate result.
     *
     * @param aMenu the menu
     * @param split the data array
     * @return the result
     */
    public abstract String getResult(Menu aMenu, String[] split);
}
