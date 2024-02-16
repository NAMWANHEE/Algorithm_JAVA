import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj_17352 {

	static int n;
	static List<Integer> [] bri;
	static boolean visit[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		bri = new ArrayList[n+1];
		visit = new boolean[n+1];
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<n+1;i++) {
			bri[i] = new ArrayList<>();
		}
		for(int i=0;i<n-2;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			bri[from].add(to);
			bri[to].add(from);
		}
		
		for(int i=1;i<n+1;i++) {
			if(!visit[i]) {
				list.add(i);
				visit[i] = true;
				dfs(i);
			}
		}
		for(int ans: list) {
			System.out.print(ans+" ");
		}
		
		

	}

	private static void dfs(int i) {
		
		for(int num: bri[i]) {
			if(!visit[num]) {
				visit[num] = true;
				dfs(num);
			}
		}
		
	}

}
