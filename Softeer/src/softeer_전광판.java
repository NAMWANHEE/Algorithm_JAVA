import java.util.Scanner;

public class softeer_Àü±¤ÆÇ {

	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int map [][] = {
	            {1,1,1,1,1,1,0},
	            {0,0,1,1,0,0,0},
	            {0,1,1,0,1,1,1},
	            {0,1,1,1,1,0,1},
	            {1,0,1,1,0,0,1},
	            {1,1,0,1,1,0,1},
	            {1,1,0,1,1,1,1},
	            {1,1,1,1,0,0,0},
	            {1,1,1,1,1,1,1},
	            {1,1,1,1,1,0,1}
	        };
	        int n = sc.nextInt();
	        for(int z=0;z<n;z++){
	            String a = sc.next();
	            String b = sc.next();
	            int ans = 0;
	            if(a.length() > b.length()){
	                int size = a.length()-b.length();
	                for(int j=0;j<size;j++){
	                    b = "x"+b;
	                }
	            }
	            else if(a.length() < b.length()){
	                int size = b.length()-a.length();
	                for(int j=0;j<size;j++){
	                    a = "x"+a;
	                }
	            }

	            for(int i=0;i<a.length();i++){
	                int cnt = 0;
	                if(b.charAt(i) == 'x'){
	                    for(int j=0;j<7;j++){
	                        if(map[a.charAt(i)-'0'][j] == 1)cnt++;
	                    }
	                }
	                else if(a.charAt(i) =='x'){
	                    for(int j=0;j<7;j++){
	                        if(map[b.charAt(i)-'0'][j] == 1)cnt++;
	                    }
	                }
	                else{
	                    for(int j=0;j<7;j++){
	                        if(map[b.charAt(i)-'0'][j] != map[a.charAt(i)-'0'][j])cnt++;
	                    }
	                }
	                ans += cnt;
	            }
	            System.out.println(ans);
	            
	        }
	    }

}
