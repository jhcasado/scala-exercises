package lecture_4_1_scala_unit

import org.junit.runner.RunWith
import org.specs2.mutable._
import org.specs2.runner.JUnitRunner

// sbt ~"testOnly lecture_4_1_scala_unit.TestExercise1Specs2"
@RunWith(classOf[JUnitRunner])
class TestExercise1Specs2 extends Specification {
  "ScalaCoursesWebsite" should {
    val scalaCoursesWebsite = io.Source.fromURL("http://scalacourses.com").getLines.mkString.toLowerCase;

    "contain 'scala'" in {
      scalaCoursesWebsite must contain("scala")
    }
  }
}
