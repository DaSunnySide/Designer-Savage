//Find the first common ancestor of two nodes in a binary tree
//Starts by finding the difference in depth of the two nodes, and then moves up in the tree until the program reaches a shared ancestor node.

TreeNode commonAncestor(TreeNode p, TreeNode q) {
  int delta = depth(p) - depth(q);
  TreeNode first = delta > 0 ? q : p;
  TreeNode second = delta > 0 ? p; q;
  second = goUpBy(second, Math.abs(delta));
  
  while (first != second &&  first != null && second != null) {
    first = first.parent;
    second = second.parent;
  }
  return first == null || second == null ? null: first;
}

TreeNode goUpBy(TreeNode node, int delta) {
  while (delta > 0 && node != null) {
    node = node.parent;
    delta--;
  }
  return node;
}

int depth(TreeNode node) {
  int depth = 0;
  while (node != null) {
    node = node.parent;
    depth++;
  }
  
  return depth;
}
