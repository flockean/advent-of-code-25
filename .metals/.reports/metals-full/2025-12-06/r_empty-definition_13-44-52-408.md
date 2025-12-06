error id: file://<WORKSPACE>/src/main/scala/Main.scala:scala/Unit#
file://<WORKSPACE>/src/main/scala/Main.scala
empty definition using pc, found symbol in pc: scala/Unit#
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -Unit#
	 -scala/Predef.Unit#
offset: 389
uri: file://<WORKSPACE>/src/main/scala/Main.scala
text:
```scala
@main def hello(): Unit =
  println("Hello world!")
  println(msg)

def msg = "I was compiled by Scala 3. :)";
def dial = 50;



object dayone{
  println("Hello, world!")
  val dial = 50;
  val zeroHit = 0;

  def wrapAround(current: Int, addition: Int, max: Int = 100): Int = {
    val rawResult: Int = current + addition
    (rawResult % max + max) % max
  }

  def spin(spin: String): U@@nit = {
    val direction = String(spin.charAt(0))
    val count = Int(spin.substring(1))


    if (direction == "L") {
      wrapAround(dial, -count)
    }
    if (direction == "R") {\
      wrapAround(dial, count)
    }
    if (dial == 0) {
      zeroHit++
    }
  }

}


object readDocument{
  val lines = scala.io.Source
}


```


#### Short summary: 

empty definition using pc, found symbol in pc: scala/Unit#