import java.util.Scanner;

public class softeer_스마트물류 {

	static int n,k;
	static String str;
	static char[] arr;
	static int ans = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		str = sc.next();
		arr = new char[n];
		for(int i=0;i<str.length();i++) {
			arr[i] = str.charAt(i);
		}
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i) == 'P') {
				if(left(i)) continue;
				right(i);
			}
		}
		System.out.println(ans);

	}

	private static void right(int robot) {
		if(robot+k>=n) {
			for(int i=robot+1;i<n;i++) {
				if(arr[i]=='H') {
					arr[i] = 'X';
					ans++;
					break;
				}
			}
		}
		else {
			for(int i=robot+1;i<=robot+k;i++) {
				if(arr[i]=='H') {
					arr[i] = 'X';
					ans++;
					break;
				}
			}
		}
		
	}

	private static boolean left(int robot) {
		if(robot-k <0) {
			for(int i=0;i<robot;i++) {
				if(arr[i]=='H') {
					arr[i] = 'X';
					ans++;
					return true;
				}
			}
		}
		else {
			for(int i=robot-k;i<robot;i++) {
				if(arr[i]=='H') {
					arr[i] = 'X';
					ans++;
					return true;
				}
			}
		}
		return false;
		
	}

}
