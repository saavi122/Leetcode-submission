class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int n = list1.length;
        int m = list2.length;
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            map.put(list1[i],i);
        }
        List<String> res = new ArrayList<>();
        int minsum = Integer.MAX_VALUE;
        for(int i = 0; i<m; i++){
            String s = list2[i];
            if(map.containsKey(s)){
                int sum = map.get(s)+i;
                if(sum < minsum){
                    minsum = sum;
                    res.clear();
                    res.add(s);
                }else if(sum == minsum){
                    res.add(s);
                }
            }
        }
        return res.toArray(new String[0]);
    }
}