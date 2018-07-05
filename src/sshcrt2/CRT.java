package sshcrt2;

public class CRT {
  public static int crt(int[] n, int[] a) {
    int product = 1;

    for (int n_i : n) {
      product *= n_i;
    }

    int p, sm = 0;

    for (int i = 0; i < n.length; i++) {
      p = product / n[i];
      sm += a[i] * mulInv(p, n[i]) * p;
    }
    return sm % product;
  }

  private static int mulInv(int a, int b) {
    int b0 = b;
    int x0 = 0;
    int x1 = 1;

    if (b == 1)
      return 1;

    while (a > 1) {
      int q = a / b;
      int amb = a % b;
      a = b;
      b = amb;
      int xqx = x1 - q * x0;
      x1 = x0;
      x0 = xqx;
    }

    if (x1 < 0)
      x1 += b0;

    return x1;
  }

}
