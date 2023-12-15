package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryTreeVerticalOrderTraversal314 {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        if(root == null)
            return new ArrayList<>();
        dfs(root, 0, map);
        return map.keySet().stream().sorted()
                .collect(() -> new ArrayList<>(), (l1, n1) -> l1.add(map.get(n1)), (l1,l2) -> l1.addAll(l2));
    }

    private void dfs(TreeNode node, int col, Map<Integer, List<Integer>> map) {
        List<Integer> nodeValues = map.getOrDefault(col, new ArrayList<>());
        nodeValues.add(node.val);
        map.put(col, nodeValues);
        if(node.left != null)
            dfs(node.left, col - 1, map);
        if(node.right != null)
            dfs(node.right, col + 1, map);
    }
}
