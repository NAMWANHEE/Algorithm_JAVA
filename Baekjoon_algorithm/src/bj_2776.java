import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class bj_2776 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for(int tc=0;tc<t;tc++) {
			Set<Integer> set = new HashSet<>();
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				int num = Integer.parseInt(st.nextToken());
				set.add(num);
			}
			int x = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<x;i++) {
				int num = Integer.parseInt(st.nextToken());
				if(set.contains(num)) sb.append(1).append("\n");
				else sb.append(0).append("\n");
			}
	
		}
		System.out.println(sb);

	}

}
