public class Main {
    public static void main(String[] args) {
        final int a_iSize = 13;
        final int a_jSize = 14;
        short[] a1;
        a1 = new short[a_iSize];
        for (short i = 5; i <= 17; i++) {
            a1[i - 5] = i;
        }
        double[] x = new double[a_jSize];
        for (int i = 0; i < a_jSize; i++) {
            x[i] = -5.0 + (Math.random() * (11.0));
        }
        double[][] a = new double[a_iSize][a_jSize];
        for (int i = 0; i < a_iSize; i++) {
            for (int j = 0; j < a_jSize; j++) {
                switch (a1[i]) {
                    case (7):
                        a[i][j] = Math.sin(Math.pow((x[j] / (0.75 + x[j])), (2 / (1 - Math.pow(0.75 - x[j], 3)))));
                        break;
                    case (5):
                    case (8):
                    case (9):
                    case (10):
                    case (11):
                    case (17):
                        a[i][j] = Math.pow((4 * Math.pow((Math.cbrt(x[j]) * (Math.pow((0.5 * x[j]), 2) - 1)), (Math.cbrt(x[j])))), 3);
                        break;
                    default:
                        a[i][j] = Math.sin(Math.pow(Math.E, Math.pow((0.5 * (4 + x[j])), x[j]))) / 2;
                        break;
                }
                System.out.printf("%-14.2f ", a[i][j]);
            }
            System.out.println("");
        }

    }
}