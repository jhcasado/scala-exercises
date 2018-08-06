package lecture_3_6_scala_functions

// object FunSel extends App
object Exercise1Functions extends App {
  type StringOp = (String, Int) => String

  def blackBox(f: StringOp, string: String, n: Int): String = f(string, n)

  val fn1: StringOp = _ substring _    // infix syntax
  //val fn1: StringOp = _.substring(_) // postfix syntax
  val fn2: StringOp = _ * _

  println("fn1(string, pos) or blackBox(fn1, string, pos) will return the rest of the string from the position pos")
  println("fn2(string, n) or blackBox(fn2, string, n) will return an string with the original string repeated n times")
  println

  println(s"""fn1 supplied with "good/bad dog" and 5 gives: ${fn1("bad/good dog", 4)}""")
  println(s"""fn2 supplied with "arf " and 3 gives: ${fn2("arf ", 3)}""")

  println(s"""blackBox(fn1, "string", 3) = ${blackBox(fn1, "string", 3)}""")
  println(s"""blackBox(fn1, "string", 3) = ${blackBox(fn2, "string", 3)}""")
}
