class Rational(n: Int, d: Int) {
  require(d != 0, "Denominator cannot be zero")
  
  private val g = gcd(n.abs, d.abs)
  
  val numer: Int = (if (d < 0) -n else n) / g
  val denom: Int = d.abs / g

  def this(n: Int) = this(n, 1)

  def neg: Rational = new Rational(-this.numer, this.denom)

  def sub(that: Rational): Rational = {
    val newNumerator = this.numer * that.denom - that.numer * this.denom
    val newDenominator = this.denom * that.denom
    new Rational(newNumerator, newDenominator)
  }

  override def toString: String = s"$numer/$denom"

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
}

@main def main(): Unit = {
  val x = new Rational(3, 4)
  val y = new Rational(5, 8)
  val z = new Rational(2, 7)

  println(x.sub(y).sub(z))
}
