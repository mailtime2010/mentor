package calculator.input;

import java.util.Scanner;

/**
 * InputConsole.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/15/2019
 */
public class InputConsole implements Input {
    /**
     * field scanner.
     */
    private final Scanner scanner;

    /**
     * Constructor.
     */
    public InputConsole() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public final String ask() {
        return this.scanner.nextLine();
    }
}
