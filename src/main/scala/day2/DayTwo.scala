package day2

import helpers.ReadUtil

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
    for (line <- ReadUtil.readLines("input.txt")) {
      detectRange(line)
    }
    for (num <- foundNumbers) {
      sumOfInvalidIDs += num
    }
    println(sumOfInvalidIDs)
  }
}