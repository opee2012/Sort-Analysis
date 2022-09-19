/* Jacob Borth

For this programming assignment, I didn't specify a particular class name.
Use the suggested SortAnal name, if convenient. (Future programming assignments will require a specific main class name.)
*/


import java.util.Random;

public class SortAnal {
    public static void main(String[] a){
        int SIZE;
        Random rd = new Random();

        for (int i = 1; i <= 20; i++) {
            SIZE = i * 1000;
            int[] sortArray = new int[SIZE];

            for (int j = 0; j < SIZE; j++) {
                sortArray[j] = rd.nextInt(1000000);
            }
            System.out.println(SIZE + ":\t" + SortAnalysis(sortArray));
        }
    }

    public static int SortAnalysis(int[] A){

        int count = 0;
        int n = A.length;
        int v, j;


        for (int i = 1; i < n; i++) {
            v = A[i];
            j = i - 1;
            count++;
            while (j >= 0 && A[j] > v) {
                A[j + 1] = A[j];
                j--;
            }
            if (j >= 0) count++;
            A[j + 1] = v;
        }
        return count;
    }
}
