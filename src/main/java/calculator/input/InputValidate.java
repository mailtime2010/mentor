package calculator.input;


/**
 * InputValidate.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/15/2019
 */
public class InputValidate implements Input {
    /**
     * field input.
     */
    private final Input input;

    /**
     * Constructor.
     *
     * @param aInput the current input
     */
    public InputValidate(final Input aInput) {
        this.input = aInput;
    }

    @Override
    public final String ask() {
        return this.input.ask();
    }
}
