import java.util.*;
class activitySelection{
   public static void main(String args[])
   {
      int[] start;
      int[] end;
      Scanner sc=new Scanner(System.in);
      System.out.println("Enter number of activity"); 
      int n=sc.nextInt();
      start=new int[n];
      end=new int[n];
      System.out.println("Enter Start Time");
      for(int i=0;i<n;i++)
      {
          start[i]=sc.nextInt();
      }
      System.out.println("Enter End time");
      for(int i=0;i<n;i++)
      {
          end[i]=sc.nextInt();
      }
      
      sort(start,end);
      
      System.out.println("Start Time");
      print(start);
      System.out.println("End Time");
      print(end);
      
      solve(start,end);
   }
   
   static void solve(int[] start,int[] end)
   {
         ArrayList<Integer> result=new ArrayList<>();
         result.add(1);
         int activity=0;
         for(int i=0;i<(start.length-1);i++)
         {
             if(end[activity]<start[i+1])
             {
                 result.add(i+2);//indexing 0 se start hoti hai to 2nd wala 1 banke addd na hojaeg uske liye +2
                 activity=i+1;
             }
         }
         int[] array = result.stream().mapToInt(Integer::intValue).toArray();
         System.out.println("Output");
         print(array);
   }
   
   static void sort(int[] array,int[] end)
   {
      for(int i=0;i<array.length;i++)
      { 
         for(int j=i;j<array.length;j++)
         {
             if(array[j]<array[i])
             {
                 int temp=array[i];       int temp2=end[i];
                 array[i]=array[j];       end[i]=end[j];
                 array[j]=temp;           end[j]=temp2;
             }
         }
      }
   }
   
   static void print(int[] array)
   {
        for (int item : array) {
            System.out.print(item+" ");
        }   
        System.out.println();
   }
}