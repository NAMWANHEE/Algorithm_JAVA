import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class bj_11559 {
	
	static char map[][] = new char[12][6];
	static int [] dx = {1,-1,0,0};
	static int [] dy = {0,0,1,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<12;i++) {
			String str = sc.nextLine();
			for(int j=0;j<6;j++) {
				map[i][j] = str.charAt(j);
			}
		}
		int ans = 0;
		while(true) {
			boolean tf = true;
			for(int i=0;i<12;i++) {
				for(int j=0;j<6;j++) {
					if(map[i][j] != '.') {
						if(bfs(i,j)) tf = false;
					}
				}
			}
			fall();
			for(int i=0;i<12;i++) {
				System.out.println(Arrays.toString(map[i]));
			}
			System.out.println();
			ans++;
			if(tf) break;
		}
		System.out.println(ans-1);
			
		

	}
	private static void fall() {
		for(int i=0;i<6;i++) {

			for(int j=11;j>=0;j--) {
				if(map[j][i] == '.') continue;
				
				for(int k = 11;k>=j;k--) {
					if(map[k][i] == '.') {
						map[k][i] = map[j][i];
						map[j][i] = '.';
						break;
					}
				}
			}
		}
		
	}
	private static boolean bfs(int i, int j) {
		char color = map[i][j];
		boolean check[][] = new boolean[12][6];
		int cnt = 0;
		List<int[]> list = new ArrayList<>();
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {i,j});
		while(!q.isEmpty()) {
			int arr [] = q.poll();
			for(int s=0;s<4;s++) {
				int nx = arr[0]+dx[s];
				int ny = arr[1]+dy[s];
				if(nx<0||ny<0||nx>=12||ny>=6) continue;
				if(map[nx][ny] == '.') continue;
				if(check[nx][ny]) continue;
				if(map[nx][ny] != color) continue;
				q.add(new int[] {nx,ny});
				list.add(new int[] {nx,ny});
				check[nx][ny] = true;
				
				
			}
		}
		if(list.size()>=4) {
			for(int [] boom: list) {
				map[boom[0]][boom[1]] = '.';
			}
			return true;
		}
		return false;

		
	}

}
