/**
 * Created by zhoucheng on 10/7/17.
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        check(p, q);
        return same;
    }

    private boolean same = true;

    private void check(TreeNode p, TreeNode q) {
        if(same) {
            if(p == null && q == null) return;
            if(p != null && q != null) {
                if(p.val != q.val) same = false;
                else {
                    // val equal, now check left & right child
                    if(p.left != null || q.left != null) {
                        if(p.left != null && q.left != null) {
                            check(p.left, q.left);
                        } else {
                            same = false;
                        }
                    }
                    if(p.right != null || q.right != null) {
                        if(p.right != null && q.right != null) {
                            check(p.right, q.right);
                        } else {
                            same = false;
                        }
                    }
                }
            } else {
                same = false;
            }
        }
    }
}
