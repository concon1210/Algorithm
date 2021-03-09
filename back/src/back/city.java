package back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class city { 

    public static int n, m, k, x;
    public static ArrayList<ArrayList<Integer>> graph
            = new ArrayList<ArrayList<Integer>>();

    // 紐⑤뱺 �룄�떆�뿉 ���븳 理쒕떒 嫄곕━ 珥덇린�솕
    public static int[] d = new int[300001];
//INF = new int[1e9] 臾댄븳
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // �룄�떆�쓽 媛��닔
        m = Integer.parseInt(st.nextToken()); // �룄�떆�쓽 媛��닔
        k = Integer.parseInt(st.nextToken()); // 嫄곕━ �젙蹂�
        x = Integer.parseInt(st.nextToken()); // 異쒕컻 �룄�떆�쓽 踰덊샇

        // 洹몃옒�봽 諛� 理쒕떒 嫄곕━ �뀒�씠釉� 珥덇린�솕
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
            d[i] = -1;
        }

        // �룄�떆 �겮由ъ쓽 �떒諛⑺뼢 �뿰寃� �젙蹂�
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a =Integer.parseInt(st.nextToken());
            int b =Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }

        // 異쒕컻 �룄�떆源뚯��쓽 嫄곕━�뒗 0�쑝濡� �꽕�젙
        d[x] = 0;

        // BFS
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(x);

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i < graph.get(now).size(); i++) {
                int nextNode = graph.get(now).get(i);

                if (d[nextNode] == -1) {
                    d[nextNode] = d[now] + 1;
                    q.offer(nextNode);
                }
            }
        }

        // 理쒕떒 嫄곕━媛� K �씤 紐⑤뱺 �룄�떆�쓽 踰덊샇瑜� �삤由꾩감�닚 異쒕젰
        boolean check = false;
        for (int i = 1; i <= n; i++) {
            if (d[i] == k) {
                System.out.println(i);
                check = true;
            }
        }

        // 理쒕떒嫄곕━�씤 K�씤 �룄�떆媛� �뾾�쑝硫� -1 異쒕젰 
        if (!check) {
            System.out.println(-1);
        }
    }
}