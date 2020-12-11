public class keyindex
{
	public static void main(String[] args) {

		int arr[]={3,4,2,4,5,3,1,0};
		int N = arr.length;
		int [] aux = new int [N]; 
		int R = 256; //'R' is unique characters that in arr[]
		int []count = new int[R+1];

		for (int i=0;i<N ;i++ ) 
			count [arr[i]+1]++;
			// Transform counts to indices.
		for (int r = 0; r < R; r++)
		count[r+1] += count[r];
		// Distribute the records.
		for (int j = 0; j < N; j++)

		 aux[count[arr[j]]++] =arr[j];
		// Copy back.
		for (int k = 0; k < N; k++)
		arr[k] = aux[k];


		System.out.println("Sorted: ");
		for (int i=0;i<N ;i++ ) {
			System.out.println(arr[i]);
		}
			
		

	}
}