class Solution {
    public String largestNumber(int[] nums) {
        String[] store = new String[nums.length];
        for(int i = 0; i<nums.length; i++){
            store[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(store,(a,b) -> {
            String o1 = a+b;
            String o2 = b+a;
            return o2.compareTo(o1);
        });
        if(store[0].equals("0")) return "0";
        StringBuffer sb = new StringBuffer();
        for(String s : store){
            sb.append(s);
        }
        return sb.toString();
    }
}