import java.util.Scanner;

public class bj_12919 {
	static String S,T;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		S = sc.next();
		T = sc.next();
		game(T);
		System.out.println(0);
		

	}
	private static void game(String str) {
		if(str.length() == S.length()) {
			if(str.equals(S)) {
				System.out.println(1);
				System.exit(0);
			}
			return;
		}
		if(str.charAt(str.length()-1)== 'A') game(str.substring(0,str.length()-1));
		String nstr = "";
		for(int i=0;i<str.length();i++) {
			nstr = str.charAt(i)+nstr;
		}
		if(nstr.charAt(str.length()-1) == 'B') game(nstr.substring(0,nstr.length()-1));
		
	}

}
