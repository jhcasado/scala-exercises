package lecture_3_3_scala_unapply

object Exercise1Name extends App {
  class Name(val first: String, val last: String)

  object Name {
    def unapply(input:String) = {
      val name = input.split(" ")
      if (name.length == 2)
        Some((name(0), name(1)))
      else
        None
    }
  }

  val Name(firstName, lastName) = "Fred Flintstone"

  println(s"First: $firstName   Last: $lastName")
}
