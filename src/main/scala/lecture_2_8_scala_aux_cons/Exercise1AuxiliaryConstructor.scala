package lecture_2_8_scala_aux_cons

import lecture_2_2_scala_classes.Bird

class Bird3(canFly: Boolean, topSpeed: Double) extends Bird(canFly, topSpeed) {
  def this(topSpeed: Double) {
    this(true, {
      val min = new java.text.SimpleDateFormat("mm").format(new java.util.Date).toInt
      if (min % 2 == 0) topSpeed * 1.1 else topSpeed
    }: Double)
  }
}

object Bird3 {
  def apply(canFly: Boolean, topSpeed: Double): Bird3 = new Bird3(canFly, topSpeed)
  def apply(topSpeed: Double): Bird3 = new Bird3(topSpeed)
}

object Exercise1AuxiliaryConstructor extends App {
  val x = new Bird3(2.0)
  println(x.msg2)

  var y = Bird3(5.0)
  println(y.msg2)
}
