package example

import example.messages.MyValue

object Hello extends Greeting with App {
  println(greeting)
}

trait Greeting {
  lazy val greeting: MyValue = MyValue("hello")
}
