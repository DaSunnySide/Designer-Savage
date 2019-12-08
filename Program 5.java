//Palindrome Permutation check
boolean permutationCheck(String phrase) {
  int[] table = buildCharFrequencyTable(phrase);
  return checkMaxOneOdd(table);
}

boolean checkMaxOneOdd(int[] table) {
  boolean foundodd = false;
  for (int count : table) {
    if (count % 2 ==1) {
      if(foundodd) {
        return false;
      }
      foundOdd = true;
}
return true;
}

int getCharNumber(Character c) {
  int a = Character.getNumericValue('a');
  int z = Character.getNumericValue('z');
  int val = Character.getNumericValue(c);
  if(a <= val && val <= z) {
    return val -a;
  }
  return -1;
}

int[] buildCharFrequencyTable(String phrase) {
  int[] table = new int[Character.getNumericValue('z')] - Character.getNumericValue('a') +1];
  for(char c: phrase.toCharArray()) {
    int x = getCharNumber(c);
    if(x!=-1) {
      table[x]++;
    }
  }
  return table;
  }
