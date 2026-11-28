class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int s = 0, e = n-1, row = 0;
        while(s <= e){
            int mid = s + (e-s)/2;
            if(target >= matrix[mid][0]){
                s = mid+1;
                row = mid;
            }else{
                e = mid-1;
            }
        }
        s = 0; e = m-1;
        while(s <= e){
            int mid = s + (e-s)/2;
            if(target == matrix[row][mid]) return true;
            else if(target > matrix[row][mid]) s = mid+1;
            else e = mid-1;
        }
        return false;
    }
}