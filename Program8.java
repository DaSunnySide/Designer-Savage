//Delete the middle node in a linked list
//First, check if the node being deleted is the first or last element in the list, and return false if it is.
//Then change the node's value to be the next node's value, and the next value to be the node's next next value.
boolean(deleteNode(LinkedListNode n) {
  if(n == null || n.next == null) {
    return false;
  }
  LinkedListNode next = n.next;
  n.data = next.data;
  n.next = next.next;
  return true;
}
