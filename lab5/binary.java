import java.util.*;
public class binary
{
	int binarysearch(int[]a,int l,int r,int x){

		if (r>l){
			int mid=l+(r-l)/2;

			if(a[mid]==x){
				return mid;
			}
			else if(a[mid]>x){
				return binarysearch(a,l,mid-1,x);
			}
			else{
				return binarysearch(a,mid+1,r,x);
			}
		}
		return -1;
	}
	public static void main(String[] args) {

		binary obj=new binary();
		int[] a={1,23,44,22,44,223,566,22,67,45,72,2};
		System.out.println("enter the number to search");
		Scanner p=new Scanner(System.in);
		int num=p.nextInt();
		int n=a.length;
		int result=obj.binarysearch(a,0,n-1,num);

		if(result==-1){
			System.out.println("no such element");
		}
		System.out.println("element found at index :"+ result);
		
	}
}
