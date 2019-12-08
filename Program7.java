//Print the k to last element in a linked list. Uses a counter that decrements working from the back end of the list and prints out the
//element at once the counter is 0.
int printKthToLast(LinkedListNode head, int k) {
  if (head == null) {
    return 0;
  }
  int index = printKthTolast(head.next, k) +1;
  if(index == k) {
    System.out.println(k + "th to last node is " + head.data);
  }
  return index;
  }
