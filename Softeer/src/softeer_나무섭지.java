import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class softeer_³ª¹«¼·Áö {

	static int dx[] = {1,-1,0,0};
    static int dy[] = {0,0,1,-1};
    static int n,m;
    static char[][] map;
    static int [][] ghost;
    static int [][] people;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new char[n][m];
        ghost = new int[n][m];
        people = new int[n][m];
        int exit [] = new int[2];
        int person[] = new int[2];
        List<int[]> glist = new ArrayList<>();
        for(int i=0;i<n;i++){
            String str = sc.next();
            for(int j=0;j<m;j++){
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'D') {
                    exit[0] = i;
                    exit[1] = j;    
                }
                else if(map[i][j] == 'G'){
                    glist.add(new int[]{i,j});
                }
                else if(map[i][j] == 'N'){
                    person[0] = i;
                    person[1] = j;
                }
            } 
        }
        
        int ghostt = bfs(exit[0],exit[1]);
        
        bfs2(person[0],person[1]);
        if(ghostt <= people[exit[0]][exit[1]] || people[exit[0]][exit[1]] == 0) System.out.println("No");
        else System.out.println("Yes");
    }
    public static void bfs2(int x, int y){
        boolean visit[][] = new boolean [n][m];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x,y});
        visit[x][y] = true;
        while(!q.isEmpty()){
            int arr[] = q.poll();
            for(int i=0;i<4;i++){
                int nx = arr[0] + dx[i];
                int ny = arr[1] + dy[i];
                if(nx<0||ny<0||nx>=n||ny>=m) continue;
                if(visit[nx][ny]) continue;
                if(map[nx][ny] == '#') continue;
                if(map[nx][ny] == 'G') continue;
                if(people[nx][ny] !=0 && people[nx][ny] < people[arr[0]][arr[1]]+1) continue;
                visit[nx][ny] = true;
                people[nx][ny] = people[arr[0]][arr[1]]+1;
                q.add(new int[]{nx,ny});
            }
        }
    }
    
    public static int bfs(int x, int y){
        boolean visit[][] = new boolean [n][m];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x,y});
        visit[x][y] = true;
        while(!q.isEmpty()){
            int arr[] = q.poll();
            for(int i=0;i<4;i++){
                int nx = arr[0] + dx[i];
                int ny = arr[1] + dy[i];
                if(nx<0||ny<0||nx>=n||ny>=m) continue;
                if(visit[nx][ny]) continue;
                if(map[nx][ny] == 'G'){
                    return ghost[arr[0]][arr[1]]+1;
                }
                visit[nx][ny] = true;
                ghost[nx][ny] = ghost[arr[0]][arr[1]]+1;
                q.add(new int[]{nx,ny});
            }
        }
        return 0;
    }

}
