package hot100.graph;

public class LC200 {
    private final int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    boolean[][] isVisited;
    int row;
    int col;

    public int numIslands(char[][] grid) {
        row = grid.length;
        col = grid[0].length;

        int res = 0;

        isVisited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(grid, i, j)) {
                    res++;
                }
            }
        }
        return res;
    }

    private boolean dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= row || j >= col || grid[i][j] == '0' || isVisited[i][j]) {
            return false;
        }

        isVisited[i][j] = true;

        for (int[] dir : dirs) {
            dfs(grid, i + dir[0], j + dir[1]);
        }

        return true;
    }
}
