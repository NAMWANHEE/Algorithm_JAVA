import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class 고대문명유적탐사 {

	static int map[][];
	static int map2[][];
    static int getCount;
    public static void main(String[] args) {
        Scanner sc=  new Scanner(System.in);
        int k = sc.nextInt();
        int m = sc.nextInt();
        map = new int[5][5];
        map2 = new int[5][5];
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                map[i][j] = sc.nextInt();
            }
        }
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0;i<m;i++){
            q.add(sc.nextInt());
        }
        StringBuilder sb = new StringBuilder();
        for(int t=0;t<k;t++) {
        	getCount = 0;
            int ans = 0;

            for(int i=1;i<4;i++){
                for(int j=1;j<4;j++){
                    ninety(j,i,1);
                }
            }
            for(int i=1;i<4;i++){
                for(int j=1;j<4;j++){
                    ninety(j,i,2);
                }
            }
            for(int i=1;i<4;i++){
                for(int j=1;j<4;j++){
                    ninety(j,i,3);
                }
            }
            

            
            while(true) {
            	for(int i=0;i<5;i++) {
            		for(int j=4;j>=0;j--) {
            			if(map2[j][i] ==0) map2[j][i] = q.poll();
            		}
            	}
            	boolean visit[][] = new boolean[5][5];
            	List<int[]> li = new ArrayList<>();
            	int cnt = 0;
                for(int i=0;i<5;i++){
                    for(int j=0;j<5;j++){
                        if(!visit[i][j]){
                            visit[i][j] = true;
                            cnt += bfs(i,j,map2[i][j], map2, visit,li);

                        }
                    }
                }
                for(int a[] : li) {
            		map2[a[0]][a[1]] = 0;
            	}
                if(cnt ==0) break;
                ans += cnt;
            }
            if(ans+getCount ==0) break;
            //System.out.println(ans+getCount);
            sb.append(ans+getCount+" ");
            for(int i=0;i<5;i++) {
            	for(int j=0;j<5;j++) {
            		map[i][j] = map2[i][j];
            	}
            }
        }
        System.out.println(sb);
        
        
        
    }

    public static void ninety(int x, int y, int c){
        int nmap[][] = new int[5][5];
        boolean visit[][] = new boolean[5][5];

        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                nmap[i][j] = map[i][j];
            }
        }
        if(c == 1) {
        	for(int i=x-1;i<=x+1;i++){
                for(int j=y-1;j<=y+1;j++){
                    nmap[i][j] = map[x+1-j+y-1][y-1+i-x+1];
                }
            }
        }
        else if(c == 2) {
        	for(int i=x-1;i<=x+1;i++){
                for(int j=y-1;j<=y+1;j++){
                    nmap[i][j] = map[x+1-i+x-1][y+1-j+y-1];
                }
            }
        }
        else {
        	for(int i=x-1;i<=x+1;i++){
                for(int j=y-1;j<=y+1;j++){
                    nmap[i][j] = map[x-1+j-y+1][y+1-i+x-1];
                }
            }
        }
        

        int cnt = 0;
        List<int[]> li = new ArrayList<>();
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(!visit[i][j]){
                    visit[i][j] = true;
                    cnt += bfs(i,j,nmap[i][j], nmap, visit,li);

                }
            }
        }
        if(cnt > getCount) {
        	getCount = cnt;
        	for(int i=0;i<5;i++) {
        		for(int j=0;j<5;j++) {
        			map2[i][j] = nmap[i][j];
        		}
        	}
        	for(int a[] : li) {
        		map2[a[0]][a[1]] = 0;
        	}
        }

        
    }

    public static int bfs(int x, int y, int number, int[][] nmap, boolean[][] visit, List<int[]> li){
        int dx [] = {1,-1,0,0};
        int dy [] = {0,0,1,-1};
        int cnt = 1;
        List<int[]> list = new ArrayList<>();
        list.add(new int[] {x,y});
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x,y});
        while(!q.isEmpty()){
            int arr[] = q.poll();

            for(int i=0;i<4;i++){
                int nx = dx[i] + arr[0];
                int ny = dy[i] + arr[1];
                if(nx<0||ny<0||nx>=5||ny>=5) continue;
                if(nmap[nx][ny] == number && !visit[nx][ny]){

                    visit[nx][ny] = true;
                    list.add(new int[] {nx,ny});
                    cnt++;
                    q.add(new int[]{nx,ny});
                }
            }
        }
        if(cnt>=3) {
        	for(int a[]: list) {
        		li.add(a);
        	}
        	return cnt;
        }
        else return 0;

    }

}
