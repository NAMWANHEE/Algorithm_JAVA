import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj_1647 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		List<int[]> [] arr= new List[n+1];
		boolean visit[] = new boolean[n+1];
		for(int i=0;i<n+1;i++) {
			arr[i] = new ArrayList<>();
		}
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to =Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			arr[from].add(new int[] {to,weight});
			arr[to].add(new int[] {from,weight});
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
		for(int[] a: arr[1]) {
			pq.add(a);
		}
		List<Integer> list = new ArrayList<>();
		visit[1] = true;
		while(!pq.isEmpty()) {
			int [] ar= pq.poll();
			if(visit[ar[0]]) continue;
			visit[ar[0]] = true;
			list.add(ar[1]);
			
			for(int[]a:arr[ar[0]]) {
				if(visit[a[0]]) continue;
				pq.add(a);
			}
		}

		int max = 0;
		int ans = 0;
		for(int i:list) {
			if(max<i) max = i;
			ans += i;
		}
		System.out.println(ans-max);

	}

}
