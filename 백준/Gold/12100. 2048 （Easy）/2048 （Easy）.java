import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] arr;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0 ; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < n ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(0, new char[5]);
        System.out.println(max);
    }


    static char[] move = {'u', 'r', 'd', 'l'};

    public static void DFS(int level, char[] target) {
        if(level == 5) {
            int[][] copy = new int[n][n];
            for (int i = 0 ; i < n ; i++) {
                for (int j = 0 ; j < n ; j++) {
                    copy[i][j] = arr[i][j];
                }
            }

            for (int i = 0 ; i < 5 ; i++) {
                switch (target[i]) {
                    case 'u' : {
                        copy = up(copy);
                        break;
                    }
                    case 'r' : {
                        copy = right(copy);
                        break;
                    }
                    case 'd' : {
                        copy = down(copy);
                        break;
                    }
                    case 'l' : {
                        copy = left(copy);
                        break;
                    }
                }
            }
            for (int i = 0 ; i < n ; i++) {
                for (int j = 0 ; j < n ; j++) {
                    max = Math.max(max, copy[i][j]);
                }
            }
        } else {
            for (int i = 0 ; i < 4 ; i++) {
                target[level] = move[i];
                DFS(level + 1, target);
            }
        }
    }

    public static int[][] up(int[][] copy) {
        for (int y = 0 ; y < n ; y++) {
            int[] move = new int[n];
            boolean[] merged = new boolean[n];

            int index = 0;
            for (int x = 0 ; x < n ; x++) {
                if (copy[x][y] == 0) continue;

                if (index == 0) {
                    move[index] = copy[x][y];
                    index++;
                    continue;
                }

                if (move[index - 1] == copy[x][y] && !merged[index - 1]) {
                    move[index - 1] = move[index - 1] + copy[x][y];
                    merged[index - 1] = true;
                } else {
                    move[index] = copy[x][y];
                    index++;
                }
            }

            for (int x = 0 ; x < n ; x++) {
                copy[x][y] = move[x];
            }
        }

        return copy;
    }

    public static int[][] right(int[][] copy) {
        for (int x = 0 ; x < n ; x++) {
            int[] move = new int[n];
            boolean[] merged = new boolean[n];
            int index = n - 1;
            for (int y = n - 1 ; y >= 0 ; y--) {
                if (copy[x][y] == 0) continue;

                if (index == n - 1) {
                    move[index] = copy[x][y];
                    index--;
                    continue;
                }

                if (move[index + 1] == copy[x][y] && !merged[index + 1]) {
                    move[index + 1] = move[index + 1] + copy[x][y];
                    merged[index + 1] = true;
                } else {
                    move[index] = copy[x][y];
                    index--;
                }
            }

            for (int y = n - 1 ; y >= 0 ; y--) {
                copy[x][y] = move[y];
            }
        }

        return copy;
    }

    public static int[][] down(int[][] copy) {
        for (int y = 0 ; y < n ; y++) {
            int[] move = new int[n];
            boolean[] merged = new boolean[n];
            int index = n - 1;
            for (int x = n - 1 ; x >= 0 ; x--) {
                if (copy[x][y] == 0) continue;

                if (index == n - 1) {
                    move[index] = copy[x][y];
                    index--;
                    continue;
                }

                if (move[index + 1] == copy[x][y] && !merged[index + 1]) {
                    move[index + 1] = move[index + 1] + copy[x][y];
                    merged[index + 1] = true;
                } else {
                    move[index] = copy[x][y];
                    index--;
                }
            }

            for (int x = n - 1 ; x >= 0 ; x--) {
                copy[x][y] = move[x];
            }
        }

        return copy;
    }

    public static int[][] left(int[][] copy) {
        for (int x = 0 ; x < n ; x++) {
            int[] move = new int[n];
            boolean[] merged = new boolean[n];
            int index = 0;
            for (int y = 0 ; y < n ; y++) {
                if (copy[x][y] == 0) continue;

                if (index == 0) {
                    move[index] = copy[x][y];
                    index++;
                    continue;
                }

                if (move[index - 1] == copy[x][y] && !merged[index - 1]) {
                    move[index - 1] = move[index - 1] + copy[x][y];
                    merged[index - 1] = true;
                } else {
                    move[index] = copy[x][y];
                    index++;
                }
            }
            for (int y = 0 ; y < n ; y++) {
                copy[x][y] = move[y];
            }
        }

        return copy;
    }
}