import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj_17396 {

	static class Node implements Comparable<Node>{
		int next;
		long distance;
		
		public Node(int next,long distance) {
			this.next = next;
			this.distance = distance;
		}
		
		@Override
		public int compareTo(Node o) {
			return Long.compare(this.distance, o.distance);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		long dist [] = new long[n];
		Arrays.fill(dist, Long.MAX_VALUE);
		dist[0] = 0;
		int map[] = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		List<int[]> [] list = new ArrayList[n];
		for(int i=0;i<n;i++) {
			list[i] = new ArrayList<>();
		}
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[from].add(new int[] {to,weight});
			list[to].add(new int[] {from,weight});
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(0,0));
		boolean visit[] = new boolean[n];
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			if(visit[node.next]) continue;
			else visit[node.next] = true;
			for(int [] a: list[node.next]) {
				if(map[a[0]]==1 && a[0] != n-1) continue;
				if(dist[a[0]]> dist[node.next]+a[1]) {
					dist[a[0]] = dist[node.next]+a[1];
					pq.add(new Node (a[0],dist[a[0]]));
				}
			}
		}
		if(dist[n-1] == Long.MAX_VALUE) System.out.println(-1);
		else System.out.println(dist[n-1]);

	}

}
