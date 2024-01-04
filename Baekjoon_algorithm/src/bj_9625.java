import java.util.Scanner;

public class bj_9625 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		
		int a = 1;
		int b = 0;
		
		for(int i=0;i<k;i++) {
			int new_a = b;
			int new_b = a+b;
			a = new_a;
			b = new_b;
	
		}
		System.out.println(a+" "+b);

	}

}
