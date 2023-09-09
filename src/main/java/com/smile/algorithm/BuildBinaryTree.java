package com.smile.algorithm;

/**
 * 根据前序和中序构建二叉树
 *
 * @Description
 * @ClassName BuildBinaryTree
 * @Author smile
 * @date 2021.05.30 17:52
 */
public class BuildBinaryTree {

    /***
     * 构建二叉树
     * @param pre
     * @param preStart
     * @param preEnd
     * @param in
     * @param inStart
     * @param inEnd
     * @return
     */
    public static TreeNode buildBinaryTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if (null == pre && null == in) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        if (preStart == preEnd && pre[preStart] == in[inStart]) {
            return root;
        }
        int i = inStart;
        for (; i <= inEnd; i++) {
            if (pre[preStart] == in[i]) {
                break;
            }
        }
        int leftLen = i - inStart;
        if (leftLen > 0) {
            root.left = buildBinaryTree(pre, preStart + 1, preStart + leftLen, in, inStart, i - 1);
        }
        if (leftLen < inEnd - i) {
            root.right = buildBinaryTree(pre, preStart + leftLen + 1, preEnd, in, i + 1, inEnd);
        }
        return root;
    }

    public static void main(String[] args) {
        int[] pre = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode result = buildBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        System.out.println(result);

        TreeNode convert = BiTreeToList.convert(result);
        TreeNode temp = convert;
        while (temp != null) {
            System.out.println(temp.getValue());
            temp = temp.right;
        }
    }
}

class TreeNode {
    private Integer value;
    protected TreeNode left;
    protected TreeNode right;

    public TreeNode(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}


