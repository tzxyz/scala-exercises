package org.zhuonima.scala.exercises.cats

import org.scalatest._

class _07FoldableSpec extends FlatSpec with Matchers {

  import cats._
  import cats.implicits._

  "FoldLeft" should "have some tests" in {
    Foldable[List].foldLeft(List(1, 2, 3), 0)(_ + _) should be (6)
    Foldable[List].foldLeft(List("a", "b", "c"), "")(_ + _) should be("abc")
  }

  "FoldRight" should "have some tests" in {
    Foldable[List].foldRight(List(1, 2, 3), Now(0))((x, rest) => Later(x + rest.value)).value should be (6)
  }

  "Fold" should "have some tests" in {
    Foldable[List].fold(List("a", "b", "c")) should be("abc")
    Foldable[List].fold(List(1, 2, 3)) should be(6)
  }

  "FoldMap" should "have some tests" in {
    Foldable[List].foldMap(List("a", "b", "c"))(_.length) should be(3)
    Foldable[List].foldMap(List(1, 2, 3))(_.toString) should be("123")
  }

}
