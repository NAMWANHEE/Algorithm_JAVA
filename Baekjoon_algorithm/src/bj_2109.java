import java.util.PriorityQueue;
import java.util.Scanner;

public class bj_2109 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->{
			if(o2[0] == o1[0]) return o2[1]-o1[1];
			return o1[0]-o2[0];
		});
		for(int i=0;i<n;i++) {
			int p = sc.nextInt();
			int d = sc.nextInt();
			pq.add(new int[] {d,p});
		}
		
		
		int day = 1;
		int ans = 0;

		PriorityQueue<Integer> pq2 = new PriorityQueue<>();
		while(!pq.isEmpty()) {
			int a[] = pq.poll();

			if(day<= a[0]) {
				ans+= a[1];
				day++;
				pq2.add(a[1]);
			}
			else if(pq2.size() == a[0]) {
				if(pq2.peek()< a[1]) {
					int n1 = pq2.poll();
					ans -= n1;
					ans += a[1];
					pq2.add(a[1]);
				}
			}
			
		}
		System.out.println(ans);
		

	}

}
