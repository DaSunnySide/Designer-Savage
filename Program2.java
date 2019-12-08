//Check a string for all unique characters by creating an array of every possible character, and iterating through the string to see if it
//is already in the array. If it is in the array, return false. Otherwise return true.
boolean isUniqueChars(String str) {
  if(str.length() > 128) return false;
  
  boolean[] char_set = new boolean【128】；
  
  for（int i=0; i < strlength(); i++) {
    int val = str.charAt(i);
    if(char_set[val]) return false;
    char_set[val] = true;
  }
  return true;

}
