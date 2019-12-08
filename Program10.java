//Check to see if two linked lists intersect
//This algorithm starts at the end of the list, and checks if the values are identical. If they are not identical, the two lists don't 
//intersect. If they are identical, it works backwards, and returns the last value where they are identical (ie the intersection point)

LinkedListNode findIntersection(LinkedListNode list1, LinkedListNode node2) {
  if(list1 == null || list2 == null) return null;
  
  Result result1 = getTailAndSize(list1);
  Result result2 = getTailAndSize(list2);
  
  if (result1.tail != result2.tail) {
    return null;
  }
  
  LinkedListNode shorter = result1.size < result2.size ? list1: list2;
  LinekdListNode longer = result1.size < result2.size ? list2: list1;
  
  longer = getKthnode(longer, Math.abs(result1.size - result2.size));
  while(shorter != longer) {
    shorter = shorter.next;
    longer = longer.next;
  }
  
  return longer;
  
  Class Result {
    public linkedListNode tail;
    public int size;
    public Result(LinkedListNode tail, int size) {
      this.tail = tail;
      this.size = size;
    }
  }
  
  Result getTailAndSize(LinkedListNode list) {
    if (list == null) return null;
    
    int size = 1;
    LinkedListNode current = list;
    while(current.next != null) {
      size++;
      current = current.next;
    }
    return new Result(current, size);
  }
  
  LinkedListNode getkthNode(LinkedListNode head, int k) {
    LinkedListNode current = head;
    while(k>0 && current != null) {
      current = current.next;
      k--;
    }
    reutnr current;
  }
