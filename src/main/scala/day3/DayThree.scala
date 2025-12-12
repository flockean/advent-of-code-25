package day3

import helpers.ReadUtil
import scala.util.boundary
import scala.util.boundary.break

object daythree{
  var foundNumbers: List[Int] = List()
  var sumOfFoundNumbers: Int = 0

  def indentifyJolt(bank: String): Int = {
    var maxBankNum: Int = (bank.charAt(0).toString + bank.charAt(1).toString).toInt

    for (bankNum <- 0 to (bank.length - 1)) {
      for (compareNum <- (bankNum + 1) to (bank.length - 1)) {
        val combinedNum: Int = (bank.charAt(bankNum).toString + bank.charAt(compareNum).toString).toInt
        if (combinedNum >= maxBankNum) {
          maxBankNum = combinedNum
        }
      }
    }
    maxBankNum
  }

  def identifyStaticJolt(bankQuery: String, targetLength: Int): BigInt = {
    if (bankQuery.length < targetLength) return BigInt(bankQuery)
    
    var result = ""
    // example 20 - 12 = 8
    val toRemove = bankQuery.length - targetLength
    // up to 8
    var removed = 0

    // [2,3,4,2,3,4,2,3,4,2,3,4,2,7,8]
    for (i <- bankQuery.indices) {
      val currentDigit = bankQuery(i)
      
      // true when [...] and currentDigit > last digit in result
      while (result.nonEmpty && result.last < currentDigit && removed < toRemove) {
        result = result.dropRight(1)
        removed += 1
      }
      
      result += currentDigit
    }
    
    // trim last digits if still longer than target (last are smallerst)
    while (result.length > targetLength) {
      result = result.dropRight(1)
    }

    return BigInt(result)
  }


  def main(): Unit = {
    var foundNumbers: List[BigInt] = List()

    for (line <- ReadUtil.readLines("src/main/scala/day3/input.txt")) {
      var identifiedJolt = identifyStaticJolt(line, 12)
      foundNumbers = foundNumbers :+ identifiedJolt
      
    }
    println("Found Banks " + foundNumbers)
    println("Found Banks in Number " + foundNumbers.sum)
  }
}