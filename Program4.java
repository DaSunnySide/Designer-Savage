//Check if one string is a permutation of another string. Create a method to sort a string. Then check if the sorted version of two strings
//are identical.

String sort(String s) {
  char[] content = s.toCharArray();
  java.util.Arrays.sort(content);
  return new String(content);
  }
  
  boolean permutation(String s, String t) {
    if(s.length() != t.length()) { return false; }
    return sort(s).equals(sort(t));
  }
