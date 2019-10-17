package calculator.menu;

import calculator.main.Calculator;
import calculator.operators.Actions;
import calculator.operators.OperatorDivision;
import calculator.operators.OperatorMinus;
import calculator.operators.OperatorMultiplication;
import calculator.operators.OperatorPlus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Menu.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/15/2019
 */
public class Menu {
    /**
     * field the map menu.
     */
    private final Map<String, Actions> map = new HashMap<>();

    /**
     * field the map the romes numbers.
     */
    private final Map<String, String> romes = new HashMap<>();

    /**
     * field pattern.
     */
    private String pattern;

    /**
     * Getter the romes map.
     *
     * @return the romes map
     */
    final Map<String, String> getRomes() {
        return this.romes;
    }

    /**
     * Setter pattern.
     */
    private void setPattern() {
        this.pattern = "[+|\\-|/|*]";
    }

    /**
     * Getter pattern.
     *
     * @return the pattern
     */
    private String getPattern() {
        return this.pattern;
    }

    /**
     * Method to fill the store of actions.
     */
    public final void fill() {
        this.map.put("+", new OperatorPlus());
        this.map.put("-", new OperatorMinus());
        this.map.put("*", new OperatorMultiplication());
        this.map.put("/", new OperatorDivision());
    }

    /**
     * Method to fill the store of the romes numbers.
     */
    public final void fillRome() {
        this.romes.put("I", "1");
        this.romes.put("II", "2");
        this.romes.put("III", "3");
        this.romes.put("IV", "4");
        this.romes.put("V", "5");
        this.romes.put("VI", "6");
        this.romes.put("VII", "7");
        this.romes.put("VIII", "8");
        this.romes.put("IX", "9");
        this.romes.put("X", "10");
    }

    /**
     * Method to print a announce.
     *
     * @return the info
     */
    public final String info() {
        final StringBuilder sb = new StringBuilder();
        final String ls = System.lineSeparator();
        sb.append("*****************************************************")
                .append(ls)
                .append("                    Calculator")
                .append(ls)
                .append("Enter the two numbers with one operators:");
        return sb.toString() + this.map.keySet();
    }

    /**
     * Method to get the current action.
     *
     * @param key a key
     * @return a action
     */
    final Actions getAction(final String key) {
        return this.map.get(key);
    }

    /**
     * Getter the map.
     *
     * @return the map
     */
    public final Map<String, Actions> getMap() {
        return this.map;
    }

    /**
     * Method to get the result from the start numbers.
     *
     * @param aAnswer    the answer from user
     * @param calculator the start link
     * @return the result of execute start.
     */
    public final String checkAnswer(final String aAnswer,
                                    final Calculator calculator) {
        final String[] split = this.getAnswerSplit(aAnswer);
        final String answer = getCheckerAnswer(calculator, split);
        if (answer != null) {
            return answer;
        }
        return getClearResult(split);
    }

    /**
     * Method to get a clear result for calculate.
     *
     * @param split the array from answer
     * @return result
     */
    private String getClearResult(final String[] split) {
        String result = "Please to use the correct arguments...";
        if (this.isDigit(split)) {
            result = getCompute(split, new AnswerDigit());
        } else if (this.isRome(split)) {
            result = getCompute(split, new AnswerRome());
        }
        return result;
    }

    /**
     * Method to prepare data for calculate.
     *
     * @param split the array from answer
     * @param store a current numbers
     * @return result
     */
    private String getCompute(final String[] split, final AnswersStore store) {
        return store.getResult(this, split);
    }

    /**
     * Method to check a input answer for exception.
     *
     * @param calculator the calculator link
     * @param split      the array
     * @return return callback answer for user
     */
    private String getCheckerAnswer(final Calculator calculator,
                                    final String[] split) {
        String callback = null;
        if (isArrayLength(split)) {
            callback = "Please to use the correct arguments...";
        } else if (this.isExit(split, calculator)) {
            callback = "Good by!";
        } else if (this.isChecker(split)) {
            callback = "Please to use the correct arguments...";
        }
        return callback;
    }

    /**
     * Method to check array length.
     *
     * @param split the array
     * @return the boolean result
     */
    private boolean isArrayLength(final String[] split) {
        return split.length == 0;
    }

    /**
     * Method to check the answer about the correct data.
     *
     * @param split the answer by array
     * @return the boolean result
     */
    private boolean isChecker(final String[] split) {
        return !this.isLength(split) || !this.isOperator(split);
    }

    /**
     * Method to check a operator in the array data.
     *
     * @param aSplit the array
     * @return the boolean result.
     */
    private boolean isOperator(final String[] aSplit) {
        return this.getMap().containsKey(aSplit[2]);
    }

    /**
     * Method to check a length the array data.
     *
     * @param aSplit the array
     * @return the boolean result.
     */
    private boolean isLength(final String[] aSplit) {
        final int length = 3;
        return aSplit.length == length;
    }

    /**
     * Method to check the data about numbers.
     *
     * @param aSplit the array with data from user
     * @return the result of the check data.
     */
    private boolean isDigit(final String[] aSplit) {
        boolean check = false;
        final boolean one = this.romes.containsValue(aSplit[0]);
        final boolean two = this.romes.containsValue(aSplit[1]);
        if (one && two) {
            check = true;
        }
        return check;
    }

    /**
     * Method to check the data about numbers.
     *
     * @param aSplit the array with data from user
     * @return the result of the check data.
     */
    private boolean isRome(final String[] aSplit) {
        boolean check = false;
        final boolean one = this.romes.containsKey(aSplit[0]);
        final boolean two = this.romes.containsKey(aSplit[1]);
        if (one && two) {
            check = true;
        }
        return check;

    }

    /**
     * Method to check the data about the exit user.
     *
     * @param aSplit     the array with data from user
     * @param calculator the calculator link
     * @return the result of the check data.
     */
    private boolean isExit(final String[] aSplit, final Calculator calculator) {
        final boolean exit = aSplit[0].trim().toLowerCase().equals("exit");
        if (exit) {
            calculator.setStop();
        }
        return exit;
    }

    /**
     * Method to get a array by the answer from user.
     *
     * @param aAnswer the answer of user.
     * @return the answer by the array.
     */
    private String[] getAnswerSplit(final String aAnswer) {
        this.setPattern();
        final ArrayList<String> list = new ArrayList<>();
        this.getGrossAnswer(aAnswer, list);
        return list.toArray(new String[0]);
    }

    /**
     * Method to get the gross answer fom a user.
     *
     * @param aAnswer the answer
     * @param list    the list with a tmp data
     */
    private void getGrossAnswer(final String aAnswer, final List<String> list) {
        final Scanner scanner = new Scanner(aAnswer);
        scanner.useDelimiter(this.getPattern());
        this.addNumbersToList(list, scanner);
        this.addOperatorToList(list, aAnswer);
    }

    /**
     * Method to add the numbers to the tmp list.
     *
     * @param list    the tmp list.
     * @param scanner the scanner.
     */
    private void addNumbersToList(final List<String> list,
                                  final Scanner scanner) {
        while (scanner.hasNext()) {
            if (scanner.hasNextLine()) {
                final String line = scanner.next().trim();
                list.add(line);
            }
        }
    }

    /**
     * Method to add the operator to the tmp list.
     *
     * @param list    the tmp list.
     * @param aAnswer the answer from user.
     */
    private void addOperatorToList(final List<String> list,
                                   final String aAnswer) {
        final var matcher = Pattern.compile(this.getPattern()).matcher(aAnswer);
        int start = -1;
        if (matcher.find()) {
            start = matcher.start();
        }
        if (start != -1) {
            final var operator = String.valueOf(aAnswer.toCharArray()[start]);
            list.add(operator);
        }
    }
}
