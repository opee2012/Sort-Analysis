/* Jacob Borth

For this programming assignment, I didn't specify a particular class name.
Use the suggested SortAnal name, if convenient. (Future programming assignments will require a specific main class name.)
*/


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class SortAnal {
    public static void Print(int _count, int sortType, int arraySize){
        try {
            FileWriter sheets = new FileWriter("sheets.txt", true);
            while (sortType <= 2){
                if (sortType == 0) {
                    sheets.write(arraySize + "\t");
                    sheets.append(_count + "\r\n");
                    Drivers(sortType);
                }
            }
            sheets.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void Drivers(int _run){
        int array_size;
        Random rd = new Random();

        for (int i = 1; i <= 20; i++) {
            if (_run == 3) break;
            array_size = i * 1000;
            int[] sortArray = new int[array_size];

            for (int j = 0; j < array_size; j++) {
                if (_run == 1) {
                    sortArray[j] = j;
                } else if (_run == 2) {
                    sortArray[j] = (j * -1);
                } else {
                    sortArray[j] = rd.nextInt(1000000);
                }
            }
            Print(SortAnalysis(sortArray), _run, i);
            if (i == 20) {
                _run++;
                i = 0;
            }
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
        int run = 0;

        try {
            File sheets = new File("sheets.txt");
            if (sheets.createNewFile()) {
                System.out.println("File created: " + sheets.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        Drivers(run);
    }
}
