package composition;

import java.util.*;

public class CompositionRunner {
    private static double[] calculateComposition(double[] A, double[][] M) {
        double[] result = new double[A.length];

        for (int i = 0; i < M.length; i++) {
            double a = M[0][i];
            double b = M[1][i];
            double c = M[2][i];
            double d = M[3][i];
            result[i] = (Math.min(A[i], max(a, b, c, d)));
        }

        return result;
    }

    private static double max(double a, double b, double c, double d) {
        return Math.max(Math.max(a, b), Math.max(c, d));
    }


    public static void main(String[] args) {
        double[] A = {0.5, 0.7, 0.8, 0.1};
        double[][] M = {
                {0.2, 0.5, 0.1, 0.2},
                {0.4, 0.8, 0.8, 0.3},
                {0.1, 0.5, 0.6, 0.5},
                {0.2, 1.0, 0.9, 0.1}
        };

        System.out.println("Результирующая матрица:");
        System.out.println(Arrays.toString(calculateComposition(A, M)));

    }
}
