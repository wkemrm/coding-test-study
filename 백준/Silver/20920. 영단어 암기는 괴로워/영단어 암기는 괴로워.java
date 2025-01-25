import java.util.*;
import java.io.*;

class Word implements Comparable<Word> {
    String word;
    int count;
    int length;

    public Word(String word, int count) {
        this.word = word;
        this.count = count;
        this.length = word.length();
    }

    public int compareTo(Word word) {
        if (this.count != word.count) {
            return word.count - this.count;
        }

        if (this.length != word.length) {
            return word.length - this.length;
        }

        return this.word.compareTo(word.word);
    }
}
class Main {
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0 ; i < n ; i++) {
            String input = br.readLine();
            if (input.length() >= m) {
                map.put(input, map.getOrDefault(input, 0) + 1);
            }
        }

        PriorityQueue<Word> pq = new PriorityQueue<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(new Word(entry.getKey(), entry.getValue()));
        }

        while(!pq.isEmpty()) {
            bw.write(pq.poll().word + "\n");
        }
        bw.flush();
    }
}