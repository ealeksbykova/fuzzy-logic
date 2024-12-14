import java.util.*;

public class Calculator {
    public static Map<Integer, Double> calculate(Map<Integer, Double> A, Map<Integer, Double> B, Operation operation) {
        return switch (operation) {
            case ASSOCIATION -> getAssociation(A, B);
            case INTERSECTION -> getIntersection(A, B);
        };
    }

    private static Map<Integer, Double> getAssociation(Map<Integer, Double> A, Map<Integer, Double> B) {
//    private static float[] getAssociation(Map<Integer, Double> A, Map<Integer, Double> B) {
        Map<Integer, Double> assotiation = new HashMap<>();

        for (Map.Entry<Integer, Double> entry : A.entrySet()) {
            if (B.containsKey(entry.getKey())) {
                assotiation.put(entry.getKey(), Math.max(entry.getValue(), B.get(entry.getKey())));
            }
        }

        return assotiation;
    }

    private static Map<Integer, Double> getIntersection(Map<Integer, Double> A, Map<Integer, Double> B) {
        Map<Integer, Double> intersection = new HashMap<>();

        for (Map.Entry<Integer, Double> entry : A.entrySet()) {
            if (B.containsKey(entry.getKey())) {
                intersection.put(entry.getKey(), Math.min(entry.getValue(), B.get(entry.getKey())));
            }
        }

        return intersection;
    }
}
