package fi.twat

case class SimpleParsed(id: Long, text: String)
/**
  * Created by tgdkepi1 on 22/04/16.
  */
class SimpleParser {
  val tweetRegex = "\"id\":(.*),\"text\":\"(.*)\"".r

  def parse(str: String) = {
    println(s"parsing $str")
    tweetRegex.findFirstMatchIn(str) match {
      case Some(m) => {
        val id = str.substring(m.start(1), m.end(1)).toInt
        val text = str.substring(m.start(2), m.end(2))
        Some(SimpleParsed(id, text))
      }
      case _ => None
    }
  }
}
