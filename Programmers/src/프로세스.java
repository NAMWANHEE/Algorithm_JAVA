import java.util.ArrayDeque;
import java.util.Queue;

public class 프로세스 {

	public int solution(int[] priorities, int location) {
        int answer = 1;
        int cnt[] = new int[10];
        Queue<int[]> q = new ArrayDeque<>();
        for(int i=0;i<priorities.length;i++){
            q.add(new int[]{priorities[i],i});
            cnt[priorities[i]]++;
        }
        
        while(true){
            int arr[] = q.poll();
            boolean check = true;
            for(int i=arr[0]+1;i<10;i++){
                if(cnt[i]>0){
                    q.add(arr);
                    check = false;
                    break;
                }
            }
            if(check){
                if(arr[1] == location) break;
                cnt[arr[0]]--;
                answer++;
            }
        }
        return answer;
    }

}
