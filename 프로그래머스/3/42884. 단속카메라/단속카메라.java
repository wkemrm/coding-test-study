import java.util.*;

class Route implements Comparable<Route>{
    int start;
    int end;
    public Route(int start, int end) {
        this.start = start;
        this.end = end;
    }
    
    public int compareTo(Route route) {
        return this.end - route.end;
    }
}
class Solution {
    public int solution(int[][] routes) {
        Route[] routeArray = new Route[routes.length];
        for (int i = 0 ; i < routes.length ; i++) {
            routeArray[i] = new Route(routes[i][0], routes[i][1]);
        }
    
        Arrays.sort(routeArray);
        
        int end = routeArray[0].end;
        int count = 1;
        for (int i = 1 ; i < routeArray.length ; i++) {
            if (routeArray[i].start <= end && routeArray[i].end >= end) {
                continue;
            }
            count++;
            end = routeArray[i].end;
        }
        return count;
    }
}