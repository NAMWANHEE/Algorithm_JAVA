import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class bj_6593 {

	// »ó¹üºôµù
	
	static int [] dx = {1,-1,0,0};
	static int [] dy= {0,0,1,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int l = sc.nextInt();
			int r = sc.nextInt();
			int c = sc.nextInt();
			boolean ans = false;
			if(l==0 && r == 0&& c==0)break;
			Queue<int[]> q = new ArrayDeque<>();
			boolean check [][][] = new boolean[l][r][c];
			char map[][][] = new char[l][r][c];
			int [] start = new int[4];
			for(int i=0;i<l;i++) {
				for(int j=0;j<r;j++) {
					String str = sc.next();
					for(int k=0;k<c;k++) {
						map[i][j][k] = str.charAt(k);
						if(str.charAt(k) == 'S') {
							start[0] = i;
							start[1] = j;
							start[2] = k;
						}
					}
				}
			}
			q.add(start);
			while(!q.isEmpty()) {
				int [] arr = q.poll();
				check[arr[0]][arr[1]][arr[2]] = true;
				boolean chk = false;
				for(int i=0;i<4;i++) {
					int nx = arr[1] + dx[i];
					int ny = arr[2] + dy[i];
					if(nx<0 || ny<0 ||nx>=r || ny>=c) continue;
					if(map[arr[0]][nx][ny] == '#') continue;
					if(check[arr[0]][nx][ny] == true) continue;
					if(map[arr[0]][nx][ny] == 'E') {
						System.out.printf("Escaped in %d minute(s).",arr[3]+1);
						System.out.println();
						q.clear();
						chk = true;
						ans = true;
						break;
					}
					q.add(new int[] {arr[0],nx,ny,arr[3]+1});
					check[arr[0]][nx][ny] = true;
				}
				if(chk) break;
				if(arr[0]-1 >= 0 && map[arr[0]-1][arr[1]][arr[2]] != '#' && check[arr[0]-1][arr[1]][arr[2]] == false) {
					if(map[arr[0]-1][arr[1]][arr[2]] == 'E') {
						ans = true;
						System.out.printf("Escaped in %d minute(s).",arr[3]+1);
						System.out.println();
						q.clear();
						break;
					}
					q.add(new int [] {arr[0]-1,arr[1],arr[2],arr[3]+1});
					check[arr[0]-1][arr[1]][arr[2]] = true;
					
				}
				if(arr[0]+1 <l && map[arr[0]+1][arr[1]][arr[2]] != '#' && check[arr[0]+1][arr[1]][arr[2]] == false) {
					if(map[arr[0]+1][arr[1]][arr[2]] == 'E') {
						ans = true;
						System.out.printf("Escaped in %d minute(s).",arr[3]+1);
						System.out.println();
						q.clear();
						break;
					}
					q.add(new int [] {arr[0]+1,arr[1],arr[2],arr[3]+1});
					check[arr[0]+1][arr[1]][arr[2]] = true;
				}
				
			}
			if(!ans) System.out.println("Trapped!");
		}
	}

}
