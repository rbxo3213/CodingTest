/*
오랜만에 풀어본 2차원 배열 좌표이동 문제인데...
dr과 dc도 헷갈리고, 위치 갱신도 헷갈리고..
주의할 점이 많다.
1. dr과 dc를 거꾸로 해서 오류
2. route 배열을 반복문으로 탐색하여 명령 수행할 때, 현재 위치를 이전 위치로부터 받아서 nextR, nextC를 설정해야 하는데,,
  자꾸 nextR, nextC = 0으로 초기화시켜서 오류....
하다보면 늘겠지..? 오랜만에 하니까 정말 잘 안 된다.
*/

import java.util.*;
class Solution {
    // 방향배열 - 상하좌우 - N S W E
    public static int[] dc = {0, 0, -1, 1};
    public static int[] dr = {-1, 1, 0, 0};
    public static char[][] graph;
    
    public int[] solution(String[] park, String[] routes) {
        // 그래프 그리기..
        graph = new char[park.length][park[0].length()];
        
        // 시작점 찾기
        int[] start = new int[2]; // 0 : r, 1 : c
        
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                graph[i][j] = park[i].charAt(j);
                if (park[i].charAt(j) == 'S') {
                    start[0] = i;
                    start[1] = j;
                }
                //System.out.print(graph[i][j]);
            }
            //System.out.println();
        }
        
        // 명령어 파싱하기 -> routes의 op를 getDir에 집어넣고, dr, dc 배열에 그 인덱스를 넣기 * 이동할 수 하기 해서 현 위치에 더하면 됨.
        
        // 이동하다가 X를 만나면 다음 명령으로 넘어가야 하므로.. 곱하면 안 되고 한 칸씩 이동하다 돌아가야 할듯?
        for (String route : routes) {
            int[] tmp = goRoute(start, route);
            //System.out.println(Arrays.toString(tmp));
            start[0] = tmp[0];
            start[1] = tmp[1];
        }
        
        return start;
    }
    private int getDir(char c) {
        if (c == 'N') {
            return 0;
        } else if (c == 'S') {
            return 1;
        } else if (c == 'W') {
            return 2;
        } else {
            return 3;
        }
    }
    
    private int[] goRoute(int[] start, String route) {
        //System.out.println("시작점 : " + start[0] + " " + start[1]);
        int dir = getDir(route.charAt(0));
        int n = Integer.parseInt(route.charAt(2) + "");
        //System.out.println(dir + " " + n);
        int nextR = start[0];
        int nextC = start[1];
        for (int i = 0; i < n; i++) {
            nextR += dr[dir];
            nextC += dc[dir];
            if (nextR < 0 || nextR >= graph.length || nextC < 0 || nextC >= graph[0].length) {
                //System.out.println("x1");
                return start;
            }
            if (graph[nextR][nextC] == 'X') {
                //System.out.println("x2");
                return start;
            }
        }
        return new int[] {nextR, nextC};
    }
}
