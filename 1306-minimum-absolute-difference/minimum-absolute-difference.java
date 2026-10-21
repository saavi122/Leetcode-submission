class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int dif = Integer.MAX_VALUE;
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 1; i<arr.length; i++){
            int d = arr[i] - arr[i-1];
            if(d < dif){
                dif = d;
                list = new ArrayList<>();
                list.add(Arrays.asList(arr[i-1],arr[i]));
            }else if(d == dif){
                list.add(Arrays.asList(arr[i-1],arr[i]));
            }
        }
        return list;
    }
}