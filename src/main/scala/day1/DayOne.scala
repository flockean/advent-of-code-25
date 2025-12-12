package day1

import helpers.ReadUtil

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
    for (line <- ReadUtil.readLines("input.txt")) {
      spinDial(line)
    }
    print(hitTotal)
  }

}
