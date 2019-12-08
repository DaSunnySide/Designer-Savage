//An algorithm that makes a linked list of all the elements in each level of a binary tree.
//Starts by checking of the tree has any contents. If it doesn't, the program ends.
//Then creates a list of tree nodes, which it populates with the contents of the tree. Adds a new list for each level of the tree.

void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
  if(root == null) return;
  
  LinkedList<TreeNode> list = null;
  if(lists.size() == level) {
    list = new LinkedList<TreeNode>();
    
    lists.add(list);
  }
  else {
    list = lists.get(level);
  }
  list.add(root);
  createLevelLinkedList(root.left, lists, level+1);
  createLevelLinkedList(root.right, lists, level+1);
}

ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
  ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
  createLevelLinkedList(root, lists, 0);
  return lists;
}
