public class Solution {
    public static final int[][] dirs = {{0, -1},{-1, 0}, { 0, 1}, {1, 0}};
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0) return 0;
        int max = 1;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] cache = new int[m][n];
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++){
                int len = dfs(matrix, i, j, m, n, cache);
                max = Math.max(max, len);
            }
            return max;
    }
    
    public int dfs(int[][] matrix, int x, int y, int m, int n, int[][] cache){
        if (cache[x][y] != 0)
            return cache[x][y];
        int max = 1;
        for(int[] dir : dirs){
            int nx = x + dir[0];
            int ny = y + dir[1];
            if(nx<0 || nx>=m || ny < 0 || ny >=n || matrix[nx][ny]<=matrix[x][y])
                continue;
            int len = dfs(matrix, nx, ny, m, n, cache) +  1;
            max = Math.max(max, len);
        }
        cache[x][y] = max;
        return max;
    }
}