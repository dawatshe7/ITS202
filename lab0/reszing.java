public class reszing{
	public static int[] resize (int n, int[] a ){
		int[] temp=new int[n];
		for (int i=0; i<a.length ; i++ ) {
			int x=0;
			temp[i] = a[i];
			
		}
		temp[n-1]=4;
		return temp;
	}
	public static void main(String[] args) {
		int a[]={1,2,3};
		int[] value= resize(4,a);
		for(int i=0;i<value.length;i++){
			System.out.println(value[i]);
		}
	}
}