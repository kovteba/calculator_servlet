package testtaskdbbest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyCalculator {

    public static final Pattern BRACKET = Pattern.compile("\\(.+?\\)");
    public static final Pattern MULTIPLICATION = Pattern.compile("\\d+\\*\\d+");
    public static final Pattern DIVISION = Pattern.compile("\\d+\\/\\d+");
//    public static final Pattern PLUS = Pattern.compile("\\d.+\\+\\d.");
    public static final Pattern PLUS = Pattern.compile("[-+]?[0-9]*\\.?[0-9]*+\\+[-+]?[0-9]*\\.?[0-9]*");
    public static final Pattern MINUS = Pattern.compile("[-+]?[0-9]*\\.?[0-9]*+\\-[-+]?[0-9]*\\.?[0-9]*");
    public static final Pattern OPERATOR = Pattern.compile("[\\*\\/\\-\\+]");

    public static final Pattern NUMBER = Pattern.compile("[-+]?[0-9]*\\.?[0-9]*+");


    public static void main(String[] args) throws Exception {
//        String inputString = "2.0+3333.0";
//        String[] number = inputString.split("\\+");
//        Double res = 0.0;
//        for (int i = 0; i < number.length; i++) {
//            res += Double.valueOf(number[i]);
//            System.out.println(res);
////            Double d = Double.valueOf(number[i]);
////            System.out.println(d);
//        }

        String s = "11+(6/3+1111*3+1000*2+1)+(1+1)";
        Matcher bracket = BRACKET.matcher(s);
        while (bracket.find()) {
            String stringBracketOrigin = bracket.group();
            String stringBracket = bracket.group();
            System.out.println("origin string ---------> " + stringBracket);
            stringBracket = action(MULTIPLICATION, "\\*", stringBracket);
            stringBracket = action(DIVISION, "\\/", stringBracket);
            stringBracket = action(PLUS, "\\+", stringBracket);
            stringBracket = action(MINUS, "\\-", stringBracket);
            System.out.println("final string --------> " + stringBracket);
            s = s.replace(stringBracketOrigin, stringBracket);
        }
        System.out.println("-----> " + s);
        s = s.replaceAll("\\(","");
        s = s.replaceAll("\\)","");
        System.out.println("-----> " + s);
        s = action(MULTIPLICATION, "\\*", s);
        s = action(DIVISION, "\\/", s);
        s = action(PLUS, "\\+", s);
        s = action(MINUS, "\\-", s);
        System.out.println("RESULT -------->" + s + "<----------");

    }

    private static String action(Pattern pattern, String action, String inputValue){
        System.out.println("action : " + action);
        System.out.println("input value --> " + inputValue);
        String result = null;
        Matcher mathcher = pattern.matcher(inputValue);
        if (mathcher.find()){
            mathcher.reset();
            while (mathcher.find()) {
                String oldValue = mathcher.group();
                System.out.println("oldValue : " + oldValue);

                String newValue = calc(action, oldValue);
                System.out.println("newValue : " + newValue);

                result = inputValue.replace(oldValue, newValue);
                System.out.println("output value --> " + result + "\n");
                if (mathcher.find()){
                    result = action(pattern, action, result);
                }
            }
        } else {
            return inputValue;
        }
        System.out.println("!!!!!!!!!!!!!!!!!!!!! : " + result);
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


}
