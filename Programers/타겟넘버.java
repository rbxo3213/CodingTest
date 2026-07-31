/*
간단한 백트래킹 문제인데.. 더 간단하게 풀 수 있지만 아직 어렵다
가지치기 잘못해서 틀렸음.
for 문에서 continue를 넣으면 안 됐다 (합이 target을 넘었다가도 다시 내려올 수 있기 때문)
*/

class Solution {
    public int dest;
    public int answer = 0;
    public int[] sign = {-1, 1};
    public int solution(int[] numbers, int target) {
        dest = numbers.length;
        
        dfs(numbers, target, 0, 0);
        return answer;
    }
    public void dfs(int[] numbers, int target, int sum, int depth) {
        if (depth == dest) {
            if (sum == target) {
                answer += 1;
            }
            return;
        }
        
        for (int i = 0; i < 2; i++) {
            int tmp = sum + numbers[depth] * sign[i];
            dfs(numbers, target, tmp, depth + 1);
            
        }
    }
}
