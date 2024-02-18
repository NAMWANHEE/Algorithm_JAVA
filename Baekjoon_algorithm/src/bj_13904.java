import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class bj_13904 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int day = 0;
		Map<Integer,List<Integer>> map = new HashMap<>();
		for(int i=0;i<n;i++) {
			int key = sc.nextInt();
			int value = sc.nextInt();
			day = Math.max(key, day);
			if(map.containsKey(key)) {
				map.get(key).add(value);
			}
			else {
				map.put(key, new ArrayList<>());
				map.get(key).add(value);
			}
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>();


		for(int i=1;i<day+1;i++) {
			if(!map.containsKey(i)) continue;
			for(int num: map.get(i)) {
				if(pq.size()<i) pq.add(num);
				else if(pq.size() == i) {
					if(pq.peek() < num) {
						pq.poll();
						pq.add(num);
					}
				}
			}
		}
		int ans = 0;
		for(int num: pq) {
			ans += num;
		}
		System.out.println(ans);

	}

}
