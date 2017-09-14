package org.zhuonima.scala.exercises

import org.scalatest._

class HelloSpec extends FlatSpec with Matchers {
  "Hello" should "have tests" in {
    true should === (true)
  }
}
