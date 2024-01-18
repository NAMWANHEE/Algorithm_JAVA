import java.util.Scanner;

public class softeer_지도자동구축 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int level = 0;
		int cnt = 2;
		while(level != n) {
			
			cnt += cnt-1;
			level++;
		}
		System.out.println(cnt);
		System.out.println((long)Math.pow(cnt, 2));

	}

}
