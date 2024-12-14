import java.util.*;

public class Parser {

    public static Map<Integer, Double> parseInput(String input) {
        Map<Integer, Double> result = new HashMap<>();

        String[] pairs = input.split(" ");

        for (String pair : pairs) {
            String[] parts = pair.split(":");
            result.put(Integer.parseInt(parts[0]), Double.parseDouble(parts[1]));
        }

        return result;
    }

    public static Operation parseOperation(String operation) {
        return switch (operation) {
            case "1" -> Operation.ASSOCIATION;
            case "2" -> Operation.INTERSECTION;
            default -> throw new IllegalArgumentException("Unknown operation: " + operation);
        };
    }
}
