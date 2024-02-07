import java.util.HashMap;
import java.util.Map;

public class 가장많이받은선물 {

	public static void main(String[] args) {

	}
	public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        Map<String,Integer> map = new HashMap<>();
        Map<String,Integer> score = new HashMap<>();
        Map<String,Integer> getcount = new HashMap<>();
        Map<String,Integer> postcount = new HashMap<>();
        int maxCount = 0;
        for(int i=0;i<friends.length;i++){
            map.put(friends[i],i);
            score.put(friends[i],0);
            getcount.put(friends[i],0);
            postcount.put(friends[i],0);
        }
        int arr[][] = new int[friends.length][friends.length];
        for(int i=0;i<gifts.length;i++){
            String gift[] = gifts[i].split(" ");
            String from = gift[0];
            String to = gift[1];
            arr[map.get(from)][map.get(to)] += 1;
        }
        
        for(String from: friends){
            int give = 0;
            int get = 0;
            for(String to : friends){
                if(from.equals(to)) continue;
                give += arr[map.get(from)][map.get(to)];
                get += arr[map.get(to)][map.get(from)];
            }
            score.put(from,give-get);
        }
        for(String from: friends){

            int sum = 0;
            for(String to : friends){
                if(from.equals(to)) continue;
                if(arr[map.get(from)][map.get(to)] > arr[map.get(to)][map.get(from)]) sum++;
                if((arr[map.get(from)][map.get(to)]==0 && arr[map.get(to)][map.get(from)] == 0) ||arr[map.get(from)][map.get(to)] == arr[map.get(to)][map.get(from)]){
                    if(score.get(from) > score.get(to)) sum++;
                }
            }
            getcount.put(from,sum);
            answer = Math.max(answer, sum);

        }
        
        return answer;
    }

}
