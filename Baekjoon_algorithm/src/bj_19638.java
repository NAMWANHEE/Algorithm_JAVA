import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj_19638 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)-> o2-o1);
		for(int i=0;i<n;i++) {
			int giant = Integer.parseInt(br.readLine());
			if(giant >= h) pq.add(giant);
		}
		if(pq.isEmpty()) {
			System.out.println("YES");
			System.out.println(0);
			System.exit(0);
		}
		for(int i=0;i<t;i++) {
			int height = pq.poll();
			if(height==1) {
				pq.add(1);
				break;
			}
			if(height/2 >= h) pq.add(height/2);
			if(pq.size()==0) {
				System.out.println("YES");
				System.out.println(i+1);
				break;
			}
		}
		if(!pq.isEmpty()) {
			System.out.println("NO");
			System.out.println(pq.peek());
		}

	}

}
