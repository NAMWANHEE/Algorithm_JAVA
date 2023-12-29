import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class bj_1781 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Map<Integer,List<Integer>> map = new HashMap<>();
		for(int i=0;i<n;i++) {
			int deadline = sc.nextInt();
			int cup = sc.nextInt();
			if(map.containsKey(deadline)) {
				map.get(deadline).add(cup);
			}
			else {
				map.put(deadline, new ArrayList<>());
				map.get(deadline).add(cup);
			}
			
		}
		List<Integer> keys = new ArrayList<>(map.keySet());
		Collections.sort(keys);
		int ans = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int deadline : keys) {
			for(int cup: map.get(deadline)) {
				pq.add(cup);
			}
			while(pq.size() > deadline) pq.poll();
		}
		while(!pq.isEmpty()) {
			ans+=pq.poll();
		}
		System.out.println(ans);
	}

}
