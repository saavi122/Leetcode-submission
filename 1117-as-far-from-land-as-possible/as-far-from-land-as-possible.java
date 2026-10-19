class Solution {
    int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1) q.offer(new int[]{i, j});
            }
        }
        if (q.isEmpty() || q.size() == n*n) return -1;
        int res = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            res++;
            while (size-- > 0) {
                int[] cell = q.poll();
                int r = cell[0];
                int c = cell[1];
                for (int[] d : dir) {
                    int i = r + d[0], j = c + d[1];
                    if (i >= 0 && i < n && j >= 0 && j < n && grid[i][j] == 0) {
                        grid[i][j] = 1;
                        q.offer(new int[]{i, j});
                    }
                }
            }
        }
        return res;
    }
}