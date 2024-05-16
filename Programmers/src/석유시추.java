import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class 석유시추 {

	public static boolean visit[][];
    public static int check [][];
    public static int dx[] = {1,-1,0,0};
    public static int dy[] = {0,0,1,-1};
    public int solution(int[][] land) {
        int answer = 0;
        int x = land.length;
        int y = land[0].length;
        visit = new boolean[x][y];
        check = new int[x][y];
        int cnt = 1;
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                if(land[i][j] == 1 && !visit[i][j]) bfs(i,j,land,cnt++);
            }
        }

        for(int i=0;i<y;i++){
            int sum = 0;
            boolean ar[] = new boolean[cnt+1];
            for(int j=0;j<x;j++){
                if(ar[check[j][i]]) continue;
                ar[check[j][i]] = true;
                sum += land[j][i];
            }
            answer = Math.max(sum,answer);
        }
        return answer;
    }
    
    public void bfs(int x, int y, int [][] land,int cnt){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x,y});
        visit[x][y] = true;
        int count = 1;
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{x,y});
        check[x][y] = cnt;
        while(!q.isEmpty()){
            int [] arr= q.poll();
            for(int i=0;i<4;i++){
                int nx = arr[0]+dx[i];
                int ny = arr[1]+dy[i];
                if(nx<0||ny<0||nx>=land.length||ny>=land[0].length) continue;
                if(land[nx][ny] == 0) continue;
                if(visit[nx][ny]) continue;
                visit[nx][ny] = true;
                check[nx][ny] = cnt;
                count++;
                q.add(new int[]{nx,ny});
                list.add(new int[]{nx,ny});
            }
        }
        for(int a[] : list){
            land[a[0]][a[1]] = count;
        }
    }

}
