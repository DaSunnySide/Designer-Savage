//In a binary search tree, find the number of paths that lead to a given sum.
//Recursively check current sum value at each node, and then check each sucessor node to see if it offers a chance at reaching the given sum.

int countPathsWithSum(TreeNode root, int targetSum) {
  return countPathsWithSum(root, targetSum, 0, new HasMap<Integer, Integer>());
}

int countPathsWithSum(TreeNode node, int targetSum, int runningSum, HashMap<Integer, Integer> pathCount) {
  if (node == null) return 0;
  
  runningSum += node.data;
  int sum = runningSum - targetSum;
  int totalPaths = pathCount.getOrDefault(sum, 0);
  
  if(runningSum == targetSum) {
    totalPaths++;
  }
  
  incrementHashTable(pathCount, runningSum, 1);
  totalPaths += countPathsWithSum(node.left, targetSum, runningSum, pathCount);
  totalPaths += countPathsWithSum(node.right, targetSum, runningSum, pathCount);
  incrementHashTable(pathCount, runningSum, -1);
  
  return TotalPaths;
}

void incrementHashTable(HashMap<Integer, Integer> hashTable, int key, int delta) {
  int newCount = hashTable.getOrDefault(key, 0) + delta;
  if (newCount == 0) {
    hashTable.remove(key);
  }
  else {
    hashTable.put(key, newCount);
  }
}
