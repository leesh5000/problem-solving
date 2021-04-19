import java.io.*;
import java.util.*;

public class BOJ10974 {

    static int n;
    static boolean[] ck;
    static int[] res;
    static ArrayList<int[]> permu;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("../../input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        ck = new boolean[n + 1];
        res = new int[n];

        DFS(0);
        System.out.println(sb.toString());
    }

    public static void DFS(int L) {
        if (L == n) {
            for (int i = 0; i < res.length; i++) {
                sb.append(res[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = 1; i <= n; i++) {
                if (ck[i] == false) {
                    ck[i] = true;
                    res[L] = i;
                    DFS(L + 1);
                    ck[i] = false;
                }
            }
        }
    }
}
