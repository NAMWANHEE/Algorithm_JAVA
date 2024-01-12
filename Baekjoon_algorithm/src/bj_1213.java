import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;

public class bj_1213 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		Map<String,Integer> map = new TreeMap<>();
		for(int i=0;i<str.length();i++) {
			String key = Character.toString(str.charAt(i));
			if(map.containsKey(key)) map.put(key, map.get(key)+1);
			else map.put(key, 1);
		}
		Queue<String> q = new ArrayDeque<>();
		Stack<String> s = new Stack<>();
		
		int check = 0;
		String mid = "";
		for(String key: map.keySet()) {
			int cnt = map.get(key);
			if(cnt % 2 != 0) {
				mid = key;
				check++;
			}
			if(check > 1) {
				System.out.println("I'm Sorry Hansoo");
				break;
			}
			for(int i=0;i<cnt/2;i++) {
				q.add(key);
				s.add(key);
			}
			
		}
		String ans = "";
		if(check < 2) {
			while(!q.isEmpty()) {
				ans+= q.poll();
			}
			ans+= mid;
			while(!s.isEmpty()) {
				ans += s.pop();
			}
		}
		System.out.println(ans);
	}

}
