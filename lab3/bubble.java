import java.util.Scanner;
public class bubble
{
    public static void main(String[] args) 
    {

        
        Scanner cin = new Scanner(System.in);
        System.out.print("Enter the length of an array: "); 
        int length = cin.nextInt();

        int arr[] = new int[length];


        for(int i = 0; i < length; i++)
        {   
             System.out.print("Enter element: ");

            arr[i] = cin.nextInt();

           
        }

        System.out.println("Unsorted array is :");
        for (int x=0;x<arr.length;x++){
            System.out.println(arr[x]);
        }

        int i,k,j;

       for(i=arr.length-1;i>0;i--)
       {
        for(j=0; j < i; j++)
            {
                if(arr[j]>arr[j+1] )
                {  
                                   
                    k = arr[j];  
                    arr[j]=arr[j+1]  ;  
                    arr[j+1] = k;  
                }  
                          
            }  
        }  
        System.out.println("The sorted array is:");
                for (int x=0;x<arr.length;x++)
                {
                    System.out.println(arr[x]);
                }
    }

}