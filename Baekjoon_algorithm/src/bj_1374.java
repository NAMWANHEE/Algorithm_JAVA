import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj_1374 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)-> o1[0]-o2[0]);
		PriorityQueue<Integer> pq2 = new PriorityQueue<>();
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int cla = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			pq.add(new int[] {s,e});
		}
		int ans = 0;
		while(!pq.isEmpty()) {
			int [] arr = pq.poll();
			System.out.println(Arrays.toString(arr));
			while(!pq2.isEmpty() && pq2.peek() <= arr[0]) {
				pq2.poll();
				break;
			}
			pq2.add(arr[1]);
			System.out.println(pq2);
			ans = Math.max(ans, pq2.size());
		}
		System.out.println(ans);
		System.out.println(pq2.size());

	}

}
