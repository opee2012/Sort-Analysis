/* Jacob Borth

For this programming assignment, I didn't specify a particular class name.
Use the suggested SortAnal name, if convenient. (Future programming assignments will require a specific main class name.)
*/


import java.util.Random;

public class SortAnal {
    public static void Drivers(int run){
        int array_size;
        Random rd = new Random();

        for (int i = 1; i <= 20; i++) {
            array_size = i * 1000;
            int[] sortArray = new int[array_size];

            for (int j = 0; j < array_size; j++) {
                if (run == 1) {
                    sortArray[j] = j;
                } else if (run == 2) {
                    sortArray[j] = (j * -1);
                } else {
                    sortArray[j] = rd.nextInt(1000000);
                }
            }
            System.out.println(array_size + ":\t" + SortAnalysis(sortArray));
        }
    }

    public static int SortAnalysis(int[] A){

        int count = 0;
        int n = A.length;
        int v, j;


        for (int i = 1; i < n; i++) {
            v = A[i];
            j = i - 1;
            while (j >= 0 && A[j] > v) {
                count++;
                A[j + 1] = A[j];
                j--;
            }
            if (j >= 0) count++;
            A[j + 1] = v;
        }
        return count;
    }

    public static void main(String[] a){
        int sortType = 0;
        Drivers(sortType);
        sortType = 1;
        Drivers(sortType);
        sortType = 2;
        Drivers(sortType);
    }
}
