import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class bj_20437 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc=0;tc<t;tc++) {
			String str = sc.next();
			int k = sc.nextInt();
			List<Integer>[] list = new ArrayList[26];
			for(int i=0;i<26;i++) {
				list[i] = new ArrayList<>();
			}
			for(int i=0;i<str.length();i++) {
				list[str.charAt(i)-'a'].add(i);
			}
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			for(int i=0;i<26;i++) {
				if(list[i].size()<k) continue;
				for(int s=0;s<list[i].size()-k+1;s++) {
					min = Math.min(list[i].get(s+k-1)-list[i].get(s)+1, min);
					max =  Math.max(list[i].get(s+k-1)-list[i].get(s)+1, max);
				}
				
			}
			if(min == Integer.MAX_VALUE && max == Integer.MIN_VALUE) {
				System.out.println(-1);
			}
			else {
				System.out.println(min+" "+max);
			}
			
			
			
		}
		
		

	}

}
