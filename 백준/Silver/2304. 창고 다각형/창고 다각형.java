import java.util.*;
import java.io.*;

class Pillar implements Comparable<Pillar> {
    int index;
    int cost;

    public Pillar(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }

    public int compareTo(Pillar pillar) {
        return pillar.cost - this.cost;
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Pillar[] pillarArr = new Pillar[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int index = Integer.parseInt(st.nextToken());
        int cost = Integer.parseInt(st.nextToken());
        Pillar maxPillar = new Pillar(index, cost);
        int lt = index;
        int rt = index;
        pillarArr[0] = maxPillar;

        for (int i = 1 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            index = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());
            Pillar pillar = new Pillar(index, cost);
            if (maxPillar.cost < pillar.cost) {
                maxPillar = pillar;
            }

            if(lt > pillar.index) {
                lt = pillar.index;
            }

            if (rt < pillar.index) {
                rt = pillar.index;
            }
            pillarArr[i] = pillar;
        }

        List<Pillar> left = new ArrayList<>();
        List<Pillar> right = new ArrayList<>();

        for (int i = 0 ; i < n ; i++) {
            Pillar pillar = pillarArr[i];
            if (pillar.index == maxPillar.index) {
                continue;
            }

            if (pillar.index < maxPillar.index) {
                left.add(pillar);
            } else if(pillar.index > maxPillar.index) {
                right.add(pillar);
            }
        }

        int total = (rt + 1 - lt) * maxPillar.cost;

        int curLt = maxPillar.index;
        Collections.sort(left);
        for (int i = 0 ; i < left.size() ; i++) {
            Pillar pillar = left.get(i);
            if (curLt < pillar.index) {
                continue;
            }

            total -= (maxPillar.cost - pillar.cost) * (curLt - pillar.index);
            curLt = pillar.index;
        }

        int curRt = maxPillar.index + 1;
        Collections.sort(right);
        for (int i = 0 ; i < right.size() ; i++) {
            Pillar pillar = right.get(i);
            if (curRt > pillar.index + 1) {
                continue;
            }

            total -= (maxPillar.cost - pillar.cost) * (pillar.index + 1 - curRt);
            curRt = pillar.index + 1;
        }

        System.out.print(total);
    }
}