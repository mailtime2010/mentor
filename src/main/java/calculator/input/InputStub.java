package calculator.input;

/**
 * InputStub.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/16/2019
 */
public class InputStub implements Input {
    /**
     * field value for test.
     */
    private final String[] value;
    /**
     * field position the enters for test.
     */
    private int position;

    /**
     * Constructor.
     *
     * @param aValue the current array for the test
     */
    public InputStub(final String[] aValue) {
        this.value = aValue;
    }

    @Override
    public final String ask() {
        return this.value[position++];
    }
}
