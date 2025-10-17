import java.util.*;
import java.io.*;

class Main {
    static int n;
    static Room[] rooms;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        rooms = new Room[n];

        for (int i = 0 ; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            rooms[i] = new Room(start, end);
        }

        Arrays.sort(rooms);
        int count = 1;
        int end = rooms[0].end;

        for (int i = 1 ; i < n ; i++) {
            int start = rooms[i].start;
            
            if (start >= end) {
                end = rooms[i].end;
                count++;
            }
        }

        System.out.print(count);
    }

    static class Room implements Comparable<Room>{
        int start;
        int end;
        public Room(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Room room) {
            if (this.end != room.end) {
                return this.end - room.end;
            }
            return this.start - room.start;
        }
    }
}