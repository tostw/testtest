
public class BSTIterator {
    private Stack<TreeNode> stack = null;
    
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode curr = root; 
        while(curr != null) {
            stack.push(curr);
            if (curr.left != null) {
            curr = curr.left;
            } else {
                break;
            }
        }
        
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        TreeNode cur = node; 
        if (cur.right != null) {
            cur = cur.right;
            while(cur != null) {
                stack.push(cur);
                if (cur.left != null) {
                    cur = cur.left;
                } else {
                    break;
                }
            }
        }
        return node.val;
        
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */