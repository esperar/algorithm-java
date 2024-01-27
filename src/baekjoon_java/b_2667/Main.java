package baekjoon_java.b_2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] danji;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static List<Integer> result;
    static int cnt, N;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        result = new LinkedList<>();
        N = Integer.parseInt(br.readLine());
        danji = new int[N][N];
        visited = new boolean[N][N];
        cnt = 1;

        for(int i =0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                danji[i][j] = str.charAt(j)-'0';
            }
        }


        for(int x = 0; x < N; x++) {
            for(int y = 0; y < N; y++) {
                if(danji[x][y] == 1 && !visited[x][y]) {
                    dfs(x,y);
                    result.add(cnt);
                    cnt = 1;
                }
            }
        }

        Collections.sort(result);

        System.out.println(result.size());
        for(int r : result) {
            System.out.println(r);
        }

    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        for(int i = 0;i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if(nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && danji[nx][ny]==1) {
                cnt++;
                dfs(nx,ny);
            }
        }
    }
}