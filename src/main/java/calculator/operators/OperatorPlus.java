package calculator.operators;

/**
 * OperatorPlus.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/15/2019
 */
public class OperatorPlus extends Operators {
    @Override
    public final int execute(final int one, final int two) {
        return one + two;
    }
}
