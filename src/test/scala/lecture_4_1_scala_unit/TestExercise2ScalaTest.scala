package lecture_4_1_scala_unit

import org.junit.runner.RunWith
import org.scalatest.Matchers._
import org.scalatest._
import org.scalatest.junit.JUnitRunner

// sbt ~"testOnly lecture_4_1_scala_unit.TestExercise2ScalaTest"
@RunWith(classOf[JUnitRunner])
class TestExercise2ScalaTest extends WordSpec {
  "ScalaCoursesWebsite" should {
    val scalaCoursesWebsite = io.Source.fromURL("http://scalacourses.com").getLines.mkString.toLowerCase;

    "contain 'scala'" in {
      scalaCoursesWebsite should include("scala")
    }
  }
}
