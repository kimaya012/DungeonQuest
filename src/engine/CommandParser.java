package engine;

public class CommandParser {
    public static String[] parse(String input) {
        input = input.trim();

        if (input.isEmpty()) {
            return new String[0];
        }

        return input.split("\\s+");
    }
}