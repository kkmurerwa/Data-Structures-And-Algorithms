package Trees;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    TreeNode root;

    public void add(int value) {
        root = addRecursive(root, value);
    }

    private TreeNode addRecursive(TreeNode current, int value) {
        if (current == null) {
            return new TreeNode(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            // Return current if value already exists.
            return current;
        }

        return current;
    }

    public void dfsInOrderTraversal(TreeNode current) {
        if (current != null) {
            dfsInOrderTraversal(current.left);
            System.out.print(current.value + " ");
            dfsInOrderTraversal(current.right);
        }
    }

    public void dfsInOrderTraversalWithStack() {
        if (root == null) return;
 
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode curr = root;
 
        while (curr != null || s.size() > 0) {
            while (curr !=  null) {
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
 
            System.out.print(curr.value + " ");
 
            curr = curr.right;
        }
    }

    public void dfsPreOrderTraversal(TreeNode current) {
        if (current != null) {
            System.out.print(current.value + " ");
            dfsPreOrderTraversal(current.left);
            dfsPreOrderTraversal(current.right);
        }
    }

    public void dfsPreOrderTraversalWithStack() {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            System.out.print(curr.value + " ");

            if (curr.right != null) {
                stack.push(curr.right);
            }

            if (curr.left != null) {
                stack.push(curr.left);
            }
        }
    }
    
    public void dfsPostOrderTraversal(TreeNode current) {
        if (current != null) {
            dfsPostOrderTraversal(current.left);
            dfsPostOrderTraversal(current.right);
            System.out.print(current.value + " ");
        }
    }

     public void dfsPostOrderTraversalWithStack(TreeNode head) {
        TreeNode temp = root;    
        HashSet<TreeNode> visited = new HashSet<>();
        while (temp != null  && !visited.contains(temp)) {
            if (temp.left != null && !visited.contains(temp.left)) {
                temp = temp.left;
            } else if (temp.right != null && !visited.contains(temp.right)) {
                temp = temp.right;
            } else {
                System.out.printf("%d ", temp.value);
                visited.add(temp);
                temp = head;
            }
        }
    }

    public void bfsTraversal() {
        if (root == null) {
            return;
        }

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            TreeNode current = nodes.remove();
            System.out.print(current.value + " ");

            if (current.left != null) {
                nodes.add(current.left);
            }

            if (current.right != null) {
                nodes.add(current.right);
            }
        }
    }

    public boolean containsWithQueue(int value) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            TreeNode current = nodes.remove();

            if (current == null) {
                return false;
            }

            if (current.value < value) {
                nodes.add(current.left);
            } else if (current.value > value) {
                nodes.add(current.right);
            } else {
                return true;
            }
        }

        return false;
    }

    public boolean containsRecursively(int value, TreeNode node) {
        if (node == null) {
            return false;
        }

        if (node.value < value) {
            return containsRecursively(value, node.left);
        } else if (node.value > value) {
            return containsRecursively(value, node.right);
        } else {
            return true;
        }
    }

    public void deleteRecursively(int value, TreeNode node) {
        if (node == null) {
            throw new NullPointerException();
        }

        if (node.value < value) {
            deleteRecursively(value, node.left);
        } else if (node.value > value) {
            deleteRecursively(value, node.right);
        } else {
            
        }

        throw new NullPointerException();
    }

    class TreeNode {
        TreeNode left;
        TreeNode right;
        int value;

        public TreeNode(int value) {
            this.value = value;
        }

        public void setLeft(TreeNode node) {
            this.left = node;
        }

        public void setRight(TreeNode node) {
            this.right = node;
        }
    }
}
