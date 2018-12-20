package com.elearning.chapter7.interviewquestion50;

import java.util.ArrayList;
import java.util.List;

/**
 * 树节点
 * @author yangkuan
 */
public class TreeNode {
    int val = 0;
    List<TreeNode> children = null;
    public TreeNode(int val) {
        this.val = val;
        children = new ArrayList<>();
    }
}
