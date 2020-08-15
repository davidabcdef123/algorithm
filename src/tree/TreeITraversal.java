package tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeITraversal {

    /**
     * @param:
     * @return:
     * @Description: 构建树
     * @date 2020/8/13 21:38
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }
        Integer data = inputList.removeFirst();
        //这里的判空很关键。如果元素是空，说明该节点不存在，跳出这一层递归；如果元素非空，继续递归构建该节点的左右孩子。
        if (data != null) {
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }
        return node;
    }

    /**
     * @param:
     * @return:
     * @Description: 前序遍历
     * @date 2020/8/13 21:38
     */
    public static void preOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.println(treeNode.data);
        preOrder(treeNode.leftChild);
        preOrder(treeNode.rightChild);
    }

    /**
     * @param:
     * @return:
     * @Description: 中序遍历
     * @date 2020/8/13 21:51
     */
    public static void middleOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        middleOrder(treeNode.leftChild);
        System.out.println(treeNode.data);
        middleOrder(treeNode.rightChild);
    }

    private static class TreeNode {
        int data;
        TreeNode leftChild;
        TreeNode rightChild;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    /**
     * @param:
     * @return:
     * @Description: 后序遍历
     * @date 2020/8/13 21:59
     */
    public static void afterOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        afterOrder(treeNode.leftChild);
        afterOrder(treeNode.rightChild);
        System.out.println(treeNode.data);
    }

    /**
     * @param:
     * @return:
     * @Description: 二叉树分递归前序遍历
     * @date 2020/8/15 13:49
     */
    public static void preOrderTraveralWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            //迭代访问节点的左孩子，并入栈
            while (treeNode != null) {
                System.out.println(treeNode.data);
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            //如果节点没有左孩子，则弹出栈顶节点，访问节点右孩子
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.rightChild;

            }
        }
    }

    /**
     * @param:
     * @return:
     * @Description: 层序遍历
     * @date 2020/8/15 15:13
     */
    public static void levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        //新增
        queue.offer(root);
        while (!queue.isEmpty()) {
            //获取头部节点
            TreeNode node = queue.poll();
            System.out.println(node.data);
            if (node.leftChild != null) {
                queue.offer(node.leftChild);
            }
            if (node.rightChild != null) {
                queue.offer(node.rightChild);
            }
        }


    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<Integer>(Arrays.asList(new Integer[]{3, 2, 9, null, null, 10, null, null, 8, null, 1,}));
        TreeNode treeNode = createBinaryTree(inputList);
        /*System.out.println("前序遍历：");
        preOrder(treeNode);*/
        /*System.out.println("中序遍历：");
        middleOrder(treeNode);*/
        /*System.out.println("后序遍历");
        afterOrder(treeNode);*/
        /*System.out.println("非递归前序遍历");
        preOrderTraveralWithStack(treeNode);*/
        System.out.println("层序遍历");
        levelOrderTraversal(treeNode);
    }
}
