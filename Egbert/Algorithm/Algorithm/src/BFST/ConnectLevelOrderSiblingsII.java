package BFST;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @leetcode https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 * @author Egbert Li
 * @date 8/7/2019
 * @Time O N
 * @Space O 1
 */
public class ConnectLevelOrderSiblingsII {
    // Solution 1: O N, O 1 Space
    public static void connect(TreeNode root) {
        TreeNode dummyHead = new TreeNode(-1);
        TreeNode current = null;
        while (root != null) {
            current = dummyHead;
            while (root != null) {
                if (root.left != null) {
                    current.next = root.left;
                    current = current.next;
                }
                if (root.right != null) {
                    current.next = root.right;
                    current = current.next;
                }
                root = root.next;
            }
            root = dummyHead.next;
            dummyHead.next = null;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        ConnectLevelOrderSiblings.connect(root);
        System.out.println("Level order traversal using 'next' pointer: ");
        root.printLevelOrder();
    }
}
