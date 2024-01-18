import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_15971 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s1 = Integer.parseInt(st.nextToken());
		int s2 = Integer.parseInt(st.nextToken());
		if(n==1) {
			System.out.println(0);
		}
		List<int[]> relation [] = new ArrayList[n+1];
		for(int i=0;i<n+1;i++) {
			relation[i] = new ArrayList<>();
		}
		boolean visit[] = new boolean[n+1];
		for(int i=0;i<n-1;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to =Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			relation[from].add(new int[] {to,weight,weight});
			relation[to].add(new int[] {from,weight,weight});
		}
		
		Queue<int[]> q = new ArrayDeque<>();
		for(int[] arr: relation[s1]) {
			q.add(arr);
		}
		visit[s1] = true;
		while(!q.isEmpty()) {
			int [] arr = q.poll();
			if(arr[0] == s2) {
				System.out.println(arr[1]-arr[2]);
				break;
			}
			for(int [] a: relation[arr[0]]) {
				if(visit[a[0]]) continue;
				visit[a[0]] = true;
				q.add(new int[] {a[0],arr[1]+a[1],Math.max(arr[2], a[1])});
			}
		}

	}

}
