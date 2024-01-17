import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class softeer_우물안개구리 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int w [] = new int[n+1];
		boolean check[] = new boolean[n+1];
		List<Integer> [] relation = new ArrayList[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<n+1;i++) {
			w[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<n+1;i++) {
			relation[i] = new ArrayList<>();
		}
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			relation[a].add(b);
			relation[b].add(a);
		}
		
		for(int i=1;i<n+1;i++) {
			if(check[i]) continue;
			int weight = w[i];
			for(int p : relation[i]) {
				if(w[p] < weight) {
					check[p] = true;
				}
				else if(w[p] == weight) {
					check[p] = true;
					check[i] = true;
				}
				else check[i] = true;
			}
		}
		int ans = 0;
		for(int i=1;i<n+1;i++) {
			if(!check[i]) ans++;
		}
		System.out.println(ans);

	}

}
