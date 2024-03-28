import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class bj_15685 {

	static int dx[] = {1,0,-1,0};
	static int dy[] = {0,-1,0,1};
	static int map[][] = new int[101][101];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int d = sc.nextInt();
			int g = sc.nextInt();
			map[y][x] = 1;
			x= x+dx[d];
			y = y+dy[d];
			map[y][x] = 1;
			List<Integer> list = new ArrayList<>();
			list.add(d);
			for(int j=0;j<g;j++) {
				int size = list.size();
				for(int k=size;k>0;k--) {
					int nd = (list.get(k-1)+1) % 4;
					x = x+dx[nd];
					y = y+dy[nd];
					list.add(nd);
					map[y][x] = 1;
				}
			}
		}
		int ans = 0;
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(map[i][j] == 1 && map[i+1][j] == 1 && map[i][j+1]==1&& map[i+1][j+1]==1) ans++;
			}
		}
		

		System.out.println(ans);

	}

}
