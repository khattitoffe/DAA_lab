class compare{
    public static void main(String[] args)
    {
        MergeSort obj= new MergeSort();
        
        QuickSort obj1=new QuickSort();
        
        int[] array1= {
            12, 3, 45, 7, 23, 56, 1, 78, 34, 90,
            29, 15, 6, 4, 19, 88, 67, 22, 41, 33,
            100, 2, 47, 39, 58, 73, 85, 13, 26, 51,
            11, 70, 8, 30, 55, 16, 14, 97, 5, 36,
            60, 17, 9, 32, 44, 20, 75, 18, 92, 10,
            76, 49, 84, 27, 72, 38, 95, 65, 74, 99
        };
        int[] array2= {
            12, 3, 45, 7, 23, 56, 1, 78, 34, 90,
            29, 15, 6, 4, 19, 88, 67, 22, 41, 33,
            100, 2, 47, 39, 58, 73, 85, 13, 26, 51,
            11, 70, 8, 30, 55, 16, 14, 97, 5, 36,
            60, 17, 9, 32, 44, 20, 75, 18, 92, 10,
            76, 49, 84, 27, 72, 38, 95, 65, 74, 99
        };
        System.out.println("Original array:");
        printArray(array1);
        
        long start = System.nanoTime();
        obj1.quick(array1, 0, array1.length - 1);
        long end = System.nanoTime();
        double totalTime = (end - start)/1_000_000.0;
        System.out.println("Sorted array after Quick sort:");
        printArray(array1);
        System.out.println("Total Time taken for by Quick sort: " + totalTime + " ms");
        
        start = System.nanoTime();
        obj.sort(array1);
        end = System.nanoTime();
        totalTime = (end - start)/1_000_000.0;
        System.out.println("Sorted array after Merge sort:");
        printArray(array1);
        System.out.println("Total Time taken for by Merge sort: " + totalTime + " ms");
        
    }
    
    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}