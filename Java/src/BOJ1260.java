import java.io.*;
import java.util.*;

public class BOJ1260 {

    static int n, m, v;
    static ArrayList<Integer>[] graph;
    static boolean[] check;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.out.println(System.getProperty("user.dir"));
        System.setIn(new FileInputStream("../../input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        check = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 0; i < graph.length; i++) {
            Collections.sort(graph[i]);
        }

        System.out.println(Arrays.toString(graph));

        DFS(v);
        Arrays.fill(check, false);
        sb.append("\n");
        BFS(v);
        System.out.println(sb.toString());
    }

    public static void DFS(int start) {
        if (check[start] == false) {
            sb.append(start).append(" ");
            check[start] = true;
            for (int next : graph[start]) {
                DFS(next);
            }
        }
    }

    public static void BFS(int start) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        while (!q.isEmpty()) {
            int cur = q.remove();
            if (check[cur] == false) {
                sb.append(cur).append(" ");
                check[cur] = true;
                for (int next : graph[cur]) {
                    if (check[next] == false) {
                        q.add(next);
                    }
                }
            }
        }
    }
}