package lecture_2_2_scala_classes

import animals.Animal

class Bird(canFly: Boolean, topSpeed: Double) extends Animal(2, true) {
  private val flyMsg = if (canFly) "" else " not"
  val msg2 = s"$msg, I am also a bird that can$flyMsg fly with an speed of $topSpeed"
}

object Exercise1SubclassingAnimal extends App {
  val x = new Bird(true, 2.0)
  println(x.msg2)

  var y = new Bird(false, 5.0)
  println(y.msg2)
}
