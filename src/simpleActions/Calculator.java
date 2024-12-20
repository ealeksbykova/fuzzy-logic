package simpleActions;

import java.util.*;

public class Calculator {
    public static Map<Integer, Float> calculate(Map<Integer, Float> A, Map<Integer, Float> B, Operation operation) {
        return switch (operation) {
            case ASSOCIATION -> getAssociation(A, B);
            case INTERSECTION -> getIntersection(A, B);
            case SUBTRACTION -> getSubtraction(A, B);
            case ADDITION -> getAddition(A);
        };
    }

    private static Map<Integer, Float> getAssociation(Map<Integer, Float> A, Map<Integer, Float> B) {
        Map<Integer, Float> assotiation = new HashMap<>();

        for (Map.Entry<Integer, Float> entry : A.entrySet()) {
            if (B.containsKey(entry.getKey())) {
                assotiation.put(entry.getKey(), Math.max(entry.getValue(), B.get(entry.getKey())));
            }
        }

        return assotiation;
    }

    private static Map<Integer, Float> getIntersection(Map<Integer, Float> A, Map<Integer, Float> B) {
        Map<Integer, Float> intersection = new HashMap<>();

        for (Map.Entry<Integer, Float> entry : A.entrySet()) {
            if (B.containsKey(entry.getKey())) {
                intersection.put(entry.getKey(), Math.min(entry.getValue(), B.get(entry.getKey())));
            }
        }

        return intersection;
    }

    private static Map<Integer, Float> getSubtraction(Map<Integer, Float> A, Map<Integer, Float> B) {
        Map<Integer, Float> subtraction = new HashMap<>();

        for (Map.Entry<Integer, Float> entry : A.entrySet()) {
            if (B.containsKey(entry.getKey())) {
                subtraction.put(entry.getKey(), (entry.getValue() - B.get(entry.getKey()) > 0 ?
                        entry.getValue() - B.get(entry.getKey()) : 0));
            }
        }

        return subtraction;
    }

    private static Map<Integer, Float> getAddition(Map<Integer, Float> A) {
        Map<Integer, Float> addition = new HashMap<>();

        for (Map.Entry<Integer, Float> entry : A.entrySet()) {
            addition.put(entry.getKey(), (1 - entry.getValue()));
        }

        return addition;
    }
}
