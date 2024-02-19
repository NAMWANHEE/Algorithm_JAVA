import java.util.Scanner;

public class bj_1652 {
	static int n;
	static char map[][];
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		n = sc.nextInt();
		map = new char[n][n];
		for(int i=0;i<n;i++) {
			String str = sc.next();
			for(int j=0;j<n;j++) {
				map[i][j] = str.charAt(j);
			}
		}
		int ans = 0;
		int ans2 = 0;
		for(int i=0;i<n;i++) {
			ans += check1(i);
			ans2 += check2(i);
		}
		System.out.println(ans+" "+ans2);

	}

	private static int check2(int x) {
		int count = 0;
		int sum = 0;
		for(int i=0;i<n;i++) {
			if(map[i][x] == '.') sum++;
			else if(map[i][x] == 'X') {
				if(sum >= 2) count++;
				sum = 0;
			}
		}
		if(sum >= 2) count++;
		return count;
		
	}

	private static int check1(int x) {
		int count = 0;
		int sum = 0;
		for(int i=0;i<n;i++) {
			if(map[x][i] == '.') sum++;
			else if(map[x][i] == 'X') {
				if(sum >= 2) count++;
				sum = 0;
			}
		}
		if(sum >= 2) count++;
		return count;
		
	}

}
