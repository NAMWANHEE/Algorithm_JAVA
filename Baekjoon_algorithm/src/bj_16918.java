import java.util.Arrays;
import java.util.Scanner;

public class bj_16918 {
	static int n,c,r;
	static int bomb[][], nbomb[][];
	static char map [][];
	static int [] dx = {1,-1,0,0};
	static int [] dy = {0,0,1,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		r = sc.nextInt();
		c = sc.nextInt();
		n = sc.nextInt();
		
		map = new char[r][c];
		bomb = new int[r][c];
		nbomb = new int[r][c];
		for(int i=0;i<r;i++) {
			String str = sc.next();
			for(int j=0;j<c;j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'O') {
					bomb[i][j] = 2;
					nbomb[i][j] = 2;
				}
			}
		}

		for(int i=0;i<n-1;i++) {
			for(int j=0;j<r;j++) {
				for(int k=0;k<c;k++) {
					if(bomb[j][k] == 0) nbomb[j][k] = 3;
					else if(bomb[j][k] == 1) {
						nbomb[j][k] = 0;
						bomb(j,k);
					}
					else if(bomb[j][k]>1 && nbomb[j][k] != 0) nbomb[j][k] -= 1;
				}
			}
			for(int j=0;j<r;j++) {
				for(int k=0;k<c;k++) {
					bomb[j][k] = nbomb[j][k];
				}
			}
		}
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(bomb[i][j]>=1) map[i][j] = 'O';
				else map[i][j] = '.';
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	private static void bomb(int i, int j) {
		for(int t=0;t<4;t++) {
			int nx = i+dx[t];
			int ny = j+dy[t];
			if(nx<0||ny<0||nx>=r||ny>=c) continue;
			nbomb[nx][ny] = 0;
			
		}
		
	}

}
