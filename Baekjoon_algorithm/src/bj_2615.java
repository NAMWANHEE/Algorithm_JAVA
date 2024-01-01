import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class bj_2615 {

	static int [][] map;
	static List<int[]> list = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new int[19][19];
		for(int i=0;i<19;i++) {
			for(int j=0;j<19;j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for(int i=0;i<19;i++) {
			for(int j=0;j<19;j++) {
				if(map[i][j] == 1) {
					check(i,j,1);
				}
				else if(map[i][j] == 2) {
					check(i,j,2);
				}
			}
		}
		
		System.out.println(0);

	}

	private static void check(int i, int j, int c) {
		if(c == 1) {
			if(j-4 >= 0 && i+4 <19 && map[i+1][j-1] == 1 &&  map[i+2][j-2] == 1 &&  map[i+3][j-3] == 1 &&  map[i+4][j-4] == 1) {
				if(i+5<19 && j-5>=0 && map[i+5][j-5] == 1) {

				}
				else if(i-1>=0 && j+1<19 && map[i-1][j+1] == 1) {
					
				}
				else {
					System.out.println(1);
					System.out.println((i+5) +" "+ (j-3));
					System.exit(0);
				}

			}
			if(j+4 < 19 &&  map[i][j+1] == 1 &&  map[i][j+2] == 1 &&  map[i][j+3] == 1 &&  map[i][j+4] == 1) {
				if(j+5<19 && map[i][j+5] == 1) {

				}
				else if(j-1>=0 && map[i][j-1] == 1) {
					
				}
				else {
					System.out.println(1);
					System.out.println((i+1) +" "+ (j+1));
					System.exit(0);

				}

			}
			if(i+4 < 19 && map[i+1][j] == 1 &&  map[i+2][j] == 1 &&  map[i+3][j] == 1 &&  map[i+4][j] == 1) {
				if(i+5<19 && map[i+5][j] == 1) {

				}
				else if(i-1>=0 && map[i-1][j] == 1) {
					
				}
				else {
					System.out.println(1);
					System.out.println((i+1) +" "+ (j+1));
					System.exit(0);

				}
			}
			if(j+4<19 && i+4 <19 && map[i+1][j+1] == 1 &&  map[i+2][j+2] == 1 &&  map[i+3][j+3] == 1 &&  map[i+4][j+4] == 1) {
				if(i+5<19 && j+5<19&& map[i+5][j+5] == 1) {

				}
				else if(i-1>=0 && j-1>=0&& map[i-1][j-1] == 1) {
					
				}
				else {
					System.out.println(1);
					System.out.println((i+1) +" "+ (j+1));
					System.exit(0);

				}
				
			}
		}
		else {
			if(j-4 >= 0 && i+4 <19 && map[i+1][j-1] == 2 &&  map[i+2][j-2] == 2 &&  map[i+3][j-3] == 2 &&  map[i+4][j-4] == 2) {
				if(i+5<19 && j-5>=0 && map[i+5][j-5] == 2) {

				}
				else if(i-1>=0 && j+1<19 && map[i-1][j+1] == 2) {
					
				}
				else {
					System.out.println(1);
					System.out.println((i+5) +" "+ (j-3));
					System.exit(0);

				}

			}
			if(j+4 < 19 &&  map[i][j+1] == 2 &&  map[i][j+2] == 2 &&  map[i][j+3] == 2 &&  map[i][j+4] == 2) {
				if(j+5<19 && map[i][j+5] == 2) {

				}
				else if(j-1>=0 && map[i][j-1] == 2) {
					
				}
				else {
					System.out.println(1);
					System.out.println((i+1) +" "+ (j+1));
					System.exit(0);

				}

			}
			if(i+4 < 19 && map[i+1][j] == 2 &&  map[i+2][j] == 2 &&  map[i+3][j] == 2 &&  map[i+4][j] == 2) {
				if(i+5<19 && map[i+5][j] == 2) {

				}
				else if(i-1>=0 && map[i-1][j] == 2) {
					
				}
				else {
					System.out.println(1);
					System.out.println((i+1) +" "+ (j+1));
					System.exit(0);

				}
			}
			if(j+4<19 && i+4 <19 && map[i+1][j+1] == 2 &&  map[i+2][j+2] == 2 &&  map[i+3][j+3] == 2 &&  map[i+4][j+4] == 2) {
				if(i+5<19 && j+5<19&& map[i+5][j+5] == 2) {

				}
				else if(i-1>=0 && j-1>=0&& map[i-1][j-1] == 2) {
					
				}
				else {
					System.out.println(1);
					System.out.println((i+1) +" "+ (j+1));
					System.exit(0);

				}
				
			}
			
		}
		
	}


}
