import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class bj_18405 {
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		ArrayList<int[]> virus [] = new ArrayList[k+1];
		for(int i=0;i<k+1;i++) {
			virus[i] = new ArrayList<>();
		}
		int map[][] = new int[n+1][n+1];
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<n+1;j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] != 0) virus[map[i][j]].add(new int[] {i,j});
			}
		}
		
		int s = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		

		for(int ss=0;ss<s;ss++) {	
			for(int v=1;v<k+1; v++) {
				int size = virus[v].size();
				ArrayList<int[]> nlist = new ArrayList<>();
				for(int e = 0; e<size; e++) {
					int [] arr = virus[v].get(e);
					
					for(int c=0;c<4;c++) {
						int nx = arr[0]+dx[c];
						int ny = arr[1]+dy[c];
						if(nx<1||ny<1||nx>=n+1||ny>=n+1) continue;
						if(map[nx][ny] != 0 )continue;
						map[nx][ny] = v;
						nlist.add(new int[] {nx,ny});
					}
				}
				virus[v] = nlist;
			}
			
		}

		System.out.println(map[x][y]);
	}

}
