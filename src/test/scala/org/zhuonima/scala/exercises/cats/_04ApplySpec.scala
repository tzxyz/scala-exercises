package org.zhuonima.scala.exercises.cats

import cats.Apply
import org.scalatest._

class _04ApplySpec extends FlatSpec with Matchers {

  import cats.implicits._

  private val intToString: Int => String = _.toString
  private val double: Int => Int = _ * 2
  private val addTwo: Int => Int = _ + 2

  "Apply Map Spec" should "have some tests" in {
    Apply[Option].map(Some(1))(intToString) should be(Some("1"))
    Apply[Option].map(Some(1))(double) should be(Some(2))
    Apply[Option].map(None)(addTwo) should be(None)
  }

  "Apply Compose Spec" should "have some tests" in {
    val listOpt = Apply[List] compose Apply[Option]
    val plusOne = (x: Int) => x + 1
    listOpt.ap(List(Some(plusOne)))(List(Some(1), None, Some(3))) should be(List(Some(2), None, Some(4)))
  }

  "Apply Ap Spec" should "have some tests" in {
    Apply[Option].ap(Some(intToString))(Some(1)) should be(Some("1"))
    Apply[Option].ap(Some(double))(Some(1)) should be(Some(2))
    Apply[Option].ap(Some(double))(None) should be(None)
    Apply[Option].ap(None)(Some(1)) should be(None)
    Apply[Option].ap(None)(None) should be(None)
  }

}
