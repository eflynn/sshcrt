package sshcrt2;

import java.util.List;

public class Main {
  public static void main(String[] args) {
    Function f1 = new Polynomial(4.0, 1.0);
    Function f2 = new Polynomial(4.0, 3.0);
    Function f3 = new Polynomial(1.0, 0.0, 1.0);
    Function f4 = Polynomial.ZERO;
    double x = 4.5;

    for (Function f : List.of(f1, f2, f3, f4)) {
      System.out.println("f = " + f);
      System.out.println("f(" + x + ") = " + f.value(x));
    }
  }
}
