import java.util.*;
import java.io.*;

class Team implements Comparable<Team> {
    int teamId;
    int[] jumsu;
    int count;
    int last;

    public Team(int teamId, int k) {
        this.teamId = teamId;
        this.jumsu = new int[k + 1];
    }

    public void updateJumsu(int number, int jumsu, int last) {
        this.last = last;
        this.jumsu[number]  = Math.max(this.jumsu[number], jumsu);
        this.count++;
    }

    public int calJumsu() {
        int sum = 0;
        for (int i = 1 ; i < jumsu.length ; i++) {
            sum += jumsu[i];
        }

        return sum;
    }

    public int compareTo(Team team) {
        int thisJumsu = this.calJumsu();
        int nextJumsu = team.calJumsu();
        if (thisJumsu != nextJumsu) {
            return nextJumsu - thisJumsu;
        }

        if (this.count != team.count) {
            return this.count - team.count;
        }

        return this.last - team.last;
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < t ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int myTeamId = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            HashMap<Integer, Team> map = new HashMap<>();
            for (int j = 0 ; j < n ; j++) {
                map.put(j + 1, new Team(j + 1, k));
            }

            for (int j = 0 ; j < m ; j++) {
                st = new StringTokenizer(br.readLine());
                int id = Integer.parseInt(st.nextToken());
                int number = Integer.parseInt(st.nextToken());
                int jumsu = Integer.parseInt(st.nextToken());

                Team team = map.get(id);
                team.updateJumsu(number, jumsu, j);
            }

            List<Team> teamList = new ArrayList<>(map.values());
            Collections.sort(teamList);
            for (int j = 0 ; j < teamList.size() ; j++) {
                if (teamList.get(j).teamId == myTeamId) {
                    System.out.println(j + 1);
                    break;
                }
            }
        }
    }
}