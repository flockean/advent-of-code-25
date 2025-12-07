@main def hello(): Unit =
  println("Hello Advent of Code!")
  daytwo.main()

object dayone{
  var dial: Int = 50
  var hitTotal: Int = 0

  def wrapAround(current: Int, addition: Int, max: Int = 100): Int = {
    val rawResult: Int = current + addition
    (rawResult % max + max) % max
  }

  def spinDial(spin: String): Unit = {
    // First character is direction, rest is count
    val count = spin.substring(1).toInt
    val oldDial = dial
    
    spin.charAt(0) match {
      case 'L' => 
        val distanceToFirstZero = if (oldDial == 0) 100 else oldDial
        if (count >= distanceToFirstZero) {
          hitTotal += 1 + ((count - distanceToFirstZero) / 100)
        }
        dial = wrapAround(dial, -count)
      case 'R' => 
        val distanceToFirstZero = if (oldDial == 0) 100 else (100 - oldDial)
        if (count >= distanceToFirstZero) {
          hitTotal += 1 + ((count - distanceToFirstZero) / 100)
        }
        dial = wrapAround(dial, count)
      case _ => 
        println("Invalid direction")
    }
  }
  
  def main(): Unit = {
    for (line <- readDocument.lines) {
      spinDial(line)
    }
    print(hitTotal)
  }

}


object daytwo{
  var foundNumbers: List[Long] = List()
  var sumOfInvalidIDs: Long = 0

  def isInvalid(number: Long): Boolean = {
    val numStr = number.toString
    val length = numStr.length
    
    // even length check
    if (length % 2 != 0) return false
    
    val half = length / 2
    val firstHalf = numStr.substring(0, half)
    val secondHalf = numStr.substring(half)
    
    // check identical
    firstHalf == secondHalf
  }

  def isInvalidMorethanTwice(number: Long): Boolean = {
    val numStr = number.toString
    val length = numStr.length
    
    // even length check
    for (patternLen <- 1 to length / 2) {
      if (length % patternLen == 0) {
        val pattern = numStr.substring(0, patternLen)
        val timesRepeated = length / patternLen
        
        // at least twice repeated
        if (timesRepeated >= 2) {
          val reconstructed = pattern * timesRepeated
          if (reconstructed == numStr) {
            return true
          }
        }
      }
    }
    false
  }

  def detectRange(range: String): Unit = {
    val parts = range.split("-")
    val start = parts(0).toLong
    val end = parts(1).toLong

    for (number <- start to end) {
      if (isInvalidMorethanTwice(number)) {
        foundNumbers = foundNumbers :+ number
      }
    }
  }

  def main(): Unit = {
    for (line <- readDocument.lines) {
      detectRange(line)
    }
    for (num <- foundNumbers) {
      sumOfInvalidIDs += num
    }
    println(sumOfInvalidIDs)
  }
}


object readDocument{
  // Read lines
  // val lines = scala.io.Source.fromFile("input.txt").getLines.toList

  // Read line comma separated
  val lines = scala.io.Source.fromFile("input.txt").getLines().next().split(",").toList

}

