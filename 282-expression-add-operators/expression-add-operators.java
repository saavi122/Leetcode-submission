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
        List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return result;
        }

        Queue<State> queue = new LinkedList<>();
        
        for (int i = 0; i < num.length(); i++) {
            if (i > 0 && num.charAt(0) == '0') {
                break;
            }
            long val = Long.parseLong(num.substring(0, i + 1));
            queue.add(new State(i + 1, val, val, num.substring(0, i + 1)));
        }

        while (!queue.isEmpty()) {
            State curr = queue.poll();

            if (curr.index == num.length()) {
                if (curr.eval == target) {
                    result.add(curr.path);
                }
                continue;
            }

            for (int i = curr.index; i < num.length(); i++) {
                if (i > curr.index && num.charAt(curr.index) == '0') {
                    break;
                }

                long currentVal = Long.parseLong(num.substring(curr.index, i + 1));
                String currentStr = num.substring(curr.index, i + 1);

                queue.add(new State(i + 1, curr.eval + currentVal, currentVal, curr.path + "+" + currentStr));
                queue.add(new State(i + 1, curr.eval - currentVal, -currentVal, curr.path + "-" + currentStr));
                queue.add(new State(i + 1, curr.eval - curr.multed + (curr.multed * currentVal), curr.multed * currentVal, curr.path + "*" + currentStr));
            }
        }

        return result;
    }
}