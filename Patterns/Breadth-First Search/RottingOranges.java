class RottingOranges {
  public int orangesRotting(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    int[][] visited = grid;
    Queue<int[]> q = new LinkedList<>();
    int freshOrange = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (visited[i][j] == 2) {
          q.offer(new int[] { i, j });
        }
        if (visited[i][j] == 1) {
          freshOrange++;
        }
      }
    }
    if (freshOrange == 0) {
      return 0;
    }
    if (q.isEmpty()) {
      return -1;
    }

    int minutes = -1;
    int[][] direction = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    while (!q.isEmpty()) {
      int size = q.size();
      while (size-- > 0) {
        int[] cell = q.poll();
        int row = cell[0];
        int col = cell[1];
        for (int[] dir : direction) {
          int nRow = row + dir[0];
          int nCol = col + dir[1];
          if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && visited[nRow][nCol] == 1) {
            visited[nRow][nCol] = 2;
            freshOrange--;
            q.offer(new int[] { nRow, nCol });
          }
        }
      }
      minutes++;
    }
    if (freshOrange == 0)
      return minutes;

    return -1;
  }
}
