package lecture_4_2_scala_recursion

import scala.annotation.tailrec
import scala.collection.mutable
import scala.util.{Failure, Success}
import scala.util.Try

object Exercise1Factorial extends App {
  object Time {
    def timeAndValue(n: Int, fn: Int => Any): (Long, Any) = {
      val s = System.currentTimeMillis
      val result = fn(n)
      (System.currentTimeMillis - s, result)
    }

    def printTiming(n: Int, fn: Int => Any, msg: String): Unit = {
      val result = timeAndValue(n, fn)
      println(f"[It took: ${result._1}%5d ms to run] " + f"$msg $n%6d is: ${result._2}")
    }

    def time(f: => Unit): Long = {
      val s = System.currentTimeMillis
      f
      System.currentTimeMillis - s
    }

    // Added -1 to test error handling
    def factTest(fn: Int => Any, values: List[Int] = List(-1, 10, 42, 50, 100, 500, 1000, 1000, 5000, 5000)): Unit =
      values.foreach(n => printTiming(n, fn, "Factorial of: "))
  }

  // Mutable variable fact with a first mock-up factorial function implementation
  type factFnType = Int => BigInt
  var fact: factFnType = _

  // Closure with Try wrapping the fact function variable
  var factTry: Int => Try[BigInt] = n => Try(fact(n))

  // Exception handler using the closure
  def tryHandler(n: Int): BigInt = factTry(n) match {
    case Success(result) => result
    case Failure(e) => println(s"Factorial of $n is undefined due to '${e.getMessage}'"); 0
  }


  // 1. A simple recursive function that mimics the mathematical definition
  println("1. A simple recursive function that mimics the mathematical definition")
  def factMath(n: Int): BigInt = n match {
    case 0L         => 1L
    case _ if n > 0 => factMath(n - 1) * n
    case _          => require(n >= 0); 0L
  }
  fact = factMath
  Time.factTest(tryHandler)


  println
  println


  // 2. A tail-recursive version
  println("2. A tail-recursive version")
  def factTail(n: Int): BigInt = {
    @tailrec
    def factIter(count: Int, factN1: BigInt): BigInt =
      if (count == n) factN1
      else factIter(count + 1, factN1 * (count + 1))

    require(n >= 0)
    factIter(0, 1L)
  }
  fact = factTail
  Time.factTest(tryHandler)


  println
  println


  // 3. A memoized tail-recursive version
  println("3. A memoized tail-recursive version")
  val cache: mutable.Map[Int, BigInt] = mutable.HashMap(0 -> BigInt(1))
  def factTailWithCache(n: Int): BigInt = {
    @tailrec
    def factIter(count: Int, factN1: BigInt): BigInt =
      if (count == n) {
        cache += n -> factN1
        factN1
      }
      else factIter(count + 1, factN1 * (count + 1))

    require(n >= 0)
    factIter(0, 1L)
  }
  def factMemo(n: Int): BigInt = cache.getOrElse(n, factTailWithCache(n))
  fact = factMemo
  Time.factTest(tryHandler)
}
