package testtaskdbbest.service;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


class CalculatorDAOImplTest {

    private static String s1 = "11+12*2+(2*(2+10)-1)";//58
    private static String s2 = "7+22/3-4+33";//43,333333333
    private static String s3 = "85-32+5*4+(13-5)";//81
    private static String s4 = "5+36+98/2+8-14";//84
    private static String s5 = "16*5-9+(44-18)-4";//93
    private static String s6 = "25+89/5+94-13";//123,8
    private static String s7 = "8*4+97+3*7";//150
    private static String s8 = "29-7*7-9+66";//37
    private static String s9 = "56/2+(73-52)-4";//45
    private static String s10 = "88-55*9+7-3";//-403
    private static String s11 = "21+8*7*5-(54/2-1)*2";//249
    private static String s12 = "5*5*5*5-2/(21*2+2)+(1*2+1)";//627,954545455
    private static String s13 = "5/7*98-8+5/48-(87/5+65)-156";//-176.29583333333
    private static String s14 = "4/7+59-(84/2)+(84*2)-(62/4*3)";//139.07142857143
    private static String s15 = "4/87-9-(8/(4*9-8)+5*(4/7+6))-15";//−57,096880131
    private static String s16 = "4/(45-78/2)-45*(78+2/5)*78/3";//−91727,333333333
    private static String s17 = "0.5*8.25-8*(7.2/3-6)*(7.9-12)+7";//−106,955
    private static String s18 = "2.6-5.8+8/(78.2/8)*7.9-8/(8+2.1)";//2,473393938
    private static String s19 = "4.7+5.9/9.7*(7.9-5/1.9)*(78.5/6)";//46,62558781
    private static String s20 = "9.1/7*9.4-(7.3/8*9.4)-(7.6/8)*(7.1/6.5)";//2,604807692

    private static Pattern ALL_ACTIONDD = Pattern.compile("(([-+]?[0-9]*\\.?[0-9]*+)([\\*\\/])([-+]?[0-9]*\\.?[0-9]*))");
    private static Pattern ALL_ACTIONPM = Pattern.compile("(([-+]?[0-9]*\\.?[0-9]*+)([\\*\\/\\-\\+])([-+]?[0-9]*\\.?[0-9]*))");
    public static final Pattern NUMBER = Pattern.compile("[-+]?[0-9]*\\.?[0-9]*+");


    private static CalculatorDAO calculatorDAO = new CalculatorDAOImpl();

    @Test
    void catculate() {
        System.out.println(calculatorDAO.catculate(s1));
        System.out.println(calculatorDAO.catculate(s2));
        System.out.println(calculatorDAO.catculate(s3));
        System.out.println(calculatorDAO.catculate(s4));
        System.out.println(calculatorDAO.catculate(s5));
        System.out.println(calculatorDAO.catculate(s6));
        System.out.println(calculatorDAO.catculate(s7));
        System.out.println(calculatorDAO.catculate(s8));
        System.out.println(calculatorDAO.catculate(s9));
        System.out.println(calculatorDAO.catculate(s10));
        System.out.println(calculatorDAO.catculate(s11));
        System.out.println(calculatorDAO.catculate(s12));
        System.out.println(calculatorDAO.catculate(s13));
        System.out.println(calculatorDAO.catculate(s14));
        System.out.println(calculatorDAO.catculate(s15));
        System.out.println(calculatorDAO.catculate(s16));
        System.out.println(calculatorDAO.catculate(s17));
        System.out.println(calculatorDAO.catculate(s18));
        System.out.println(calculatorDAO.catculate(s19));
        System.out.println(calculatorDAO.catculate(s20));
    }

    public static void main(String[] args) {
        String s = "5*7/98+8-5/487*156";//-160.32819459801
        s = action(ALL_ACTIONDD, s);
        System.out.println("QQQQQQQQQ : " + s);
        System.out.println(action(ALL_ACTIONPM, s));
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
}