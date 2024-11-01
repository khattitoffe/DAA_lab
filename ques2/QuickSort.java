import java.util.*;
class QuickSort {
    public int partition(int[] arr, int l, int h) {
        int pivot = arr[l];
        int i = l + 1;
        int j = h;

        while (i <= j) {
      
            while (i <= j && arr[i] <= pivot) {
                i++;
            }
 
            while (i <= j && arr[j] > pivot) {
                j--;
            }
            
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        arr[l] = arr[j];
        arr[j] = pivot;
        return j; 
    }

    public void quick(int[] arr, int l, int h) {
       
        if (l < h) {
            int j = partition(arr,l,h);
            quick(arr,l,j); 
            quick(arr,j + 1,h);  
        }
    }
    

}