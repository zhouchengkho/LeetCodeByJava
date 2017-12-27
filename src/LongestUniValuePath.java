import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhoucheng on 10/17/17.
 */
public class LongestUniValuePath {
    public int longestUnivaluePath(TreeNode root) {
        if(root == null) return 0;
        track(root);
        return max;
    }

    int max = 0;

    private int track(TreeNode node) {
        int l = node.left == null ? 0 : track(node.left);
        int r = node.right == null ? 0 : track(node.right);
        int conL = node.left != null && node.left.val == node.val ? l+1 : 0;
        int conR = node.right != null && node.right.val == node.val ? r+1 : 0;
        max = Math.max(max, conL+conR);
        return Math.max(conL, conR);
    }


    class Tree {
        int val;
        List<Tree> children;
        Tree(int v) {
            val = v;
            children = new LinkedList<>();
        }
    }

    public int sol(int[] a, int[] e) {
        Tree[] t = new Tree[a.length];

        for(int i = 0; i < a.length; i++) {
            t[i] = new Tree(a[i]);
        }


        for(int i = 0; i < e.length; i+=2) {
            t[i].children.add(t[i+1]);
        }

        max = 0;
        dfs(t[0]);
        return max;
    }

    private int dfs(Tree t) {
        if(t.children.size() == 0) {
            max = 1;
            return 1;
        } else {
            int[] len = new int[t.children.size()];
            int[] cl = new int[t.children.size()];
            for(int i = 0; i < t.children.size(); i++) {
                len[i] = dfs(t.children.get(i));
            }

            for(int i = 0; i < t.children.size(); i++) {
                cl[i] = t.children.size() == 0 ? 1 : t.val == t.children.get(i).val ? len[i] + 1 : 1;
            }

            max = 1; // find largest pair
            return 1; // return largest pair
        }
    }


}
