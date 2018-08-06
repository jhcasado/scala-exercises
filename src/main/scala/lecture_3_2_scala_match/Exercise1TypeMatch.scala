package lecture_3_2_scala_match

object Exercise1TypeMatch extends App {
  val arrayTypesTuples = Array("blah", 1, 1.0, 't') map { valueToMatch => valueToMatch match {
    case a: String => (a, s"$a=String")
    case b: Int => (b, s"$b=Integer")
    case c: Double => (c, s"$c=Double")
    case d => (d, s"$d=${valueToMatch.getClass.getName}")
  }}

  arrayTypesTuples foreach { arrayTypesTuple => println(arrayTypesTuple._2)}
}
