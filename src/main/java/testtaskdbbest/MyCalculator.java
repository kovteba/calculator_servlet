package testtaskdbbest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyCalculator {


    public static final Pattern MULTIPLICATION_DIVISION = Pattern.compile("[-+]?[0-9]*\\.?[0-9]*+[\\*\\/][-+]?[0-9]*\\.?[0-9]*");
    public static final Pattern PLUS_MINUS = Pattern.compile("[-+]?[0-9]*\\.?[0-9]*+\\+[\\-\\+]?[0-9]*\\.?[0-9]*");


    public static final Pattern MULTIPLICATION = Pattern.compile("([-+]?[0-9]*\\.?[0-9]*+\\*[-+]?[0-9]*\\.?[0-9]*)");
    public static final Pattern DIVISION = Pattern.compile("([-+]?[0-9]*\\.?[0-9]*+\\/[-+]?[0-9]*\\.?[0-9]*)");
    public static final Pattern PLUS = Pattern.compile("([-+][0-9]*\\.?[0-9]*+\\+[-+]?[0-9]*\\.?[0-9]*)");
    public static final Pattern MINUS = Pattern.compile("([-+][0-9]*\\.?[0-9]*+\\-[-+]?[0-9]*\\.?[0-9]*)");
    public static final Pattern NUMBER = Pattern.compile("[-+]?[0-9]*\\.?[0-9]*+");

//    public static final Pattern MULTIPLICATION = Pattern.compile("\\d+\\*\\d+");
//    public static final Pattern DIVISION = Pattern.compile("\\d+\\/\\d+");
//    public static final Pattern PLUS = Pattern.compile("\\d.+\\+\\d.");
//    public static final Pattern OPERATOR = Pattern.compile("[\\*\\/\\-\\+]");


    public static final Pattern BRACKET = Pattern.compile("\\(.+?\\)");
    private static Pattern ALL_ACTIONDD = Pattern.compile("(([-+]?[0-9]*\\.?[0-9]*+)([\\*\\/])([-+]?[0-9]*\\.?[0-9]*))");
    private static Pattern ALL_ACTIONPM = Pattern.compile("(([-+]?[0-9]*\\.?[0-9]*+)([\\*\\/\\-\\+])([-+]?[0-9]*\\.?[0-9]*))");



    public static void main(String[] args) throws Exception {

//        String s = "56/2/2+(73-52)-4";//31
//        String s = "21+8*7*5-(54/2-1)*2";//249
//        String s = "5/7*98-8+5/487-(87/65*4+65)-156";//-160.32819459801
//        String s = "4/7+59-(84/2)+(84*2)-(62/4*3)";//139.07142857143
//        String s = "5/7*98-8+5/48-(87/5+65)-156";//-176.29583333333
        String s = "48/98+65(45/98*9+6)-4+(78*84/52)-45";//736,112244898


        Matcher bracket = BRACKET.matcher(s);
        while (bracket.find()) {
            String stringBracketOrigin = bracket.group();
            String stringBracket = bracket.group();


            stringBracket = action(ALL_ACTIONDD, stringBracketOrigin);
            stringBracket = action(ALL_ACTIONPM, stringBracket);

            System.out.println("BRACHET : " + stringBracket);
            stringBracket = stringBracket
                    .replaceAll("\\(", "")
                    .replaceAll("\\)", "");

//            System.out.println("QQQQQQQQQ : " + s);
//            System.out.println(action(ALL_ACTIONPM, stringBracket));

//
//            System.out.println("origin string ---------> " + stringBracket);
//
//            stringBracket = action(MULTIPLICATION, "\\*", stringBracket);
//            System.out.println();
//            stringBracket = action(DIVISION, "\\/", stringBracket);
//            System.out.println();
//            stringBracket = calcString(stringBracket);
//            System.out.println();
//
//            System.out.println("final string --------> " + stringBracket);
//            System.out.println();
            s = s.replace(stringBracketOrigin, stringBracket);
            System.out.println("S GO OUT FROM BRACKET : " + s);
//            System.out.println();

        }

        s = action(ALL_ACTIONDD, s);
        s = action(ALL_ACTIONPM, s);

//        s = action(DIVISION, "\\/", s);
//        System.out.println();
//        s = action(MULTIPLICATION, "\\*", s);
//        System.out.println();


//        Double resultDouble = Double.valueOf(calcString(s));

        System.out.println("RESULT -------->" + s + "<----------");

    }

    private static String action(Pattern pattern, String inputValue) {

        Matcher matcherString = pattern.matcher(inputValue);

        if (!matcherString.find() || matcherString.group(2).equals("")
                || matcherString.group(2).equals("-") || matcherString.group(2).equals("+")) {
            return inputValue;
        }
        System.out.println("first : " + matcherString.group(2));
        System.out.println("action : " + matcherString.group(3));
        System.out.println("second : " + matcherString.group(4));

        String resultValue = calc(matcherString.group(3), matcherString.group(2), matcherString.group(4));
        System.out.println("result : " + resultValue);
        System.out.println();

        if (Double.parseDouble(resultValue) > 0.0){
            inputValue = inputValue.replace(matcherString.group(1), "+" + resultValue);
        } else {
            inputValue = inputValue.replace(matcherString.group(1), resultValue);
        }



        inputValue = action(pattern, inputValue);
        return inputValue;
    }

    private static String calc(String operator, String first, String second) {
        Double result = 0.0;
        switch (operator) {
            case "-":
                result = Double.parseDouble(first) - Double.parseDouble(second);
                break;
            case "+":
                result = Double.parseDouble(first) + Double.parseDouble(second);
                break;
            case "*":
                result = Double.parseDouble(first) * Double.parseDouble(second);
                break;
            case "/":
                result = Double.parseDouble(first) / Double.parseDouble(second);
                break;
        }
        return String.valueOf(result);
    }


//    private static String calcString(String in) {
//        Double resultDouble = 0.0;
//        Matcher resultMatcher = NUMBER.matcher(in);
//        System.out.print("RESULT CALC STRING : ");
//        while (resultMatcher.find()) {
//            if (!(resultMatcher.group().equals("-") || resultMatcher.group().equals("+"))) {
//                String addValue = resultMatcher.group();
//                System.out.print(addValue + " ");
//                if (!addValue.equals("")) {
//                    resultDouble += Double.parseDouble(addValue);
//                }
//            }
//        }
//        System.out.println(" = " + resultDouble);
//        return String.valueOf(resultDouble);
//    }


//    private static String action(Pattern pattern, String action, String inputValue) {
//        System.out.println("input value --> " + inputValue + " for action -> " + action);
//
//        Matcher mathcher = pattern.matcher(inputValue);
//        if (!mathcher.find()) {
//            return inputValue;
//        }
//
//        String oldValue = mathcher.group(1);
//        System.out.println("oldValue : " + oldValue);
//
//        String newValue = calc(action, oldValue);
//        System.out.println("newValue : " + newValue);
//
//        inputValue = inputValue.replace(oldValue, newValue);
//
//        System.out.println("result string : " + inputValue);
//
//        inputValue = action(pattern, action, inputValue);
//        return inputValue;
//    }
//
//
//    private static String calc(String operator, String inputString) {
//
//        StringBuilder builder = new StringBuilder();
//        System.out.println("input string : " + inputString);
//
//        String[] number = inputString.split(operator);
//
//        Double first = Double.valueOf(number[0]);
//        System.out.println("firs : " + first);
//
//        Double second = Double.valueOf(number[1]);
//        System.out.println("second : " + second);
//
//        if (first < 0.0 && first > second) {
//            builder.append("-");
//        } else {
//            builder.append("+");
//        }
//
//        Double result = null;
//        switch (operator) {
//            case "\\-":
//                result = first - second;
//                break;
//            case "\\+":
//                result = first + second;
//                break;
//            case "\\*":
//                result = first * second;
//                break;
//            case "\\/":
//                result = first / second;
//                break;
//        }
//        builder.append(result);
////        return String.valueOf(result);
//        return builder.toString();
//    }


//    public static String caclucatorMy(String s) {
//        Matcher bracket = BRACKET.matcher(s);
//        while (bracket.find()) {
//            String stringBracketOrigin = bracket.group();
//            String stringBracket = bracket.group();
//            stringBracket = stringBracket
//                    .replaceAll("\\(", "")
//                    .replaceAll("\\)", "");
//            stringBracket = action(MULTIPLICATION, "\\*", stringBracket);
//            stringBracket = action(DIVISION, "\\/", stringBracket);
//            stringBracket = calcString(stringBracket);
//            s = s.replace(stringBracketOrigin, stringBracket);
//        }
//        s = action(MULTIPLICATION, "\\*", s);
//        s = action(DIVISION, "\\/", s);
//        return calcString(s);
//    }

}
