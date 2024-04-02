import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class bj_5972 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		List<int[]> [] list = new ArrayList[n+1];
		boolean visit[] = new boolean[n+1];
		for(int i=0;i<n+1;i++) {
			list[i] = new ArrayList<>();
		}
		for(int i=0;i<m;i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int weight = sc.nextInt();
			list[from].add(new int[] {to,weight});
			list[to].add(new int[] {from,weight});
		}
		int [] dist = new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[1] = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)-> o1[1]-o2[1]);
		pq.add(new int[] {1,0});
		while(!pq.isEmpty()) {
			int [] arr = pq.poll();
			if(!visit[arr[0]])visit[arr[0]] = true;
			else continue;


			for(int a[] : list[arr[0]]) {

				if(dist[a[0]] > dist[arr[0]]+a[1]) {
					dist[a[0]] = dist[arr[0]]+a[1];
					pq.add(new int[] {a[0],dist[a[0]]});
				}
			}
			
		}
		System.out.println(dist[n]);

	}

}
