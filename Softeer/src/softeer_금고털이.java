import java.util.PriorityQueue;
import java.util.Scanner;

public class softeer_±›∞Ì≈–¿Ã {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();
		int n = sc.nextInt();
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o2[1]-o1[1]);
		for(int i=0;i<n;i++) {
			pq.add(new int[] {sc.nextInt(),sc.nextInt()});
		}
		
		int ans = 0;
		while(w > 0) {
			int [] arr = pq.poll();
			if(w>=arr[0]) {
				ans+= arr[0]*arr[1];
				w -= arr[0];
			}
			else {
				ans += arr[1]*w;
				w = 0;
			}
			
		}
		System.out.println(ans);
	}

}
