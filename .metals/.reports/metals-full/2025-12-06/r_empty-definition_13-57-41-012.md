error id: file://<WORKSPACE>/src/main/scala/Main.scala:java/lang/String#charAt().
file://<WORKSPACE>/src/main/scala/Main.scala
empty definition using pc, found symbol in pc: java/lang/String#charAt().
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -charAt.
	 -charAt#
	 -charAt().
	 -scala/Predef.charAt.
	 -scala/Predef.charAt#
	 -scala/Predef.charAt().
offset: 384
uri: file://<WORKSPACE>/src/main/scala/Main.scala
text:
```scala
@main def hello(): Unit =
  println("Hello world!")
  println(msg)

def msg = "I was compiled by Scala 3. :)";


object dayone{
  val dial = 50;
  val zeroHit = 0;

  def wrapAround(current: Int, addition: Int, max: Int = 100): Int = {
    val rawResult: Int = current + addition
    (rawResult % max + max) % max
  }

  def spin(spin: String): Unit = {
    g match {
      case spin.@@charAt(0).: 
    }
    val direction = String(spin.charAt(0))
    val count = Int(spin.substring(1))

    if (direction == "L") {
      wrapAround(dial, -count)
    }
    if (direction == "R") {
      wrapAround(dial, count)
    }
    if (dial == 0) {
      zeroHit++
    }
  }
  
  def main(): Unit = {
    for (line <- readDocument.lines) {
      for (spin <- line) {
        spin(spin)
      }
    }
  }

}


object readDocument{
  val lines = scala.io.Source.fromFile("input.txt").getLines.toList

}


```


#### Short summary: 

empty definition using pc, found symbol in pc: java/lang/String#charAt().