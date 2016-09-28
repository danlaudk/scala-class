package com.datascience.education.tutorialAnswer.lecture1


// Task (5a): decide where the implicit conversion should go; implement it

object ImplicitConversions {

  type ComplexNumber = (Double, Double)

  trait ComplexVector {
    def complexVector: List[ComplexNumber]
    override def toString = s"Vector contains $complexVector"
  }


  object ComplexVectors {
    def dense(firstValue: ComplexNumber, otherValues: ComplexNumber*): ComplexVector =
      new ComplexVector {
        val complexVector = firstValue :: otherValues.toList
      }
  }


  val denseInts = ComplexVectors.dense(4, 2, 6, 9)

  // Answer (5a)
  implicit def int2Complex(i: Int): ComplexNumber = (i.toDouble, 0.0)


}

object ImplicitConversionsExample extends App {
  import ImplicitConversions._

  println("Dense Ints")
  println(denseInts)

}



