//Find the node that starts a loop in a circular linked list
//Begin by setting a slow and fast linked list node to the head of the list. Then move each forward and find the point where they meet.

LinkedListNode Findbeginning(LinkedListNode head) {
  LinkedListNode slow = head;
  LinkedListNode fast = head;
  
  while(fast != null && fast.next !=null) {
     slow = slow.next;
     fast = fast.next;
     if(slow == fast) { break; }
   }
   
  if (fast == null || fast.next == null) {
    return null;
  }
  
  slow = head;
  while (slow != fast) {
    slow = slow.next;
    fast = fast.next;
  }
  return fast;
}
