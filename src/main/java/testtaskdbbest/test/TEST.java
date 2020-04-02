package testtaskdbbest.test;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TEST {

    public static final Pattern BRACKET = Pattern.compile("\\(.+?\\)");
    public static final Pattern MULTIPLICATION = Pattern.compile("\\d+\\*\\d+");
    public static final Pattern DIVISION = Pattern.compile("\\d+\\/\\d+");
    public static final Pattern PLUS = Pattern.compile("\\d+\\+\\d+");
    public static final Pattern MINUS = Pattern.compile("\\d+\\-\\d+");
    public static final Pattern OPERATOR = Pattern.compile("[\\*\\/\\-\\+]");
    public static final Pattern NUMBER = Pattern.compile("\\d+\\.\\d+");
    public static final Pattern NNUMBER = Pattern.compile("\\d++");


    private static String operators = "+-*/";

    private static String delimiters = "() " + operators;

    public static void main(String[] args) throws Exception {
//        BufferedReader d = new BufferedReader(new InputStreamReader(System.in));
//        String sIn;
//        try {
//            System.out.println("Введте выражение для расчета. Поддерживаются цифры, операции +,-,*,/,^,% и приоритеты в виде скобок ( и ):");
//            sIn = d.readLine();
//            sIn = opn(sIn);
//            System.out.println(calculate(sIn));
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }


        String inputString = "2.0+3333.0";
        String[] number = inputString.split("\\+");
        Double res = 0.0;
        for (int i = 0; i < number.length; i++) {
            res += Double.valueOf(number[i]);
            System.out.println(res);
//            Double d = Double.valueOf(number[i]);
//            System.out.println(d);
        }


        String s = "11+(6/3+1111*3)";

        Matcher word = BRACKET.matcher(s);
        while (word.find()) {
            String string = word.group();
            System.out.println("string -> " + string);


            Matcher multiplication = MULTIPLICATION.matcher(string);
            multiplication.reset();
            while (multiplication.find()) {
                System.out.println("MULTIPLICATION");
                String oldValue = multiplication.group();
                System.out.println("oldValue : " + oldValue);
                String newValue = calc("\\*", oldValue);
                System.out.println("newValue : " + newValue);
                string = string.replace(oldValue, newValue);
                System.out.println("string after -> " + string);
            }

            Matcher division = DIVISION.matcher(string);
            while (division.find()) {
                System.out.println("DIVISION");
                String oldValue = division.group();
                System.out.println("oldValue : " + oldValue);
                String newValue = calc("\\/", oldValue);
                System.out.println("newValue : " + newValue);
                string = string.replace(oldValue, newValue);
                System.out.println("string after -> " + string);
            }

            Matcher minus = MINUS.matcher(string);
            while (minus.find()) {
                System.out.println("MINUS");
                String oldValue = minus.group();
                System.out.println("oldValue : " + oldValue);
                String newValue = calc("\\-", oldValue);
                System.out.println("newValue : " + newValue);
                string = string.replace(oldValue, newValue);
                System.out.println("string after -> " + string);
            }

            Matcher plus = PLUS.matcher(string);
            while (plus.find()) {
                System.out.println("PLUS");
                String oldValue = plus.group();
                System.out.println("oldValue : " + oldValue);
                String newValue = calc("\\+", oldValue);
                System.out.println("newValue : " + newValue);
                string = string.replace(oldValue, newValue);
                System.out.println("string after -> " + string);
            }

            System.out.println("string after -> " + string);


        }

    }

    private static String multiplication(String inputString){
        String result = null;
        Matcher multiplication = MULTIPLICATION.matcher(inputString);
        multiplication.reset();
        while (multiplication.find()) {
            String oldValue = multiplication.group();
            System.out.println("oldValue : " + oldValue);
            String newValue = calc("\\*", oldValue);
            System.out.println("newValue : " + newValue);
            result = inputString.replace(oldValue, newValue);
            System.out.println("string after -> " + result);
        }
        return result;
    }


    private static String calc(String operator, String inputString) {
        System.out.println("input string : " + inputString);
        String[] number = inputString.split(operator);

        Double first = Double.valueOf(number[0]);
        System.out.println("firs : " + first);

        Double second = Double.valueOf(number[1]);
        System.out.println("second : " + second);
        Double result = null;
        switch (operator) {
            case "\\-":
                result = first - second;
                break;
            case "\\+":
                result = first + second;
                break;
            case "\\*":
                result = first * second;
                System.out.println("res : " + result);
                break;
            case "\\/":
                result = first / second;
                break;
        }
        return String.valueOf(result);
    }


    private String myParse(String inputString) {

        return null;
    }

    private static int priority(String token) {
        switch (token) {
            case "(":
                return 1;
            case "+":
            case "-":
                return 2;
            case "*":
            case "/":
                return 3;
            default:
                return 4;
        }
    }


    /**
     * o
     * Преобразовать строку в обратную польскую нотацию
     *
     * @param inputString Входная строка
     * @return Выходная строка в обратной польской нотации
     */
    private static String opn(String inputString) throws Exception {
        StringBuilder sbStack = new StringBuilder(""), sbOut = new StringBuilder("");
        char cIn, cTmp;

        for (int i = 0; i < inputString.length(); i++) {
            cIn = inputString.charAt(i);

            System.out.println("cIn : " + cIn);
            if (itOperator(cIn)) {
                while (sbStack.length() > 0) {
                    cTmp = sbStack.substring(sbStack.length() - 1).charAt(0);

                    System.out.println("cTmp : " + cTmp);
                    if (itOperator(cTmp) && (setPriority(cIn) <= setPriority(cTmp))) {
                        sbOut.append(" ").append(cTmp).append(" ");
                        sbStack.setLength(sbStack.length() - 1);
                        System.out.println("------> sbOut : " + sbOut);
                    } else {
                        sbOut.append(" ");
                        break;
                    }
                }
                sbOut.append(" ");
                sbStack.append(cIn);
            } else if ('(' == cIn) {
                sbStack.append(cIn);
            } else if (')' == cIn) {
                cTmp = sbStack.substring(sbStack.length() - 1).charAt(0);
                System.out.println("cTmp : " + cTmp);
                while ('(' != cTmp) {
                    if (sbStack.length() < 1) {
                        throw new Exception("Ошибка разбора скобок. Проверьте правильность выражения.");
                    }
                    sbOut.append(" ").append(cTmp);
                    sbStack.setLength(sbStack.length() - 1);
                    cTmp = sbStack.substring(sbStack.length() - 1).charAt(0);
                    System.out.println("-------------> sbOut : " + sbOut);
                }
                sbStack.setLength(sbStack.length() - 1);
            } else {
                // Если символ не оператор - добавляем в выходную последовательность
                sbOut.append(cIn);
            }
        }

        // Если в стеке остались операторы, добавляем их в входную строку
        while (sbStack.length() > 0) {
            sbOut.append(" ").append(sbStack.substring(sbStack.length() - 1));
            sbStack.setLength(sbStack.length() - 1);
        }
        return sbOut.toString();
    }

    /**
     * Функция проверяет, является ли текущий символ оператором
     */
    private static boolean itOperator(char c) {
        switch (c) {
            case '-':
            case '+':
            case '*':
            case '/':
            case '^':
                return true;
        }
        return false;
    }

    /**
     * Возвращает приоритет операции
     *
     * @param op char
     * @return byte
     */
    private static byte setPriority(char op) {
        switch (op) {
            case '^':
                return 3;
            case '*':
            case '/':
            case '%':
                return 2;
        }
        return 1; // Тут остается + и -
    }

    /**
     * Считает выражение, записанное в обратной польской нотации
     *
     * @param sIn
     * @return double result
     */
    private static double calculate(String sIn) throws Exception {
        double dA = 0, dB = 0;
        String sTmp;
        Deque<Double> stack = new ArrayDeque<Double>();
        StringTokenizer st = new StringTokenizer(sIn);
        while (st.hasMoreTokens()) {
            try {
                sTmp = st.nextToken().trim();
                if (1 == sTmp.length() && itOperator(sTmp.charAt(0))) {
                    if (stack.size() < 2) {
                        throw new Exception("Неверное количество данных в стеке для операции " + sTmp);
                    }
                    dB = stack.pop();
                    System.out.println("dB : " + dB);
                    dA = stack.pop();
                    System.out.println("dA : " + dA);
                    System.out.println("sTmp.charAt(0)" + sTmp.charAt(0));
                    switch (sTmp.charAt(0)) {
                        case '+':
                            dA += dB;
                            break;
                        case '-':
                            dA -= dB;
                            break;
                        case '/':
                            dA /= dB;
                            break;
                        case '*':
                            dA *= dB;
                            break;
                        case '%':
                            dA %= dB;
                            break;
                        case '^':
                            dA = Math.pow(dA, dB);
                            break;
                        default:
                            throw new Exception("Недопустимая операция " + sTmp);
                    }
                    stack.push(dA);
                } else {
                    dA = Double.parseDouble(sTmp);
                    stack.push(dA);
                }
            } catch (Exception e) {
                throw new Exception("Недопустимый символ в выражении");
            }
        }

        if (stack.size() > 1) {
            throw new Exception("Количество операторов не соответствует количеству операндов");
        }
        System.out.println("stack : " + stack.pop());
        return stack.pop();
    }


}
