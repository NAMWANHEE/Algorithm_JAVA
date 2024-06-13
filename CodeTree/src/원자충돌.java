import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 원자충돌 {

	static int n,M,k;
    static List<int[]> map[][];
    static  List<int[]> map2[][];
    static int [] dx = {-1,-1,0,1,1,1,0,-1};
    static int [] dy = {0,1,1,1,0,-1,-1,-1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        M = sc.nextInt();
        k = sc.nextInt();
        map = new List[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                map[i][j] = new ArrayList<>();
            }
        }
        for(int i=0;i<M;i++){
            int x = sc.nextInt()-1;
            int y = sc.nextInt()-1;
            int m = sc.nextInt();
            int s = sc.nextInt();
            int d = sc.nextInt();
            map[x][y].add(new int[]{m,s,d});
        }

        for(int i=0;i<k;i++){
            move();
            compose();

        }
        int ans = 0;
        for(int i=0;i<n;i++) {
        	for(int j=0;j<n;j++) {
        		
        		for(int a[]:map[i][j]) {
        			ans += a[0];
        		}
        	}
        }
        System.out.println(ans);
    }


	private static void compose() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j].size()>=2) {
					int nm=0,ns=0;
					int cnt = map[i][j].size();
					boolean check = false;
					boolean check2 = false;
					while(map[i][j].size() !=0 ) {
						int arr[] = map[i][j].remove(0);
						if(arr[2] %2 ==0) check = true;
						else check2 = true;
						nm += arr[0];
						ns += arr[1];
						
					}
					nm = nm/5;
					if(nm ==0) continue; 
					ns = ns/cnt;
					if(check == true && check2 == true) {
						
						map[i][j].add(new int[] {nm,ns,1});
						map[i][j].add(new int[] {nm,ns,3});
						map[i][j].add(new int[] {nm,ns,5});
						map[i][j].add(new int[] {nm,ns,7});
						
					}
					else {
						map[i][j].add(new int[] {nm,ns,0});
						map[i][j].add(new int[] {nm,ns,2});
						map[i][j].add(new int[] {nm,ns,4});
						map[i][j].add(new int[] {nm,ns,6});
						
					}

				}
			}
		}
		
	}

	public static void move(){
		map2 = new List[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                map2[i][j] = new ArrayList<>();
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                while(map[i][j].size() > 0) {
                	int arr[] = map[i][j].remove(0);
                	int nx, ny;
                	if(i+(dx[arr[2]]*arr[1]) <0) {
                		nx = (i+ (n-(Math.abs(dx[arr[2]]*arr[1])%n))) %n;
                	}
                	else nx = Math.abs(i+dx[arr[2]]*arr[1])% n;
                	if(j+(dy[arr[2]]*arr[1])<0) {
                		ny = (j+ (n-(Math.abs(dy[arr[2]]*arr[1])%n))) %n;
                	}
                	else ny = Math.abs(j+dy[arr[2]]*arr[1])% n;
                	map2[nx][ny].add(arr);
                	
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int a[]: map2[i][j]) {
                	map[i][j].add(new int[] {a[0],a[1],a[2]});
                }
            }
        }
    }

}
