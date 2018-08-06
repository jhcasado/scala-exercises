package lecture_3_3_scala_unapply

// object Extractor extends App
object Exercise3Frog9 extends App {
  object Frog9 {
    def unapply(input: Array[String]): Option[(Boolean, Int, Boolean)] = {
      if (input.size == 3)
        Some((input(0).toBoolean, input(1).toInt, input(2).toBoolean))
      else
        None
    }
  }

  case class Frog9(canSwim: Boolean, numLegs: Int, breathesAir: Boolean)

//  val Frog9(swimmer3, legCount3, airBreather3) = Array("true", "4", "true")
//  println(s"swimmer3: $swimmer3, legCount3: $legCount3, airBreather3: $airBreather3")
//  val Frog9(swimmer4, legCount4, airBreather4) = Array("true", "0", "false")
//  println(s"swimmer4: $swimmer4, legCount4: $legCount4, airBreather4: $airBreather4")


  // sbt ~"runMain lecture_3_3_scala_unapply.Exercise3Frog9 true 4 true"
  val Frog9(swimmer, legCount, airBreather) = args
  println(s"swimmer = $swimmer")
  println(s"legCount = $legCount")
  println(s"airBreather = $airBreather")
}
