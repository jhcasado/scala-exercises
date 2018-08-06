package lecture_3_1_scala_option

object Exercise1EnvironmentVaribale extends App {
  println(s"Java version: ${Option(System.getProperty("java.version")).getOrElse("undefined")}")
  println(s"Java subversion: ${Option(System.getProperty("java.subversion")).getOrElse("undefined")}")
}
