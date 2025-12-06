error id: file://<WORKSPACE>/src/main/scala/Main.scala:`<none>`.
file://<WORKSPACE>/src/main/scala/Main.scala
empty definition using pc, found symbol in pc: `<none>`.
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -addition.
	 -addition#
	 -addition().
	 -scala/Predef.addition.
	 -scala/Predef.addition#
	 -scala/Predef.addition().
offset: 302
uri: file://<WORKSPACE>/src/main/scala/Main.scala
text:
```scala
@main def hello(): Unit =
  println("Hello world!")
  println(msg)
  dayone.main()
  print(dayone.zeroHit)

def msg = "I was compiled by Scala 3. :)"



object dayone{
  var dial = 50
  var zeroHit = 0

  def wrapAround(current: Int, total: Int, max: Int = 100): Int = {

    hits = total / max
    add@@ition = total % max
    val rawResult: Int = current + addition
    if (rawResult % max + max) % max == 0 then zeroHit += 1

  }

  def spinDial(spin: String): Unit = {
    val count = spin.substring(1).toInt
    
    // Update the dial position
    dial = spin.charAt(0) match {
      case 'L' => wrapAround(dial, -count)
      case 'R' => wrapAround(dial, count)
      case _ => 
        println("Invalid direction")
        dial
    }
  }
  
  def main(): Unit = {
    for (line <- readDocument.lines) {
      spinDial(line)
    }
  }

}


object readDocument{
  val lines = scala.io.Source.fromFile("input.txt").getLines.toList

}


```


#### Short summary: 

empty definition using pc, found symbol in pc: `<none>`.