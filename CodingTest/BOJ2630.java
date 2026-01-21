import java.util.*;
import java.io.*;

public class Main {
    private static int n;
    private static int[][] paper;
    private static int[] dr = {0, 0, 1, 1};
    private static int[] dc = {0, 1, 0, 1};
    private static int[] amount = new int[2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        paper = new int[n][n];

        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        countPaper(0, 0, n);
        System.out.println(amount[0] + "\n" + amount[1]);
    }
    private static void countPaper(int startR, int startC, int size) {
        if (checkPaper(startR, startC, size)) {
            if (paper[startR][startC] == 1) {
                amount[1] += 1;
            } else {
                amount[0] += 1;
            }
        } else {
            int newSize = size / 2;
            for (int i = 0; i < 4; i++) {
                int nextR = startR + newSize * dr[i]; // 0 0 1 1
                int nextC = startC + newSize * dc[i]; // 0 1 0 1
                countPaper(nextR, nextC, newSize);
            }
        }
    }
    private static boolean checkPaper(int startR, int startC, int size) {
        int start = paper[startR][startC];
        for (int i = startR; i < startR + size; i++) {
            for (int j = startC; j < startC + size; j++) {
                if (paper[i][j] != start) {
                    return false;
                }
            }
        }
        return true;
    }
}
