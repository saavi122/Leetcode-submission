import java.util.*;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // Map each email to the index of the account it first appeared in
        Map<String, Integer> emailToAccountIdx = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                
                if (emailToAccountIdx.containsKey(email)) {
                    // If this email was seen before, union the current account 
                    // with the previous account that had this email
                    int root1 = find(i, parent);
                    int root2 = find(emailToAccountIdx.get(email), parent);
                    if (root1 != root2) {
                        parent[root2] = root1;
                    }
                } else {
                    emailToAccountIdx.put(email, i);
                }
            }
        }

        // Group all emails by their DSU root parent
        Map<Integer, List<String>> components = new HashMap<>();
        for (String email : emailToAccountIdx.keySet()) {
            int accountIdx = emailToAccountIdx.get(email);
            int rootParent = find(accountIdx, parent);
            
            components.putIfAbsent(rootParent, new ArrayList<>());
            components.get(rootParent).add(email);
        }

        // Sort emails, attach the name, and build final result
        List<List<String>> result = new ArrayList<>();
        for (int rootIdx : components.keySet()) {
            List<String> emails = components.get(rootIdx);
            Collections.sort(emails);

            String name = accounts.get(rootIdx).get(0);
            List<String> mergedAccount = new ArrayList<>();
            mergedAccount.add(name);
            mergedAccount.addAll(emails);

            result.add(mergedAccount);
        }

        return result;
    }

    private int find(int i, int[] parent) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = find(parent[i], parent); // Path compression
    }
}