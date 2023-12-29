import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class bj_2258 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> {
			if(o1[1]==o2[1]) return o2[0]-o1[0];
			return o1[1]-o2[1];
		});
		for(int i=0;i<n;i++) {
			int s1 = sc.nextInt();
			int s2 = sc.nextInt();
			pq.add(new int[] {s1,s2});
		}
		
		for(int[] a: pq) {
			System.out.println(Arrays.toString(a));
		}
		int sum = 0;
		int old = 0;
		int price = 0;
		for(int[] a : pq) {
			sum += a[0];
			if(old != a[1]) {
				old = a[1];
				price = a[1];
			}
			else {
				price += a[1];
			}
			if(sum >= m) {
				System.out.println(price);
				System.exit(1);;
			}
		}
		System.out.println(-1);

	}

}
