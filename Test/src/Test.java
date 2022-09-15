
public class Test {

	public static void main(String[] args) {
		
		rec(1);

	}
	
	public static void rec(int q) {
		
		System.out.println(q);
		
		q = q + 1;
		
		if (q <= 10) {
			
			rec(q);
		}
	}

}
