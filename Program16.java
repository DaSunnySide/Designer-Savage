//Take a binary search tree with minimal height using a sorted increasing array of integer elements.
//Start by finding hte middle of the array, and then creating a tree root at that value. Continue the left side of the tree from
//the start of the array to one before the middle, and the right of the tree from one after the middle to the end of the array.

TreeNode createMinimalBST(int array[]) {
  return createMinimalBST(array, 0, array.length-1);
}

TreeNode createMinimalBST(int arr[], int start, int end) {
  if (end < start) {
    return null;
  }
  
  int mid = (start + end)/2;
  TreeNode n = new TreeNode(arr[mid]);
  n.left = createMinimalBST(arr, start, mid-1);
  n.right = createMinimalBST(arr, mid+1, end);
  
  return n;
}
