package example

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.WordSpec
import org.scalatest.matchers.should.Matchers
import example.messages.MyValue
import example.test_messages.MyTestMessage

class HelloSpec extends WordSpec with Matchers {

  "The Hello object" must {
    "say hello" in {
      Hello.greeting shouldEqual MyValue("hello")
    }

    "MyTestMessage should wrap MyValue" in {
      MyTestMessage(Some(MyValue("hello"))).value.map(_.value) shouldBe Some("hello")
    }
  }

}
