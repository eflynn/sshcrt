package sshcrt2;

import java.util.Arrays;

public class Polynomial implements Comparable<Polynomial>, DerivableFunction {
  public static final Polynomial ZERO = new Polynomial();

  private final double[] coeffs;

  public Polynomial(double... coeffs) {
    this.coeffs = stripLeadingZeros(coeffs);
  }

  /**
   * Returns the degree of this polynomial.
   * @return the degree of this polynomial, -1 for the zero polynomial.
   */
  public int getDegree() {
    return coeffs.length - 1;
  }

  /**
   * Returns the sum of this polynomial and the specified polynomial.
   *
   * @param  poly the other polynomial
   * @return the polynomial whose value is {@code (this(x) + poly(x))}
   */
  public Polynomial add(Polynomial poly) {
    throw new AssertionError("not implemented");
  }

  /**
   * Returns the result of subtracting the specified polynomial
   * from this polynomial.
   *
   * @param  poly the other polynomial
   * @return the polynomial whose value is {@code (this(x) - that(x))}
   */
  public Polynomial minus(Polynomial poly) {
    throw new AssertionError("not implemented");
  }

  /**
   * Returns the product of this polynomial and the specified polynomial.
   * Takes time proportional to the product of the degrees.
   * (Faster algorithms are known, e.g., via FFT.)
   *
   * @param  poly the other polynomial
   * @return the polynomial whose value is {@code (this(x) * that(x))}
   */
  public Polynomial multiply(Polynomial poly) {
    throw new AssertionError("not implemented");
  }

  /**
   * Compares this polynomial to the specified polynomial.
   *
   * @param  o the other polynoimal
   * @return {@code true} if this polynomial equals {@code other};
   *         {@code false} otherwise
   */
  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Polynomial))
      return false;

    Polynomial poly = (Polynomial) o;

    return Arrays.equals(poly.coeffs, coeffs);
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(coeffs);
  }

  /**
   * Returns the result of differentiating this polynomial.
   *
   * @return the polynomial whose value is {@code this'(x)}
   */
  @Override
  public DerivableFunction differentiate() {
    throw new AssertionError("not implemented");
  }

  /**
   * Compares two polynomials by degree, breaking ties by coefficient of leading term.
   *
   * @param  poly the other polynomial
   * @return the value {@code 0} if this polynomial is equal to the argument
   *         polynomial (precisely when {@code equals()} returns {@code true});
   *         a negative integer if this polynomialt is less than the argument
   *         polynomial; and a positive integer if this polynomial is greater than the
   *         argument point
   */
  @Override
  public int compareTo(Polynomial poly) {
    return Arrays.compare(coeffs, poly.coeffs);
  }

  /**
   * Return a string representation of this polynomial.
   * @return a string representation of this polynomial in the format
   *         4x^5 - 3x^2 + 11x + 5
   */
  @Override
  public String toString() {
    return Arrays.toString(coeffs);
  }

  /**
   * Returns the result of evaluating this polynomial at the point x.
   *
   * @param  x the point at which to evaluate the polynomial
   * @return the integer whose value is {@code (this(x))}
   */
  public double value(double x) {
    double p = 0.0;

    for (double coef : coeffs) {
      p = x * p + coef;
      System.out.println("p = " + p);
    }

    return p;
  }

  public static Polynomial valueOf(double constant) {
    if (constant == 0.0) {
      return ZERO;
    }

    return new Polynomial(constant);
  }

  private static double[] stripLeadingZeros(double[] coeffs) {
    int len = coeffs.length;
    int keep;

    for (keep = 0; keep < len && coeffs[keep] == 0; keep++)
      ;

    double[] result = new double[len - keep];

    System.arraycopy(coeffs, keep, result, 0, len - keep);
    return result;
  }
}
