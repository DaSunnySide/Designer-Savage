//Implementation of a basic merge sort algorithm
//Create a new array, and iterate through the arrays A and B, and compare the element at each location, adding them to the sorted array
//as it goes.

void merge(int[] a, int[] b, int lastA, int lastB) {
  int indexA = lastA -1;
  int indexB = lastB - 1;
  int indexMerged = lastB + lastA -1;
  
  while(indexB >=0) {
    if(indexA >=0 && a[indexA] > b[indexB]) {
    a[indexMerged] = a[indexA;
    indexA--;
    }
    else {
      a[indexMerged] = b[indexB];
      indexB--;
    }
    indexMerged--;
  }
}
