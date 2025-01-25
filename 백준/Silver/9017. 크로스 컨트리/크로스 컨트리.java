import java.util.*;
import java.io.*;

class Team implements Comparable<Team> {
    int team;
    List<Integer> jumsu = new ArrayList<>();

    public Team(int team) {
        this.team = team;
    }

    public void addJumsu(int jumsu) {
        this.jumsu.add(jumsu);
    }

    public int compareTo(Team team) {
        int thisCal = this.calFour();
        int nextCal = team.calFour();
        if (this.calFour() != team.calFour()) {
            return thisCal - nextCal;
        }

        return this.jumsu.get(4) - team.jumsu.get(4);
    }

    private int calFour() {
        int sum = 0;
        for (int i = 0 ; i < 4 ; i++) {
            sum += jumsu.get(i);
        }
        return sum;
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < t ; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n + 1];
            HashMap<Integer, Integer> count = new HashMap<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1 ; j <= n ; j++) {
                int input = Integer.parseInt(st.nextToken());
                arr[j] = input;
                count.put(input, count.getOrDefault(input, 0) + 1);
            }

            Map<Integer, Team> teamMap = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
                if (entry.getValue() == 6) {
                    teamMap.put(entry.getKey(), new Team(entry.getKey()));
                }
            }

            int jumsu = 1;
            for (int j = 1 ; j <= n ; j++) {
                if (teamMap.containsKey(arr[j])) {
                    teamMap.get(arr[j]).addJumsu(jumsu);
                    jumsu++;
                }
            }


            List<Team> list = new ArrayList<Team>(teamMap.values());
            Collections.sort(list);
            System.out.println(list.get(0).team);
        }
    }
}