package fi.twat

import org.scalatest.{FlatSpec, Matchers}

import scala.collection.mutable

/**
  * Created by tgdkepi1 on 22/04/16.
  */
class SimpleParserSpec extends FlatSpec with Matchers {

  val parser = new SimpleParser()

  "A stack" should "pop values in first in first out order" in {
    val stack = new mutable.Stack[Int]
    stack.push(1);
    stack.push(2);
    stack.pop() should be (2)
    stack.pop() should be (1)
  }

  "parser" should "work with basic tweet" in {
    //val tweet = """{ "id": 1, "text": "foo" }"""
    val tweet = """{"id":1,"text":"foo"}"""
    parser.parse(tweet) match {
      case Some(parsed) => {
        println(parsed.text)
        parsed.text should be ("foo")
        parsed.id should be (1)
      }
      case _ => {
        fail("didnt parse")
      }
    }
  }
}
