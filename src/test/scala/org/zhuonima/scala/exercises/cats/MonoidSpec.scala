package org.zhuonima.scala.exercises.cats

import org.scalatest._

class MonoidSpec extends FlatSpec with Matchers {

  import cats._
  import cats.implicits._

  "Monoid" should "have tests " in {

    Monoid[String].empty should be ("")

    Monoid[String].combineAll(Seq("a", "b", "c")) should be ("abc")

    Monoid[String].combineAll(Seq.empty) should be ("")

    Monoid[Map[String, Int]].combineAll(List(Map("a" -> 1, "b" -> 2), Map("a" -> 3))) should be (Map("a" -> 4, "b" -> 2))

    Monoid[Map[String, Int]].combineAll(List.empty) should be (Map.empty)

    List(1, 2, 3, 4, 5).foldMap(identity) should be (15)

    List(1, 2, 3, 4, 5).foldMap(_.toString) should be ("12345")

//    implicit def monoidTuple[A: Monoid, B: Monoid]: Monoid[(A, B)] = {
//      new Monoid[(A, B)] {
//        override def empty = (Monoid[A].empty, Monoid[B].empty)
//
//        override def combine(x: (A, B), y: (A, B)) = {
//          val (xa, xb) = x
//          val (ya, yb) = y
//          (Monoid[A].combine(xa, ya), Monoid[B].combine(xb, yb))
//        }
//      }
//    }

    List(1, 2, 3, 4, 5).foldMap(i => (i, i.toString)) should be ((15, "12345"))


  }

}
