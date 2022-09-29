/* Jacob Borth

For this programming assignment, I didn't specify a particular class name.
Use the suggested SortAnal name, if convenient. (Future programming assignments will require a specific main class name.)
*/

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class SortAnal {
    // Function handles output data from sorting algorithm and writes to text file (sheets.txt).
    public static void Print(){
        int arraySize, sortType = 0;    // sortType defines type of array to sort. (random, ascending, descending)

        try {
            String[] text = new String[20]; // String Array for output
            FileWriter sheets = new FileWriter("sheets.txt");
            while (sortType <= 3){
                for (int i = 1; i <= 20; i++) {
                    arraySize = i * 1000;
                    int _count  = SortAnalysis(Drivers(sortType, arraySize));   // Double function call to assign counted iterations in sorting algorithm
                    if (sortType == 0) text[i - 1] = (arraySize + "\t" + _count);   // 1st and 2nd column of data in text file
                    else if (sortType == 1 || sortType == 2) text[i - 1] = text[i - 1].concat("\t" + _count);   // 3rd and 4th column of data in text file.
                    else sheets.write(text[i - 1] + "\r\n");    // Writes data from text array to text file
                }
                sortType++;
            }
            sheets.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // This function creates an array of different types for the sorting algorithm.
    public static int[] Drivers(int run, int _arraySize) {
        Random rd = new Random();
        int[] sortArray = new int[_arraySize];

        for (int j = 0; j < _arraySize; j++) {
            if (run == 1) {
                sortArray[j] = j;   // Ascending array
            } else if (run == 2) {
                sortArray[j] = (j * -1);    // Descending array
            } else {
                sortArray[j] = rd.nextInt(1000000); // Randomly assorted array
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
