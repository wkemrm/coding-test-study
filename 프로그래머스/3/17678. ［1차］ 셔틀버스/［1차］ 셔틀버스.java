
import java.util.*;

class Train {
    int dminute;
    PriorityQueue<Integer> people = new PriorityQueue<>(Collections.reverseOrder());
    public Train(int dminute) {
        this.dminute = dminute;
    }
}
class Solution {
    public int calMinute(int hour, int minute) {
        return hour * 60 + minute;
    }
    
    public String solution(int n, int t, int m, String[] timetable) {
        ArrayList<Train> trainList = new ArrayList<>();
        int startMinute = calMinute(9, 0);
        
        int[] intTimeTable = new int[timetable.length];
        
        for (int i = 0 ; i < timetable.length ; i++) {
            String[] time = timetable[i].split(":");
            int hour = Integer.parseInt(time[0]);
            int minute = Integer.parseInt(time[1]);
            int totalMinute = calMinute(hour, minute);
            intTimeTable[i] = totalMinute;                  
        }
        
        for (int i = 0 ; i < n ; i++) {
            int dminute = startMinute + i * t;
            trainList.add(new Train(dminute));
        }
        
        Arrays.sort(intTimeTable);
        for (int i = 0 ; i < trainList.size() ; i++) {
            Train train = trainList.get(i);
            int dminute = train.dminute;
            int count = 0;
            for (int j = 0 ; j < intTimeTable.length ; j++) {
                if (intTimeTable[j] <= dminute && count < m) {
                    train.people.offer(intTimeTable[j]);
                    intTimeTable[j] = Integer.MAX_VALUE;
                    count++;
                }
            }
        }
        
        Train lastTrain = trainList.get(trainList.size() - 1);
        
        // 만약 꽉 찼을 경우 가장 마지막 탑승고객 분  -1
        // 만약 자리가 남았을 경우 train 도착 시간
        
        if (lastTrain.people.size() == m ) {
            return toTime(lastTrain.people.poll() - 1);
        } else {
            return toTime(lastTrain.dminute);
        }
    }
    
    public String toTime(int totalMinute) {
        int hour = totalMinute / 60;
        int minute = totalMinute % 60;
        return String.format("%02d", hour) + ":" + String.format("%02d", minute);
    }
}