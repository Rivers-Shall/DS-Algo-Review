import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class PreorderTraverse {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.empty()) {
            while (node != null) {
                result.add(node.val);
                stack.push(node);
                node = node.left;
            }

            if (!stack.empty()) {
                node = stack.pop();
                node = node.right;
            }
        }
        return result;
    } 
}