import java.io.*;
import java.util.*;

public class BOJ10972 {

    static int n;
    static boolean[] ck;
    static int[] res;
    static int[] curPermutations;
    static ArrayList<int[]> permutations;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("../../input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        ck = new boolean[n + 1];
        res = new int[n];
        curPermutations = new int[n];
        for (int i = 0; i < curPermutations.length; i++) {
            curPermutations[i] = Integer.parseInt(st.nextToken());
        }
        permutations = new ArrayList<int[]>();

        DFS(0);
        for (int i = 0; i < permutations.size(); i++) {
            if (Arrays.equals(permutations.get(i), curPermutations)) {
                if (i == permutations.size() - 1) {
                    sb.append(-1);
                } else {
                    for (int j = 0; j < permutations.get(i).length; j++) {
                        sb.append(permutations.get(i)[j]).append(" ");
                    }
                }
                break;
            }
        }
        System.out.println(sb.toString());
    }

    public static void DFS(int L) {
        if (L == n) {
            int[] temp = new int[n];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = res[i];
            }
            permutations.add(temp);
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
