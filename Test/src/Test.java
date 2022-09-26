
public class Test {

	public static void main(String[] args) {
		
		double x = 5.0 + 3/2;
		System.out.println(x);
		
		float[] arr = new float[5];
		
		
		for (int i = 0; i<arr.length; i++) {
			
			System.out.println(arr[i]);
		}
		
		float num = arr[0];
		
		
		//rec(1);

	}
	
	public static void rec(int q) {
		
		System.out.println(q);
		
		q = q + 1;
		
		if (q <= 10) {
			
			rec(q);
		}
	}

}
