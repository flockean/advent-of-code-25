package day6

import helpers.ReadUtil

object daysix{
  
  def calculate_part_one(lines: List[String]): Long = {
    var matrix: List[List[String]] = List()
    for (line <- lines) {
      val parsedLine: Array[String] = line.split("\\s+").filter(_.nonEmpty).map(_.trim)
      matrix = matrix :+ parsedLine.toList
    }
    val operators = matrix.last.filter(s => s == "+" || s == "*").map(_.charAt(0))
    matrix = matrix.dropRight(1)
    val problems = matrix.transpose
    var totalSum: Long = 0
    for (i <- problems.indices) {
      val numbers = problems(i).map(_.toLong)
      var result: Long = numbers.head
      operators(i) match {
        case '+' => 
          for (j <- 1 until numbers.length) {
            result += numbers(j)
          }
        case '*' => 
          for (j <- 1 until numbers.length) {
            result *= numbers(j)
          }
      }
      totalSum += result
    }
    println(s"Part 1 Total: $totalSum")
    totalSum
  }

  def calculate_part_two(lines: List[String]): Long = {
    val maxWidth = lines.map(_.length).max
    val paddedLines = lines.map(_.padTo(maxWidth, ' '))

    var problemGroups: List[List[Int]] = List()
    var currentGroup: List[Int] = List()
    
    for (col <- (maxWidth - 1) to 0 by -1) {
      val isAllSpaces = (0 until paddedLines.length).forall(row => paddedLines(row)(col) == ' ')
      if (isAllSpaces) {
        if (currentGroup.nonEmpty) {
          problemGroups = currentGroup.reverse :: problemGroups
          currentGroup = List()
        }
      } else {
        currentGroup = col :: currentGroup
      }
    }
    if (currentGroup.nonEmpty) {
      problemGroups = currentGroup.reverse :: problemGroups
    }
    var totalSum: Long = 0
    for ((group, groupIndex) <- problemGroups.zipWithIndex) {
      if (group.nonEmpty) {
        var numbers: List[Long] = List()
        var operator: Char = ' '
        
        for (col <- group.reverse) { 
          val opChar = paddedLines.last(col)
          if (opChar == '+' || opChar == '*') {
            operator = opChar
          }
          var numberStr = ""
          for (row <- 0 until (paddedLines.length - 1)) {
            val char = paddedLines(row)(col)
            if (char.isDigit) {
              numberStr += char
            }
          }
          if (numberStr.nonEmpty) {
            numbers = numbers :+ numberStr.toLong
          }
        }
        if (numbers.nonEmpty && operator != ' ') {
          var result: Long = numbers.head
          operator match {
            case '+' => 
              for (j <- 1 until numbers.length) {
                result += numbers(j)
              }
            case '*' => 
              for (j <- 1 until numbers.length) {
                result *= numbers(j)
              }
          }
          totalSum += result
        }
      }
    }
    
    println(s"Part 2 Total: $totalSum")
    totalSum
  }
  
  def main(): Unit = {
    val lines = ReadUtil.readLines("src/main/scala/day6/input.txt")
    
    println("part one result:")
    calculate_part_one(lines)
    
    println("\npart two result:")
    calculate_part_two(lines)
  }
}