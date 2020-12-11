//import java.util.*;
public class linear{

	public static int search(int[]a,int num){

		for(int i=0;i<a.length;i++){
			if(a[i]==num){
				return i;
			}
			
		}
		System.out.println("no such element");
		return



	}
	public static void main(String[] args) {

		int []a={2,3,4,12,4,56,2,1,45,6};

		System.out.println("enter the number to search");
		Scanner p=new Scanner(System.in);
		int num=p.nextInt();

		System.out.println(num+" is found at index: "+search(a, num));

				
	}
}
