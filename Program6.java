//An algorithm to remove duplicates in an unsorted linked lists
//Start by taking in a linked list node parameter and make a hash set of integers. Iterate through the linked list, and if the element
//is the same as the parameter, remove the node.
void deleteDups(LinkedListNode n) {
  HashSet<Integer> set = new HashSet<Integer>();
  LinkedListNode previous = null;
  while(n!=null) {
    if(set.contains(n.data)) {
      previous.next = n.next;
    }
    else {
    set.add(n.data);
    previous = n;
  }
  n = n.next;
}
}
