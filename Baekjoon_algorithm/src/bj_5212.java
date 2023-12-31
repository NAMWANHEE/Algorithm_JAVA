import java.util.Arrays;
import java.util.Scanner;

public class bj_5212 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		int dx [] = {1,-1,0,0};
		int dy [] = {0,0,1,-1};
		char map[][] = new char[r][c];
		char nMap[][] = new char[r][c];
		for(int i=0;i<r;i++) {
			String str = sc.next();
			for(int j=0;j<c;j++) {
				map[i][j] = str.charAt(j);
			}
		}
		int sx = Integer.MAX_VALUE;
		int sy = Integer.MAX_VALUE;
		int bx = 0;
		int by = 0;
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(map[i][j] == '.') nMap[i][j] = '.';
				else {
					int cnt = 0;
					for(int k =0;k<4;k++) {
						int nx = i+dx[k];
						int ny = j+dy[k];
						if(nx<0||ny<0||nx>=r||ny>=c) {
							cnt++;
							continue;
						}
						if(map[nx][ny] == '.') cnt++;
					}
					if(cnt>=3) nMap[i][j] = '.';
					else {
						nMap[i][j] = 'X';
						if(i<=sx) sx = i;
						if(j<=sy) sy = j;
						if(i>= bx) bx = i;
						if(j >= by) by = j;
					}
				}
			}
		}
//		for(int i=0;i<r;i++) {
//			for(int j=0;j<c;j++) {
//				System.out.print(nMap[i][j]);
//			}
//			System.out.println();
//		}
		char ans[][] = new char[bx-sx+1][by-sy+1];
		int x = 0;
		for(int i=sx;i<=bx;i++) {
			int y = 0;
			for(int j=sy;j<=by;j++) {
				ans[x][y++] = nMap[i][j];
				
			}
			x++;
		}
		
		for(int i=0;i<bx-sx+1;i++) {
			for(int j=0;j<by-sy+1;j++) {
				System.out.print(ans[i][j]);
			}
			System.out.println();
		}
		
		

	}

}
