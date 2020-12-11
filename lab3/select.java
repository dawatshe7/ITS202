import java.util.Scanner;
public class select
{
    public static void main(String[] args) 
    {

        
        Scanner cin = new Scanner(System.in);
        System.out.print("Enter the length of an array:");//array length 
        int length = cin.nextInt();

        int arr[] = new int[length];
        System.out.println("Enter all the elements:");


        for(int i = 0; i < length; i++)
        {
            System.out.print("Unsorted array is:");

            arr[i] = cin.nextInt();
           
        }

        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

         for (int i = 0; i < arr.length - 1; i++)  
        {  
            int k = i;  
            for (int j = i + 1; j < arr.length; j++){  
                if (arr[j] < arr[k]){  
                    k = j;  
                }  
            }  
            int smallNumber = arr[k];   
            arr[k] = arr[i];  
            arr[i] = smallNumber;  
        }  

         System.out.println("The sorted array is:");
                for (int x=0;x<arr.length;x++)
                {
                    System.out.println(arr[x]);
                }

    }
 }  