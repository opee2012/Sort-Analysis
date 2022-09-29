/* Jacob Borth

For this programming assignment, I didn't specify a particular class name.
Use the suggested SortAnal name, if convenient. (Future programming assignments will require a specific main class name.)
*/


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class SortAnal {
    public static void Print(){

        int arraySize, sortType = 0;
        try {
            String[] text = new String[20];
            FileWriter sheets = new FileWriter("sheets.txt");
            while (sortType <= 3){
                for (int i = 1; i <= 20; i++) {
                    arraySize = i * 1000;
                    int _count  = SortAnalysis(Drivers(sortType, arraySize));
                    if (sortType == 0) text[i - 1] = (arraySize + "\t" + _count); else
                    if (sortType == 1 || sortType == 2) text[i - 1] = text[i - 1].concat("\t" + _count); else
                        sheets.write(text[i - 1] + "\r\n");
                }
                sortType++;
            }
            sheets.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static int[] Drivers(int run, int _arraySize) {
        Random rd = new Random();
        int[] sortArray = new int[_arraySize];

        for (int j = 0; j < _arraySize; j++) {
            if (run == 1) {
                sortArray[j] = j;
            } else if (run == 2) {
                sortArray[j] = (j * -1);
            } else {
                sortArray[j] = rd.nextInt(1000000);
            }
        }
        return sortArray;
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
        Print();
    }
}
