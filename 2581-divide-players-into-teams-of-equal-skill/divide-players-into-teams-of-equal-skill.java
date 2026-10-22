class Solution {
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        long sum = 0;
        Arrays.sort(skill);
        int totskill = skill[0]+skill[n-1];
        for(int i = 0; i< n/2; i++){
            if(skill[i] + skill[n-i-1] != totskill) return -1;
            sum += (long) skill[i] * skill[n-i-1];
        }
        return sum;
    }
}