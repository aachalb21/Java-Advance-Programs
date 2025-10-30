class Solution {
    int[][] grid;
    int n, m;
    int[][] dp;

    public int calculateMinimumHP(int[][] dungeon) {
        grid = dungeon;
        n = grid.length;
        m = grid[0].length;
        dp = new int[n][m];
        for (int[] row : dp) Arrays.fill(row, -1);
        return dfs(0, 0);
    }

    private int dfs(int i, int j) {
        // If out of bounds, return infinity (unreachable path)
        if (i >= n || j >= m) return Integer.MAX_VALUE;

        // Base case: bottom-right cell (princess)
        if (i == n - 1 && j == m - 1)
            return Math.max(1, 1 - grid[i][j]);

        // Memoized value
        if (dp[i][j] != -1) return dp[i][j];

        int down = dfs(i + 1, j);
        int right = dfs(i, j + 1);

        int health = Math.min(down, right) - grid[i][j];
        dp[i][j] = Math.max(health, 1);

        return dp[i][j];
    }
}
