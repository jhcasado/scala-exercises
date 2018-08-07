package lecture_2_10_scala_self_types

class Person(name: String) { def speak(feelings: String) = println(feelings) }

trait Angry { self: Person =>
  def growl() = self.speak("I'm having a bad day!!")
}

trait Happy { self: Person =>
  def laugh() = self.speak("Ja Ja Ja!!")
}

class SensiblePerson(name: String) extends Person(name) with Angry with Happy

object Exercise1SelfTypes extends App {
  val foo = new SensiblePerson("Foo")
  foo.speak("Oh boy")
  foo.growl
  foo.speak("But I'm optimistic")
  foo.laugh
}
