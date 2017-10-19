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

  "FoldK" should "have some tests" in {
    Foldable[List].foldK(List(List(1, 2), List(3, 4, 5))) should be(List(1, 2, 3, 4, 5))
    Foldable[List].foldK(List(None, Option("two"), Option("three"))) should be(Some("two"))
  }

  "Find" should "have some tests" in {
    Foldable[List].find(List(1, 2, 3))(_ > 2) should be(Some(3))
    Foldable[List].find(List(1, 2, 3))(_ > 5) should be(None)
  }

  "Exists" should "exists checks whether at least one element satisfies the predicat" in {
    Foldable[List].exists(List(1, 2, 3))(_ > 2) should be(true)
    Foldable[List].exists(List(1, 2, 3))(_ > 5) should be(false)
  }

  "Forall" should "forall checks whether all elements satisfy the predicate" in {
    Foldable[List].forall(List(1, 2, 3))(_ <= 3) should be(true)
    Foldable[List].forall(List(1, 2, 3))(_ < 3) should be(false)
  }

  "To List" should "convert F[A] to List[A]" in {
    Foldable[List].toList(List(1, 2, 3)) should be(List(1, 2, 3))
    Foldable[Option].toList(Option(42)) should be(List(42))
    Foldable[Option].toList(None) should be(List())
  }

  "Filter" should "convert F[A] to List[A] only including the elements that match a predicate" in {
    Foldable[List].filter_(List(1, 2, 3))(_ < 3) should be(List(1, 2))
    Foldable[Option].filter_(Option(42))(_ != 42) should be(List())
  }

}
