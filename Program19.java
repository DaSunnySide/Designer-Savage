//An algorithm that checks if a binary tree is a binary search tree

int index = 0;
void copyBST(TreeNode root, int[] array) {
  if(root == null) return;
  copyBST(root.left, array) {
    for(int i = 1; i <array.length; i++) {
      if (array[i] <= array[i-1]) return false;
      }
    return true;
  }
