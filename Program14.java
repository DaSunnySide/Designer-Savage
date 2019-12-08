//A stack that sorts the elements to move the smaller elements to the top. Iterates through a stack, using a temporary variable to 
//compare the values in the stack to the temp value. Drops the element where it belongs in the stack.

void sort(Stack<Integer> s) {
  Stack<Integer> r = new Stack<Integer>();
  
  while(!s.isEmpty()) {
    int tmp = s.pop();
    while(!r.isEmpty() && r.peek() > tmp) {
      s.push(r.pop());
    }
    r.push(tmp);
  }
  
  while(!r.isEmpty()) {
    s.push(r.pop());
  }
}
