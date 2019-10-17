package calculator;

import calculator.input.InputStub;
import calculator.input.InputValidate;
import calculator.menu.Menu;
import calculator.main.Calculator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
    private final ByteArrayOutputStream bos = new ByteArrayOutputStream();
    private final Menu menu = new Menu();

    @Before
    public void whenSetBefore() {
        System.setOut(new PrintStream(this.bos));
        this.menu.fill();
    }

    @After
    public void whenSetAfter() {
        System.setOut(new PrintStream(System.out));
    }

    private String addExitString() {
        return "= Good by!\n";
    }

    @Test
    public void whenCheckInfoIsOk() {
        System.out.println(menu.info());
        final var ls = System.lineSeparator();
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append("*****************************************************")
                .append(ls)
                .append("                    Calculator")
                .append(ls)
                .append("Enter the two numbers with one operators:")
                .append(menu.getMap().keySet())
                .append(ls)
                .toString()));
        new PrintStream(System.out);
    }

    @Test
    public void whenOnePlusOneIsTwoOk() {
        final String[] answer = {"1+1", "exit"};
        new Calculator(new InputValidate(new InputStub(answer))).init();
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append(this.menu.info())
                .append(System.lineSeparator())
                .append("= 2\n")
                .append(addExitString())
                .toString()));
    }

    @Test
    public void whenOneMinusOneIsZeroOk() {
        final String[] answer = {"1-1", "exit"};
        new Calculator(new InputValidate(new InputStub(answer))).init();
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append(this.menu.info())
                .append(System.lineSeparator())
                .append("= 0\n")
                .append(addExitString())
                .toString()));
    }

    @Test
    public void whenTwoDivisionTwoIsOneOk() {
        final String[] answer = {"2/2", "exit"};
        new Calculator(new InputValidate(new InputStub(answer))).init();
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append(this.menu.info())
                .append(System.lineSeparator())
                .append("= 1\n")
                .append(addExitString())
                .toString()));
    }

    @Test
    public void whenTwoMultiplicationTwoIsFourOk() {
        final String[] answer = {"2*2", "exit"};
        new Calculator(new InputValidate(new InputStub(answer))).init();
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append(this.menu.info())
                .append(System.lineSeparator())
                .append("= 4\n")
                .append(addExitString())
                .toString()));
    }

    @Test
    public void whenWhiteSpaceOnePlusOneIsTwoOk() {
        final String[] answer = {" 1  +    1", "exit"};
        new Calculator(new InputValidate(new InputStub(answer))).init();
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append(this.menu.info())
                .append(System.lineSeparator())
                .append("= 2\n")
                .append(addExitString())
                .toString()));
    }

    @Test
    public void whenTwoFallOperatorTwoIsFall() {
        final String[] answer = {"2?2", "exit"};
        new Calculator(new InputValidate(new InputStub(answer))).init();
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append(this.menu.info())
                .append(System.lineSeparator())
                .append("= Please to use the correct arguments...\n")
                .append(addExitString())
                .toString()));
    }

    @Test
    public void whenEnterNotFullPlusTwoIsFall() {
        final String[] answer = {"+2", "exit"};
        new Calculator(new InputValidate(new InputStub(answer))).init();
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append(this.menu.info())
                .append(System.lineSeparator())
                .append("= Please to use the correct arguments...\n")
                .append(addExitString())
                .toString()));
    }

    @Test
    public void whenEnterNotFullTwoPlusIsFall() {
        final String[] answer = {"2+", "exit"};
        new Calculator(new InputValidate(new InputStub(answer))).init();
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append(this.menu.info())
                .append(System.lineSeparator())
                .append("= Please to use the correct arguments...\n")
                .append(addExitString())
                .toString()));
    }

    @Test
    public void whenWordsMultiplicationOnNumberIsFall() {
        final String[] answer = {"fall * 2", "exit"};
        new Calculator(new InputValidate(new InputStub(answer))).init();
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append(this.menu.info())
                .append(System.lineSeparator())
                .append("= Please to use the correct arguments...\n")
                .append(addExitString())
                .toString()));
    }

    @Test
    public void whenBetterTheArgumentsInputIsFall() {
        final String[] answer = {"2*2+2", "exit"};
        new Calculator(new InputValidate(new InputStub(answer))).init();
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append(this.menu.info())
                .append(System.lineSeparator())
                .append("= Please to use the correct arguments...\n")
                .append(addExitString())
                .toString()));
    }

    @Test
    public void whenAnyOperatorIsFall() {
        final String[] answer = {"2 2", "exit"};
        new Calculator(new InputValidate(new InputStub(answer))).init();
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append(this.menu.info())
                .append(System.lineSeparator())
                .append("= Please to use the correct arguments...\n")
                .append(addExitString())
                .toString()));
    }

    @Test
    public void whenOneArgumentIsFall() {
        final String[] answer = {"2 ", "exit"};
        new Calculator(new InputValidate(new InputStub(answer))).init();
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append(this.menu.info())
                .append(System.lineSeparator())
                .append("= Please to use the correct arguments...\n")
                .append(addExitString())
                .toString()));
    }

    @Test
    public void whenOneArgumentIsWordFall() {
        final String[] answer = {"fall", "exit"};
        new Calculator(new InputValidate(new InputStub(answer))).init();
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append(this.menu.info())
                .append(System.lineSeparator())
                .append("= Please to use the correct arguments...\n")
                .append(addExitString())
                .toString()));
    }

    @Test
    public void whenNoArgumentsIsFall() {
        final String[] answer = {"  ", "exit"};
        new Calculator(new InputValidate(new InputStub(answer))).init();
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append(this.menu.info())
                .append(System.lineSeparator())
                .append("= Please to use the correct arguments...\n")
                .append(addExitString())
                .toString()));
    }

    @Test
    public void whenNoArgumentsAndPushEnterIsFall() {
        final String[] answer = {"", "exit"};
        new Calculator(new InputValidate(new InputStub(answer))).init();
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append(this.menu.info())
                .append(System.lineSeparator())
                .append("= Please to use the correct arguments...\n")
                .append(addExitString())
                .toString()));
    }

    @Test
    public void whenOneArgumentIsExitOk() {
        final String[] answer = {"exit"};
        new Calculator(new InputValidate(new InputStub(answer))).init();
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append(this.menu.info())
                .append(System.lineSeparator())
                .append(addExitString())
                .toString()));
    }

    @Test
    public void whenOneArgumentIsExitNotFullFall() {
        final String[] answer = {"exi", "exit"};
        new Calculator(new InputValidate(new InputStub(answer))).init();
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append(this.menu.info())
                .append(System.lineSeparator())
                .append("= Please to use the correct arguments...\n")
                .append(addExitString())
                .toString()));
    }
    @Test
    public void whenRomeOneMinusOneIsZeroOk() {
        final String[] answer = {"I-I", "exit"};
        new Calculator(new InputValidate(new InputStub(answer))).init();
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append(this.menu.info())
                .append(System.lineSeparator())
                .append("= \n")
                .append(addExitString())
                .toString()));
    }
    @Test
    public void whenRomeTenDivisionFourIsZeroOk() {
        final String[] answer = {"X*IV", "exit"};
        new Calculator(new InputValidate(new InputStub(answer))).init();
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append(this.menu.info())
                .append(System.lineSeparator())
                .append("= XL\n")
                .append(addExitString())
                .toString()));
    }

    @Test
    public void whenRomeTwoDivisionTwoIsOneOk() {
        final String[] answer = {"II/II", "exit"};
        new Calculator(new InputValidate(new InputStub(answer))).init();
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append(this.menu.info())
                .append(System.lineSeparator())
                .append("= I\n")
                .append(addExitString())
                .toString()));
    }

    @Test
    public void whenRomeTwoMultiplicationTwoIsFourOk() {
        final String[] answer = {"II*II", "exit"};
        new Calculator(new InputValidate(new InputStub(answer))).init();
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append(this.menu.info())
                .append(System.lineSeparator())
                .append("= IV\n")
                .append(addExitString())
                .toString()));
    }

    @Test
    public void whenRomeWhiteSpaceOnePlusOneIsTwoOk() {
        final String[] answer = {" I  +    I", "exit"};
        new Calculator(new InputValidate(new InputStub(answer))).init();
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append(this.menu.info())
                .append(System.lineSeparator())
                .append("= II\n")
                .append(addExitString())
                .toString()));
    }

    @Test
    public void whenRomeTwoFallOperatorTwoIsFall() {
        final String[] answer = {"II?II", "exit"};
        new Calculator(new InputValidate(new InputStub(answer))).init();
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append(this.menu.info())
                .append(System.lineSeparator())
                .append("= Please to use the correct arguments...\n")
                .append(addExitString())
                .toString()));
    }
    @Test
    public void whenRomeOneDigitPlusTwoRomeIsFall() {
        final String[] answer = {"1+II", "exit"};
        new Calculator(new InputValidate(new InputStub(answer))).init();
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append(this.menu.info())
                .append(System.lineSeparator())
                .append("= Please to use the correct arguments...\n")
                .append(addExitString())
                .toString()));
    }

    @Test
    public void whenRomeEnterNotFullPlusTwoIsFall() {
        final String[] answer = {"+II", "exit"};
        new Calculator(new InputValidate(new InputStub(answer))).init();
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append(this.menu.info())
                .append(System.lineSeparator())
                .append("= Please to use the correct arguments...\n")
                .append(addExitString())
                .toString()));
    }

    @Test
    public void whenRomeEnterNotFullTwoPlusIsFall() {
        final String[] answer = {"II+", "exit"};
        new Calculator(new InputValidate(new InputStub(answer))).init();
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append(this.menu.info())
                .append(System.lineSeparator())
                .append("= Please to use the correct arguments...\n")
                .append(addExitString())
                .toString()));
    }

    @Test
    public void whenRomeWordsMultiplicationOnNumberIsFall() {
        final String[] answer = {"fall * II", "exit"};
        new Calculator(new InputValidate(new InputStub(answer))).init();
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append(this.menu.info())
                .append(System.lineSeparator())
                .append("= Please to use the correct arguments...\n")
                .append(addExitString())
                .toString()));
    }

    @Test
    public void whenRomeBetterTheArgumentsInputIsFall() {
        final String[] answer = {"III*V+I", "exit"};
        new Calculator(new InputValidate(new InputStub(answer))).init();
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append(this.menu.info())
                .append(System.lineSeparator())
                .append("= Please to use the correct arguments...\n")
                .append(addExitString())
                .toString()));
    }

    @Test
    public void whenRomeAnyOperatorIsFall() {
        final String[] answer = {"VI IIV", "exit"};
        new Calculator(new InputValidate(new InputStub(answer))).init();
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append(this.menu.info())
                .append(System.lineSeparator())
                .append("= Please to use the correct arguments...\n")
                .append(addExitString())
                .toString()));
    }

    @Test
    public void whenRomeOneArgumentIsFall() {
        final String[] answer = {"X ", "exit"};
        new Calculator(new InputValidate(new InputStub(answer))).init();
        assertThat(this.bos.toString(), is(new StringBuilder()
                .append(this.menu.info())
                .append(System.lineSeparator())
                .append("= Please to use the correct arguments...\n")
                .append(addExitString())
                .toString()));
    }

}
