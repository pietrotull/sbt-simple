package com.foo

import org.scalatest.{FlatSpec, Matchers}

class FoobarSpec extends FlatSpec with Matchers {

  val fooBar = new Foobar()

  "foobar" should "return string" in {
    val test: String = "some string"
    val result = fooBar.some(test)
    result should be (test)
  }
}
