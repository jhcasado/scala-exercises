package lecture_3_5_scala_try

object Exercise1Yoda extends App {
  import scala.util.{Try => _, Success => Do, Failure => DoNot}

  def divide(dividend: Int, divisor: Int): util.Try[Int] = {
    util.Try(dividend/divisor) match {
      case Do(v) =>
        println(s"Result of $dividend/$divisor is: $v")
        Do(v)
      case DoNot(e) =>
        println("You must have divided by zero or entered something that's not an Int.")
        println(e.getMessage)
        DoNot(e)
    }
  }

  println(s"4/2 = ${divide(4, 2)}")
  println(s"2/0 = ${divide(2, 0)}")
}
