import java.util.Scanner;
public class insertion
{
	public static void main(String[] args) 
	{
		Scanner obj= new Scanner(System.in);

		System.out.println("Enter the length of an array: ");
		int length = obj.nextInt();

		int []arr=new int[length];
		System.out.println("Enter the elements of an array: ");
		
		for (int i=0;i<length ;i++ ) 
		{
			int x=obj.nextInt();
			arr[i]=x;

		}
		System.out.print("The unsorted array is: \n");
		
		for (int j=0;j<length ;j++ ) 
		{
			System.out.println(arr[j]);

		}
		 int i,k,j;
        for (i = 1; i < length; i++) 
        { 
            k = arr[i];  
            j = i - 1;
            while (j >= 0 && arr[j] > k)     
            { 
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = k;
        }

        System.out.println("The sorted array is :");
        for(int x=0; x<arr.length; x++){
            System.out.println(arr[x]);
        }


		

	}
}