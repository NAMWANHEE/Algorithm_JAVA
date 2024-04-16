import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class bj_17141 {
	static int n,m;
	static int dx [] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	static int map[][];
	static List<int[]> list;
	static List<int[]> list2 = new ArrayList<>();
	static int answer = Integer.MAX_VALUE;
	static boolean check = false;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][n];
		list = new ArrayList<>();
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 2) list.add(new int[] {i,j});
			}
		}
		
		combination(0,0);
		if(check)
			System.out.println(answer);
		else System.out.println(-1);
	}

	private static void combination(int depth, int start) {
		if(depth == m) {
			virus();
			return;
			
		}
		
		for(int i=start;i<list.size();i++) {
			list2.add(list.get(i));
			combination(depth+1,i+1);
			list2.remove(list.get(i));
		}
		
	}

	private static void virus() {
		int nmap[][] = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				nmap[i][j] = map[i][j];
			}
		}
		Queue<int[]> q = new ArrayDeque<>();
		boolean visit[][] = new boolean[n][n];
		int cnt[][] = new int[n][n];
		for(int[]a: list2) {
			visit[a[0]][a[1]] = true;
			q.add(a);
		}
		int max = 0;
		int time = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			time++;
			for(int z=0;z<size;z++) {
				int arr[] = q.poll();
				for(int i=0;i<4;i++) {
					int nx = arr[0]+dx[i];
					int ny = arr[1]+dy[i];
					if(nx<0||ny<0||nx>=n||ny>=n) continue;
					if(nmap[nx][ny] == 1) continue;
					if(visit[nx][ny]) continue;
					visit[nx][ny] = true;
					cnt[nx][ny] = cnt[arr[0]][arr[1]]+1;
					max = Math.max(max, cnt[nx][ny]);
					
					q.add(new int[] {nx,ny});
				}
			}
		}
		
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(!visit[i][j] && nmap[i][j] != 1) return;
					if(i==n-1 && j==n-1) {
						if(visit[i][j]) {
							answer = Math.min(max, answer);
							check = true;
						}
						if(nmap[i][j] == 1) {
							check = true;
							answer = Math.min(max, answer);
						}
						
					}
				}
			}
		

		answer = Math.min(answer, max);

		
	}

}
