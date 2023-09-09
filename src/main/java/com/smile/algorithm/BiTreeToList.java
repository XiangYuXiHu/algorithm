package com.smile.algorithm;

/**
 * 二叉搜索树向链表转换
 *
 * @Description
 * @ClassName BiTreeToList
 * @Author smile
 * @date 2021.07.03 14:40
 */
public class BiTreeToList {

    private static TreeNode header = null;

    private static TreeNode pLastNode = null;

    public static TreeNode convert(TreeNode pTreeNode) {
        if (pTreeNode == null) {
            return null;
        }

        if (pTreeNode.left == null && pTreeNode.right == null) {
            return pTreeNode;
        }

        convertToList(pTreeNode);
        return header;
    }

    public static void convertToList(TreeNode pTreeNode) {

        if (pTreeNode.left != null) {
            convertToList(pTreeNode.left);
        }
        if (header == null) {
            header = pTreeNode;
            pLastNode = pTreeNode;
        } else {
            pLastNode.right = pTreeNode;
            pTreeNode.left = pLastNode;
            pLastNode = pTreeNode;
        }

        if (pTreeNode.right != null) {
            convertToList(pTreeNode.right);
        }
    }

}

