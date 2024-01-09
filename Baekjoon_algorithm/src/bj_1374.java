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
		PriorityQueue<Integer> pq2 = new PriorityQueue<>(); // 강의실 별로 강의가 끝나는 시간 저장
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int cla = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			pq.add(new int[] {s,e});
		}
		while(!pq.isEmpty()) {
			int [] arr = pq.poll();
			System.out.println(Arrays.toString(arr));
			while(!pq2.isEmpty() && pq2.peek() <= arr[0]) { // 가장 강의가 빨리 끝나는 시간보다 강의가 늦게 시작하는 경우 강의실의 끝나는 시간만 변경 아닌 경우에는 강의실 추가
				pq2.poll();
				break;
			}
			pq2.add(arr[1]);	// 강의실 추가
		}
		System.out.println(pq2.size());

	}

}
