import java.util.*;
class MergeSort{
    
    public void sort(int[] arr)
    {
        if(arr.length<=1)
          return ;
          
        int mid=arr.length/2;
        int[] leftHalf=new int[mid];
        int[] rightHalf;
        
        rightHalf=(arr.length%2==0)?(new int[mid]):(new int[mid+1]);
            
        for(int i=0;i<mid;i++)
        {
            leftHalf[i]=arr[i];
        }
        for(int i=mid;i<arr.length;i++)
        {
            rightHalf[i-mid]=arr[i];
        }
        sort(leftHalf);
        sort(rightHalf);
        
        merge(arr,leftHalf,rightHalf);
    }
    
    public void merge(int[] arr,int[] left,int[] right)
    {
        int i=0,j=0,k=0;
        
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        // Copy remaining elements of leftHalf, if any
        while (i < left.length) {
            arr[k++] = left[i++];
        }

        // Copy remaining elements of rightHalf, if any
        while (j < right.length) {
            arr[k++] = right[j++];
        }
        
        
    }
    
    
}
