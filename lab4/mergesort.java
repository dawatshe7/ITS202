class mergesort{
	int[] array;
	int[] temp_Array;
	int length;

	public static void main(String args[])
	{
		int[] arrayToSort = {8,1,4,0,2,5,7,3};

		mergesort arr = new mergesort();
		arr.sort(arrayToSort);
		System.out.print(" The Sorted Array is : ");
		for(int i:arrayToSort){
			System.out.print(i);
			System.out.print(" ");
		}
		System.out.print("\n The Length of Array is : " + arrayToSort.length);
		System.out.print("\n");
	}

	public void sort(int[] arrayToSort)
	{
		this.array = arrayToSort;
		this.length = arrayToSort.length;
		this.temp_Array = new int [length];
		merge_sort(0, length-1);
		
	}

	public void merge_sort(int low, int high)
	{
		if(low<high)
		{
			int mid = low + (high-low)/2;
			merge_sort(low, mid);
			merge_sort(mid+1, high);
			merge(low, mid, high);
		}
	}
	public void merge(int low, int mid, int high)
	{
		for(int i=low; i<=high; i++){
			temp_Array[i] = array[i];
		}
		int i = low;
		int j = mid + 1;
		int k= low;
		while(i<= mid && j<=high)
		{
			if(temp_Array[i] <= temp_Array[j])
			{
				array[k] = temp_Array[i];
				i++;
			}
			else
			{
				array[k] = temp_Array[j];
				j++;
			}
			k++;
		}
		while(i<=mid)
		{
			array[k] = temp_Array[i];
			i++;
			k++;
		}
	}
}

   