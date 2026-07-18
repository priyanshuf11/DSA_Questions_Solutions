class NumberOfIslands {
  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }

    int islands = 0;
    int m = grid.length;
    int n = grid[0].length;
    int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    Queue<int[]> q = new ArrayDeque<>();

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == '1') {
          islands++;
          q.offer(new int[] { i, j });

          while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];

            if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != '1') {
              continue;
            }
            grid[x][y] = '0';

            for (int[] dir : directions) {
              int newx = x + dir[0];
              int newy = y + dir[1];

              q.offer(new int[] { newx, newy });
            }
          }
        }
      }
    }
    return islands;
  }
}
