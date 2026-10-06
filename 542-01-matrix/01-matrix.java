class Solution {
    int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i,j});
                }else{
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        while(!q.isEmpty()){
            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];
            for(int[] d : dir){
                int row = r + d[0];
                int col = c + d[1];
                if(row >= 0 && row < n && col >= 0 && col < m && mat[row][col] > mat[r][c]+1){
                    mat[row][col] = mat[r][c]+1;
                    q.add(new int[]{row,col});
                }
            }
        }
        return mat;
    }
}