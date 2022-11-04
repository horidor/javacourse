public class Main {
    public static void main(String[] args) {
        byte a = 3;
        byte b = 2;
        int n = 4;
        int m = 5;

        byte constant2 = 1;

        // variant = 2907
        // C2 = 1;
        // C3 = 1;
        // C5 = 2 (%);
        // C7 = 0 (byte);

        double result;
        double sum = 0;
        for (byte i = a; i <=n; i++) {
            for (byte j = b; j <= m; j++) {
                if (j == 0 || (i - constant2 ==0)) {
                    System.out.printf("Divison or mod by zero with: i = %d, j = %d\n", i, j);
                    return;
                }
                result = ((double) (i%j)) / ((i - constant2));
                sum += result;
            }
        }

        System.out.println(sum);

    }
}