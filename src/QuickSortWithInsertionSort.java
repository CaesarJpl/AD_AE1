import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class QuickSortWithInsertionSort {
    public static void swap(int arr[],int i, int j){
        int temporaryValue = arr[i];
        arr[i] = arr[j];
        arr[j] = temporaryValue;
    }


    public static int partitioning (int[] arr, int lowestIndex, int highestIndex){

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


    public static void quickSort(int arr[], int left, int right){

        if (left >= right){
            return;
        }
        int partitioningIndex = partitioning(arr, left, right);

        quickSort(arr,left, partitioningIndex -1 );
        quickSort(arr,partitioningIndex + 1, right);

    }

    public static void insertionSort(int[] arr, int left, int right){
        for(int i = left+1; i <=right; i++){
            int key = arr[i];
            int j = i-1;
            while(j>=left && arr[j] >key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }

    public static void quickSortWithInsertionSort(int arr[], int left, int right, int k){

        if(right-left+1 <k){
            insertionSort(arr,left,right);
        }

        else if (left < right){
            int partitioningIndex = partitioning(arr, left, right);
            quickSort(arr,left, partitioningIndex -1 );
            quickSort(arr,partitioningIndex + 1, right);
        }


    }

    static void merge(int a[], int p, int q, int r){
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] L = new int[n1 + 1];
        int[] R = new int[n2 + 1];

        for (int i=0; i<n1; i++)
            L[i] = a[p + i];
        for (int j=0; j<n2; j++)
            R[j] = a[q + 1+ j];
        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        for (int k=p; k<= r; k++){
            if(L[i] <= R[j]){
                a[k] = L[i];
                i++;
            }
            else{
                a[k] = R[j];
                j++;
            }
        }
    }

    public static void mergeSort(int a[], int p, int r){
        if (p < r){
            int q = (p+r)/2;
            mergeSort(a, p, q);
            mergeSort(a , q+1, r);
            merge(a, p, q, r);
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






    public static void main(String[] args)throws FileNotFoundException {

        int k1 =10;
        int k2 =10000;
        int k3 =700000;

        String path = "/Users/caesar.jpl/AD_AE1/intBig.txt";
        int [] numbers = readArray(path);

        long startTime = System.currentTimeMillis();
        quickSortWithInsertionSort(numbers,0,numbers.length-1,k1);
        long stopTime = System.currentTimeMillis();
        long runTime = stopTime - startTime;
        System.out.println("------------------------");
        sortTester(numbers);
        System.out.println("Running time is : "+ runTime +"ms");



    }



}
