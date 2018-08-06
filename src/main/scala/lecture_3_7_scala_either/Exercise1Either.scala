package lecture_3_7_scala_either

// object WordSearch extends App
object Exercise1Either extends App {
  type StringOrInt = Either[String, Int]

  def search(list: List[String], word: String): StringOrInt = {
    val pos = list.indexOf(word)
    if (pos < 0)
      Left(word)
    else
      Right(pos)
  }

  val list = List("nope", "word", "nothing", "another")
  List("word", "oink", "blahbla", "another").foreach { w =>
    println(s"$w: ${search(list, w)}")
  }
}
