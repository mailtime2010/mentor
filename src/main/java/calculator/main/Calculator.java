package calculator.main;

import calculator.input.Input;
import calculator.input.InputConsole;
import calculator.input.InputValidate;
import calculator.menu.Menu;

/**
 * Calculator.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/15/2019
 */
public final class Calculator {
    /**
     * field input.
     */
    private final Input input;
    /**
     * field stop.
     */
    private boolean stop = true;

    /**
     * Constructor.
     *
     * @param aInput the current input
     */
    public Calculator(final Input aInput) {
        this.input = aInput;
    }

    /**
     * Getter stop.
     *
     * @return the stop result
     */
    private boolean isStop() {
        return this.stop;
    }

    /**
     * Setter stop.
     */
    public void setStop() {
        this.stop = false;
    }

    /**
     * Getter the input.
     *
     * @return the input
     */
    private Input getInput() {
        return this.input;
    }

    /**
     * Method to initialisation the start.
     */
    public void init() {
        final Menu menu = new Menu();
        menu.fill();
        menu.fillRome();
        System.out.println(menu.info());
        do {
            final var answer = this.getInput().ask();
            System.out.printf("= %s\n",
                    menu.checkAnswer(answer, this));
        } while (this.isStop());

    }

    /**
     * Method to enter the point to program.
     *
     * @param args args
     */
    public static void main(final String[] args) {
        new Calculator(new InputValidate(new InputConsole())).init();
    }
}
