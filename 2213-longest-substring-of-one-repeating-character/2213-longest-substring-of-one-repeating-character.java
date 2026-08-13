class Solution {
    class Node {
        char leftChar, rightChar;
        int prefixLen, suffixLen, maxLen, length;

        Node(char c) {
            leftChar = c;
            rightChar = c;
            prefixLen = 1;
            suffixLen = 1;
            maxLen = 1;
            length = 1;
        }

        Node(Node left, Node right) {
            leftChar = left.leftChar;
            rightChar = right.rightChar;
            length = left.length + right.length;
            
            prefixLen = left.prefixLen;
            if (left.prefixLen == left.length && left.rightChar == right.leftChar) {
                prefixLen += right.prefixLen;
            }
            
            suffixLen = right.suffixLen;
            if (right.suffixLen == right.length && right.rightChar == left.rightChar) {
                suffixLen += left.suffixLen;
            }
            
            maxLen = Math.max(left.maxLen, right.maxLen);
            if (left.rightChar == right.leftChar) {
                maxLen = Math.max(maxLen, left.suffixLen + right.prefixLen);
            }
        }
    }

    Node[] tree;
    char[] chars;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        int k = queryCharacters.length();
        chars = s.toCharArray();
        tree = new Node[4 * n];
        
        build(0, 0, n - 1);

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            int idx = queryIndices[i];
            char c = queryCharacters.charAt(i);
            chars[idx] = c;
            
            update(0, 0, n - 1, idx, c);
            ans[i] = tree[0].maxLen;
        }
        return ans;
    }

    private void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = new Node(chars[start]);
            return;
        }
        int mid = (start + end) / 2;
        build(2 * node + 1, start, mid);
        build(2 * node + 2, mid + 1, end);
        tree[node] = new Node(tree[2 * node + 1], tree[2 * node + 2]);
    }

    private void update(int node, int start, int end, int idx, char c) {
        if (start == end) {
            tree[node] = new Node(c);
            return;
        }
        int mid = (start + end) / 2;
        if (idx <= mid) {
            update(2 * node + 1, start, mid, idx, c);
        } else {
            update(2 * node + 2, mid + 1, end, idx, c);
        }
        tree[node] = new Node(tree[2 * node + 1], tree[2 * node + 2]);
    }
}
