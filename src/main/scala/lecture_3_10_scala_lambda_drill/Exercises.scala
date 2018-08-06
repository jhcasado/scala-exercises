package lecture_3_10_scala_lambda_drill

object Exercises extends App {
  // DRILL 1
  // Which of these define the same Function1?
  val fn = (x: Int) => x * 2                // 1
  val fn: Int => Int = _ * 2                // 2
  val fn: Function1[Int, Int] = x => x * 2  // 3
  val fn = (_:Int) * 2                      // 4

  // Answer: All


  // DRILL 2
  // What is the equivalent long-form type declaration for this lambda?
  (i: Int, str: String) => str * i
  // 1. Function1[Int, String, String]
  // 2. Function2[Int, String, String]
  // 3. Int => String
  // 4. (Int, String) => String

  // Answer: 2


  // DRILL 3
  // What is the equivalent long-form type declaration for this lambda?
  (_: String) * (_: Int)
  // 1. Function1[String, Int, String]
  // 2. Function2[String, Int, String]
  // 3. String => Int
  // 4. (String, Int) => String

  // Answer: 2


  // DRILL 4
  // Which of these define the same Function2?
  val fn = (str: String, i: Int) => str * i                 // 1
  val fn: (String, Int) => String = _ * _                   // 2
  val fn: Function2[String, Int, String] = (x, y) => x * y  // 3
  val fn = (_: String) * (_:Int)                            // 4

  // Answer: All


  // DRILL 5
  // Which are shorthand equivalents for the following long form FunctionN type?
  Function3[String, Int, Int, Boolean]
  // 1. (String) => (Int) => (Int) => (Boolean)
  // 2. (String, Int, Int, Boolean)
  // 3. (String, Int, Int) => Boolean
  // 4. (String) => Boolean

  // Answer: 3


  // SPARK
  // The Spark documentation shows this method signature:
  def subgraph(
                epred: EdgeTriplet[VD,ED] => Boolean = (x => true),
                vpred: (VertexId, VD) => Boolean = ((v, d) => true))
  : Graph[VD, ED]
  // 1. Explain the type of epred.
  // It is a function1 that takes a parameter of type EdgeTriplet[VD, ED], and returns a Boolean

  // 2. Where does x come from?
  // The x is the first and only defined parameter of type EdgeTriplet as was declared

  // 3. What does (x => true) do?
  // It always returns true
}
