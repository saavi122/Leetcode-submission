class Solution {
    public void duplicateZeros(int[] arr) {
        int[] ans = new int[arr.length];
        Arrays.fill(ans,0);
        int i=0, j=0;
        while(j<arr.length){
            if(arr[i]==0){
                j++;
            }else{
                ans[j]=arr[i];
            }
            i++;j++;
        }
        for(int p=0; p<arr.length; p++){
            arr[p]=ans[p];
        }
    }
}