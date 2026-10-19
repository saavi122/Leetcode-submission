class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<>(Arrays.asList(deadends));
        if(set.contains("0000")) return -1;
        Queue<Pair<String,Integer>> q = new LinkedList<>();
        q.add(new Pair<>("0000",0));
        Set<String> vis = new HashSet<>();
        vis.add("0000");
        while(!q.isEmpty()){
            Pair<String,Integer> cur = q.poll();
            String key = cur.getKey();
            int moves = cur.getValue();
            if(key.equals(target)){
                return moves;
            }
            for (int i = 0; i < 4; i++) {
                for (int delta : new int[]{-1, 1}) {
                    int newdigi = (key.charAt(i) - '0' + delta + 10) % 10;
                    String newcombi = key.substring(0, i) + newdigi + key.substring(i + 1);
                    
                    if (!vis.contains(newcombi) && !set.contains(newcombi)) {
                        vis.add(newcombi);
                        q.add(new Pair<>(newcombi, moves + 1));
                    }
                }
            }
        }
        return -1;
    }
}