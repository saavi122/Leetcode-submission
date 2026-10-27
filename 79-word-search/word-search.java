class Solution {
    int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(board[i][j] == word.charAt(0)){
                    if(find(board,word,i,j,0)) return true;
                }
            }
        }
        return false;
    }
    public boolean find(char[][] board, String word,int i, int j, int idx){
        if(idx == word.length()) return true;
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(idx)) return false;
        if(idx == word.length() - 1) return true;
        char temp = board[i][j];
        board[i][j] = '1';

        for(int [] d : dir){
            int r = i+d[0];
            int c = j+d[1];
            if(find(board,word, r,c,idx+1)){
                board[r][c] = temp;
                return true;
            }
        }
        board[i][j] = temp;
        return false;
    }
}