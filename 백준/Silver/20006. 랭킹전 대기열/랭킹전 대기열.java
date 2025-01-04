import java.util.*;
import java.io.*;

class People implements Comparable<People> {
    int level;
    String name;

    public People(int level, String name) {
        this.level = level;
        this.name = name;
    }

    public int compareTo(People people){
        return this.name.compareTo(people.name);
    }
}
class Room {
    int total;
    int sLevel;
    PriorityQueue<People> peopleQueue = new PriorityQueue<>();

    public Room(int total, People people) {
        this.total = total;
        this.sLevel = people.level;
        this.peopleQueue.offer(people);
    }

    public boolean isVisit(People people) {
        if (people.level >= sLevel - 10 && people.level <= sLevel + 10 && total > peopleQueue.size()) {
            return true;
        } else {
            return false;
        }
    }

    public void add(People people) {
        this.peopleQueue.offer(people);
    }

    public boolean isStarted() {
        if (this.peopleQueue.size() == total) {
            return true;
        } else {
            return false;
        }
    }
}
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Room> roomList = new LinkedList<>();

        for (int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            People people = new People(level, name);
            boolean visit = false;
            for (Room room : roomList) {
                if (room.isVisit(people)) {
                    visit = true;
                    room.add(people);
                    break;
                }
            }

            if (!visit) {
                roomList.add(new Room(m, people));
            }
        }

        for (Room room : roomList) {
            if (room.isStarted()) {
                System.out.println("Started!");
            } else {
                System.out.println("Waiting!");
            }

            while (!room.peopleQueue.isEmpty()) {
                People people = room.peopleQueue.poll();
                System.out.println(people.level + " " + people.name);
            }
        }
    }
}