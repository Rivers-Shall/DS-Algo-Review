import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class PostOrderTraverse {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root, lastVisited = null;
        while (node != null || !stack.empty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.peek();
            if (node.right == null || node.right == lastVisited) {
                result.add(node.val);
                stack.pop();
                lastVisited = node;
                node = null;
            } else {
                node = node.right;
            }
        }
        return result;
    }
}