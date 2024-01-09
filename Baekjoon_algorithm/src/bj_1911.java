import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class bj_1911 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int l = sc.nextInt();
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o1[0]-o2[0]);
		for(int i=0;i<n;i++) {
			pq.add(new int[] {sc.nextInt(),sc.nextInt()});
		}
		int ans = 0;
		int idx = 0;
		while(!pq.isEmpty()) {
			int [] arr = pq.poll();
			
			if(arr[0] > idx) idx = arr[0];
			
			while(arr[1] > idx) {
				idx += l;
				ans++;
			}
		}
		System.out.println(ans);

	}

}
