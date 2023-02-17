import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ThreeWayQuickSort {
    public static void swap(int arr[],int i, int j){
        int temporaryValue = arr[i];
        arr[i] = arr[j];
        arr[j] = temporaryValue;
    }


    public static int[] threeWayPartitioning (int[] arr, int lowestIndex, int highestIndex){

        int pivot = arr[lowestIndex];
        int lt = lowestIndex; //lt as lower than
        int gt = highestIndex; // gy as higher than
        int sortIndex = lowestIndex;

        while (sortIndex <= gt){
            if(arr[sortIndex] < pivot){
                swap(arr,sortIndex,lt);
                sortIndex += 1;
                lt +=1;
            }

            else if (arr[sortIndex] > pivot) {
                swap(arr, sortIndex, gt);
                gt -=1 ;

            }
            else{
                sortIndex += 1;
            }
        }

        int[] newArr = {lt,gt};
        return newArr;

    }

    public static void threeWayQuickSort(int arr[], int left, int right){
        if(left > right){
            return;
        }

        int[] newArr = threeWayPartitioning(arr,left,right);
        int lt = newArr[0];
        int gt = newArr[1];

        threeWayQuickSort(arr,left, lt -1 );
        threeWayQuickSort(arr,gt + 1, right);
        }


    public static int[] copyArray(ArrayList<Integer> data) {
        int n = data.size();
        int[] res = new int[n];
        for (int i = 0; i<n; i++){
            res [i] = data.get(i);
        }
        return res;
    }
    public static int[] readArray(String path) throws FileNotFoundException {

        Scanner sc = new Scanner(new File(path));
        ArrayList<Integer> data = new ArrayList<Integer>();

        while (sc.hasNextInt()) {
            data.add(sc.nextInt());
        }
        return copyArray(data);
    }

    public static boolean sortTester(int a[]){
        int n = a.length;
        for (int i = 0; i < n-1; i++){
            if (a[i] > a[i+1]){
                System.out.println("Not sorted");
                return false;
            }
        }
        System.out.println("Sorted");
        return true;
    }





    public static void main(String[] args)throws FileNotFoundException {
        String path = "/Users/caesar.jpl/AD_AE1/dutch.txt";
        int [] numbers = readArray(path);

        long startTime = System.currentTimeMillis();
        threeWayQuickSort(numbers,0,numbers.length-1);
        long stopTime = System.currentTimeMillis();
        long runTime = stopTime - startTime;
        System.out.println("------------------------");
        sortTester(numbers);
        System.out.println("Running time is: "+ runTime +"ms");



    }


}
