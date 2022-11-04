public class Main {
    public static void main(String[] args) {
        double arrayA[][] = {
                {20.5, 15.4, 10.123},
                {-20.5, -5.3123, -4.3123},
                {20.5, 20.4, -10.3},
                {-20.5, -20.5, -20.4}
        };

        double arrayB[][] = {
                {20.5, 5.1, 10.125, 41.0},
                {-20.5, -4.323, 10.2323, -41.0},
                {20.5, 20.6, -10.5555, -40.5},
        };

        /*double randMax = 10.0;
        double randMin = -10.0;

        for (int i = 0; i < arrayA.length; i++) {
            for (int j = 0; j < arrayA[i].length; j++) {
                arrayA[i][j] = Math.random() * (randMax - randMin + 1) + randMin;
            }
        }

        for (int i = 0; i < arrayB.length; i++) {
            for (int j = 0; j < arrayB[i].length; j++) {
                arrayB[i][j] = Math.random() * (randMax - randMin + 1) + randMin;
            }
        }*/

        int newHeight = Math.max(arrayA.length, arrayB.length);
        int newWidth = Math.max(arrayA[0].length, arrayB[0].length);

        double newArray[][] = new double[newHeight][newWidth];

        for (int i = 0; i < arrayA.length; i++) {
            for (int j = 0; j < arrayA[i].length; j++) {
                    newArray[i][j] = arrayA[i][j];
            }
        }

        for (int i = 0; i < arrayB.length; i++) {
            for (int j = 0; j < arrayB[i].length; j++) {
                newArray[i][j] += arrayB[i][j];
            }
        }



        for (int i = 0; i < newHeight; i++) {
            for (int j = 0; j < newWidth; j++ ) {
                System.out.printf("  %f  ", newArray[i][j]);
            }
            System.out.printf("%n");
        }

        double maxSum = -1000000.999999; // randMin - 1;
        double minSum = 1000000.99999; // randMax + 1;
        int minSum_count = 0;
        int maxSum_count = 0;

        for (int i = 0; i < newHeight; i++) {
            for (int j = 0; j < newWidth; j++) {
                if ((j+1)%2 == 1) {
                    if (Math.min(minSum, newArray[i][j]) != minSum) {
                        minSum = newArray[i][j];
                        minSum_count = 1;
                    }
                    else if (newArray[i][j] == minSum) minSum_count++;
                }
                else if ((j+1)%2 == 0) {
                    if (Math.max(maxSum, newArray[i][j]) != maxSum) {
                        maxSum = newArray[i][j];
                        maxSum_count = 1;
                    }
                    else if (newArray[i][j] == maxSum) maxSum_count++;
                }
            }
        }

        maxSum *= maxSum_count;
        minSum *= minSum_count;

        System.out.printf("%f - сума найбільших, %f - сума найменьших", maxSum, minSum);

    }
}