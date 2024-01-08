import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj_10282 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for(int tc = 0;tc<t;tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			ArrayList<int[]> [] com = new ArrayList [n+1];
			for(int i=0;i<n+1;i++) {
				com[i] = new ArrayList<>();
			}
			for(int i=0;i<d;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				com[b].add(new int[] {a,s});
			}
			
			PriorityQueue<int []> pq = new PriorityQueue<>((o1,o2)-> o1[1]-o2[1]);
			pq.add(new int[] {c,0});
			int [] time = new int[n+1];
			Arrays.fill(time, Integer.MAX_VALUE);
			time[c] = 0;
			
			while(!pq.isEmpty()) {
				int [] arr = pq.poll();
				if(arr[1] > time[arr[0]]) continue;
				
				for(int [] next: com[arr[0]]) {
					if(time[next[0]] > time[arr[0]]+ next[1]) {
						time[next[0]] = time[arr[0]]+next[1];
						pq.add(new int[] {next[0],time[next[0]]});
					}
				}
			}
			int cnt = 0;
			int ans = 0;
			for(int i=0;i<n+1;i++) {
				if(time[i]==Integer.MAX_VALUE) continue;
				cnt++;
				ans = Math.max(ans, time[i]);
			}
			System.out.println(cnt+" "+ans);
		}

	}

}
