class Rational(n: Int, d: Int) {
  require(d != 0)
  val numer: Int = n
  val denom: Int = d
  def this(n: Int) = this(n, 1)
  def neg = new Rational(-this.numer, this.denom)
  override def toString: String = s"$numer/$denom"
}

@main def testRational() = {
  val x = new Rational(1, 3)
  println(x.neg)
}