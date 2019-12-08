// Find the next node in a binary search tree
//If a tree is null, the program stops running. If it is not null, it finds the left most child of that node (the sucessor). 
Node inorderSucc(TreeNode n) {
  if (n == null) {
    return null;
  }
  
  if (n.right != null) {
    return leftMostChild(n.right);
  }
  
  else {
    TreeNode q = n;
    TreeNode x = q.parent;
    while (x != null && x.left != q) {
      q =x;
      x = x.parent;
    }
    return x;
  }
}

TreeNode leftMostchild(TreeNode n) {
  if (n == null) {
    return null;
  }
  
  while (n.left != null) {
    n = n.left;
  }
  return n;
}
