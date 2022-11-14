
public class test {

	static int[] arr = {58, 29, 21, 9, 21, 10, 88};
	
	void bubb(int[] arr) {
		
		int n = arr.length;
		
		for (int i = 0; i < n-1; i++) {
			
			for (int j = 0; j < n-i-1; j++) {
				
				if (arr[j] > arr[j+1]) {
					
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	
	void parr(int arr[]) {
		
		int s = arr.length;
		
		for (int i =0; i<s; i++) {
			
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {

	
		test  T = new test();
		
		T.bubb(arr);
		System.out.println("The Sorted array is: ");
		T.parr(arr);
		
	}
}