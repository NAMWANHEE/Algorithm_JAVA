import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_2660 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int min = Integer.MAX_VALUE;
		Map<Integer,Integer> map = new HashMap<>();
		StringTokenizer st;
		List<Integer> [] rel = new List[n+1];
		for(int i=0;i<n+1;i++) {
			rel[i] = new ArrayList<>();
		}
		while(true) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			if(from==-1 && to==-1) break;
			rel[from].add(to);
			rel[to].add(from);
			
		}
		
		for(int i=1;i<n+1;i++) {
			Queue<Integer> q = new ArrayDeque<>();
			q.add(i);
			int score = 0;
			int count = 0;
			boolean check[] = new boolean[n+1];
			check[i] = true;
			
			while(!q.isEmpty()) {
				int size = q.size();
				for(int z=0;z<size;z++) {
					int num = q.poll();
					
					for(int s: rel[num]) {
						if(check[s]) continue;
						count++;
						q.add(s);
						check[s] = true;
					}
				}
				score++;
				
			}
			if(min>score) min = score;
			map.put(i, score);
			
		}
		int ans = 0;
		StringBuilder sb = new StringBuilder();
		System.out.print(min-1+" ");
		for(int key: map.keySet()) {
			if(map.get(key) == min) {
				ans++;
				sb.append(key+" ");
			}
		}
		System.out.println(ans);
		System.out.println(sb);
	}

}
