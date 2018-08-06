package lecture_3_3_scala_unapply

object Exercise2Frog8 extends App {
  class Frog8(val canSwim: Boolean, val numLegs: Int, val breathesAir: Boolean) {
    override def toString = s"canSwim: $canSwim; $numLegs legs; breathesAir: $breathesAir"
  }

  object Frog8 {
    def unapply(string: String): Option[(Boolean, Int, Boolean)] = {
      val params = string.split(" ")
      if (params.length == 3)
        Some((params(0).toBoolean, params(1).toInt, params(2).toBoolean))
      else
        None
    }
  }

  val Frog8(canSwim, numLegs, breathesAir) = "true 4 false"

  println(s"canSwim: $canSwim   numLegs: $numLegs   breathesAir: $breathesAir")
}
