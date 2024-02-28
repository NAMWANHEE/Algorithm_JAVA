import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj_9466 {

	static int ans = 0,cnt=0;
	static int arr[];
	static boolean visit[], done[];
	static boolean chk;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc=0;tc<t;tc++) {
			int n = Integer.parseInt(br.readLine());
			ans = n;
			st = new StringTokenizer(br.readLine());
			arr = new int[n+1];
			done = new boolean[n+1];
			for(int i=1;i<n+1;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			visit = new boolean[n+1];
			cnt = 0;
			for(int i=1;i<n+1;i++) {
				check(i);
			}
			System.out.println(ans-cnt);
		}

	}

	private static void check(int num) {
		if(visit[num]) return;
		visit[num] = true;
		int next = arr[num];
		if(!visit[next]) check(next);
		else {
			if(!done[next]) {
				cnt++;
				while(next != num) {
					next = arr[next];
					cnt++;
				}
			}
		}
		done[num] = true;
	}

}
