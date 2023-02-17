import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class QuickSortWithMedianOfThree {




    public static void swap(int arr[],int i, int j){
        int temporaryValue = arr[i];
        arr[i] = arr[j];
        arr[j] = temporaryValue;
    }


    public static void medianOfThree(int[] arr, int left, int right){
        //find the median
        int median = (left+right)/2;

        // if left value is greater than median
        if(arr[left] > arr[median]){
            swap(arr,left,median);
        }
        //if left is greater than right
        if(arr[left] > arr[right]){
            swap(arr, left,right);
        }

        if (arr[median] > arr[right]){
            swap(arr,median,right);
        }
        swap(arr,median,right);
    }



    public static int partitionMedianOfThree (int[] arr, int lowestIndex, int highestIndex){
        medianOfThree(arr,lowestIndex,highestIndex);
        int pivot = arr[highestIndex];
        int sortIndex = (lowestIndex-1);

        for(int j = lowestIndex; j <= highestIndex -1; j++){

            // if value j is less than value pivot
            if(arr[j] < pivot){
                sortIndex += 1;
                swap(arr, sortIndex, j);
            }
        }
        // exchange the value of pivot and the value i+1.
        swap(arr,sortIndex + 1, highestIndex);

        return sortIndex += 1;
    }

    public static void quickSortWithMedianOfThree(int arr[], int left, int right){

        if (left < right){
            int partitioningIndex = partitionMedianOfThree(arr, left, right);

            quickSortWithMedianOfThree(arr,left, partitioningIndex -1 );
            quickSortWithMedianOfThree(arr,partitioningIndex + 1, right);
        }
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



    public static void main(String[] args)throws FileNotFoundException{
        String path = "/Users/caesar.jpl/AD_AE1/dutch.txt";
        int [] numbers = readArray(path);

        long startTime = System.currentTimeMillis();
        quickSortWithMedianOfThree(numbers,0,numbers.length-1);
        long stopTime = System.currentTimeMillis();
        long runTime = stopTime - startTime;
        System.out.println("------------------------");
        sortTester(numbers);
        System.out.println("Running time is : "+ runTime +"ms");



    }


}
