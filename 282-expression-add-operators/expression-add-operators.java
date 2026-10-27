class Solution {
    class State {
        int index;
        long eval;
        long multed;
        String path;

        State(int index, long eval, long multed, String path) {
            this.index = index;
            this.eval = eval;
            this.multed = multed;
            this.path = path;
        }
    }

    public List<String> addOperators(String num, int target) {
        int n = num.length();
        List<String> res = new ArrayList<>();
        Queue<State> q = new LinkedList<>();
        if(num == null || n == 0) return res;
        
        for(int i = 0; i<n; i++){
            if (i > 0 && num.charAt(0) == '0') break;
            long val = Long.parseLong(num.substring(0, i+1));
            q.add(new State(i+1, val, val, num.substring(0, i+1)));
        }

        while(!q.isEmpty()){
            State curr = q.poll();

            if(curr.index == n){
                if (curr.eval == target) res.add(curr.path);
                continue;
            }

            for(int i = curr.index; i<n; i++) {
                if (i > curr.index && num.charAt(curr.index) == '0') break;

                long curVal = Long.parseLong(num.substring(curr.index, i + 1));
                String curStr = num.substring(curr.index, i + 1);

                q.add(new State(i + 1, curr.eval + curVal, curVal, curr.path + "+" + curStr));
                q.add(new State(i + 1, curr.eval - curVal, -curVal, curr.path + "-" + curStr));
                q.add(new State(i + 1, curr.eval - curr.multed + (curr.multed * curVal), curr.multed * curVal, curr.path + "*" + curStr));
            }
        }

        return res;
    }
}