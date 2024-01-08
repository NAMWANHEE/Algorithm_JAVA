import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class bj_1916 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		ArrayList<int[]> [] map = new ArrayList[n+1];
		
		for(int i=0;i<n+1;i++) {
			map[i] = new ArrayList<>();
		}
		for(int i=0;i<m;i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int weight = sc.nextInt();
			map[start].add(new int[] {end,weight});
		}
		
		int startNode = sc.nextInt();
		int endNode = sc.nextInt();
		int [] distance = new int[n+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[startNode] = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
		pq.add(new int[] {startNode,0});
		
		while(!pq.isEmpty()) {
			int [] arr = pq.poll();
			if(arr[1]> distance[arr[0]]) continue;
			
			for(int [] next : map[arr[0]]) {
				if(distance[next[0]] > distance[arr[0]]+next[1]) {
					distance[next[0]] = distance[arr[0]]+next[1];
					pq.add(new int[] {next[0],distance[next[0]]});
				}
			}
		}
		System.out.println(distance[endNode]);
	}

}
