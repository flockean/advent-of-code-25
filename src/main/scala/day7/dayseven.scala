package day7

import helpers.ReadUtil

object dayseven {


  var laserMatrix: List[List[Char]] = List()
  var splitCount: Int = 0
  
  def splitBeam(x: Int, y: Int, matrix: List[List[Char]]): Unit = {
    if (x + 1 < matrix(y).length) {
      laserMatrix = laserMatrix.updated(y, laserMatrix(y).updated(x + 1, '|'))
    }
    if (x - 1 >= 0) {
      laserMatrix = laserMatrix.updated(y, laserMatrix(y).updated(x - 1, '|'))
    }
    splitCount += 1
  }

  def splitTimeLeft(x: Int, y: Int): Unit = {
    if (x - 1 >= 0) {
      laserMatrix = laserMatrix.updated(y, laserMatrix(y).updated(x - 1, '|'))
      progressBeam(x - 1, y)
    }

  }

  def splitTimeRight(x: Int, y: Int): Unit = {
    if (x + 1 < laserMatrix(y).length) {
      laserMatrix = laserMatrix.updated(y, laserMatrix(y).updated(x + 1, '|'))
      progressBeam(x + 1, y)
    }
  }

  // Part 2 logic didnt solve it yet :(
  def splitTimeBoth(x: Int, y: Int): Unit = {
    laserMatrix(y)(x-1) match {
      case '.' => splitTimeLeft(x, y)
      case _ =>
    }
    laserMatrix(y)(x+1) match {
      case '.' => splitTimeRight(x, y)
      case _ =>
    }
  }

  def progressBeam(x: Int, y: Int): Unit = {
    if (y + 1 < laserMatrix.length) {
      laserMatrix(y + 1)(x) match {
        case '.' => laserMatrix = laserMatrix.updated(y + 1, laserMatrix(y + 1).updated(x, '|'))
        case '^' => splitTimeBoth(x, y + 1)             // Part 2 logic
        // case '^' => splitBeam(x, y + 1, laserMatrix) Part 1 logic
        case _ =>
      }
    }
  }

  def forwardBeam(): Unit = {
    for{
      row <- laserMatrix.indices
      col <- laserMatrix(row).indices
    } {
      val char = laserMatrix(row)(col)
      char match {
        case 'S' => progressBeam(col, row)
        case '|' => progressBeam(col, row)
        case '.' => 
        case _ => 
      }
    }
  }
    



  def main(): Unit = {
    val lines = ReadUtil.readLines("src/main/scala/day7/input.txt") 
    laserMatrix = lines.map(_.toList)
    
    println("Original matrix:")
    laserMatrix.foreach(row => println(row.mkString))
    
    forwardBeam()
    
    println("\nAfter forwardBeam:")
    laserMatrix.foreach(row => println(row.mkString))
    println(s"\nSplit count: $splitCount")
  
  }
}
