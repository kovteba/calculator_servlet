package testtaskdbbest.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorDAOImpl implements CalculatorDAO {

    public static final Pattern BRACKET = Pattern.compile("\\(.+?\\)");
    private static Pattern ALL_ACTIONDD = Pattern.compile("(([-+]?[0-9]*\\.?[0-9]*+)([\\*\\/])([-+]?[0-9]*\\.?[0-9]*))");
    private static Pattern ALL_ACTIONPM = Pattern.compile("(([-+]?[0-9]*\\.?[0-9]*+)([\\*\\/\\-\\+])([-+]?[0-9]*\\.?[0-9]*))");


    @Override
    public String catculate(String inputString) {

        Matcher bracket = BRACKET.matcher(inputString);
        while (bracket.find()) {
            String stringBracketOrigin = bracket.group();
            String stringBracket = null;
            stringBracket = action(ALL_ACTIONDD, stringBracketOrigin);
            stringBracket = action(ALL_ACTIONPM, stringBracket);
            stringBracket = stringBracket
                    .replaceAll("\\(", "")
                    .replaceAll("\\)", "");
            inputString = inputString.replace(stringBracketOrigin, stringBracket);
        }
        inputString = action(ALL_ACTIONDD, inputString);
        inputString = action(ALL_ACTIONPM, inputString);
        return inputString;
    }

    private static String action(Pattern pattern, String inputValue) {
        Matcher matcherString = pattern.matcher(inputValue);
        if (!matcherString.find() || matcherString.group(2).equals("")
                || matcherString.group(2).equals("-") || matcherString.group(2).equals("+")) {
            return inputValue;
        }
        String resultValue = calc(matcherString.group(3), matcherString.group(2), matcherString.group(4));
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
