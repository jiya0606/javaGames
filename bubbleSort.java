  public int[] smartBubblesort( int[] a) {
    int placeHolder = 0;
    for (int j = 0; j < (a.length-1); j++) {
      for (int i = 0; i < (a.length-1); i++) {
        if (a[i+1] < a[i]) {
          placeHolder = a[i];
          a[i] = a[i+1];
          a[i+1] = placeHolder;
        }
      }
    }
    return a;
  }