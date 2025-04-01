import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[] isPrime = new boolean[n + 1];
        isPrime[0] = isPrime[1] = true;

        for (int i = 2; i * i <= n; i++) {
            if (!isPrime[i]) {
                for (int j = i + i; j <= n; j += i) {
                    isPrime[j] = true;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (!isPrime[i]) {
                primes.add(i);
            }
        }

        int result = 0, sum = 0, start = 0, end = 0;
        while (true) {
            if (sum >= n) {
                sum -= primes.get(start++);
            } else if (end == primes.size()) {
                break;
            } else {
                sum += primes.get(end++);
            }

            if (sum == n) {
                result++;
            }
        }

        System.out.println(result);
    }
}
