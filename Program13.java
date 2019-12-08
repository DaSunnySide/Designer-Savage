//Make a queue out of two stacks
//Create one stack of newest items, one stack of oldest items, and a function to move older items from the new stack to the old stack.

public class MyQueue<T> {
  Stack<T> stackNewest, stackOldest;
  
  public MyQueue() {
    stackNewest = new Stack<T>();
    stackOldest = new Stack<T>();
  }
  
  public int size() {
    return stackNewest.size() + stackOldest.size();
  }
  
  public void add(T value) {
    stackNewest.push(value);
  }
  
  private void shiftStacks() {
    if(stackoldest.isEmpty()) {
      while (!stackNewest.isEmpty()) {
        stackOldest.push(stackNewest.pop());
      }
    }
  }
  
  public T peek() {
    shiftStacks();
    return StackOldest.peek();
  }
  public T remove() {
    shiftStacks();
    return stackOldest.pop();
  }
}
