import java.util.*;

public class Parser {

    public static Map<Integer, Float> parseInput(String input) {
        Map<Integer, Float> result = new HashMap<>();

        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Empty input");
        }

        try {
            String[] pairs = input.split(" ");

            for (String pair : pairs) {
                String[] parts = pair.split(":");
                result.put(Integer.parseInt(parts[0]), Float.parseFloat(parts[1]));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid input");
        }

        return result;
    }

    public static Operation parseOperation(String operation) {
        return switch (operation) {
            case "1" -> Operation.ASSOCIATION;
            case "2" -> Operation.INTERSECTION;
            case "3" -> Operation.SUBTRACTION;
            case "4" -> Operation.ADDITION;
            default -> throw new IllegalArgumentException("Unknown operation: " + operation);
        };
    }
}
