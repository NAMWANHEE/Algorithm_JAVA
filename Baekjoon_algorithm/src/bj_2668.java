import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class bj_2668 {

	static int n;
	static int map[];
	static boolean visit[];
	static int ans = 0;
	static List<Integer> list = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n= sc.nextInt();
		map = new int[n+1];
		visit = new boolean[n+1];
		for(int i=1;i<n+1;i++) {
			map[i] = sc.nextInt();
		}
		for(int i=1;i<n+1;i++) {
			visit[i] = true;
			dfs(i,i);
			visit[i] = false;
		}
		System.out.println(list.size());
		for(int a: list) {
			System.out.println(a);
		}

	}

	private static void dfs(int num, int end) {
		if(map[num] == end) list.add(end);
		if(!visit[map[num]]) {
			visit[map[num]] = true;
			dfs(map[num],end);
			visit[map[num]] = false;
		}
	
	}


}
