import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class bj_21921 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int [] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int ans = 0;
		for(int i=0;i<x;i++) {
			ans += arr[i];
		}
		int max = ans;
		Map<Integer,Integer> map = new HashMap<>();
		map.put(ans, 1);
		for(int i=0;i<n-x;i++) {
			ans = ans-arr[i]+arr[i+x];
			if(map.containsKey(ans)) map.put(ans, map.get(ans)+1);
			else map.put(ans, 1);
			max = Math.max(max, ans);
		}
		if(max == 0) {
			System.out.println("SAD");
		}
		else {
			System.out.println(max);
			System.out.println(map.get(max));
		}

	}

}
