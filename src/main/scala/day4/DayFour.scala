package day4

import helpers.ReadUtil

object dayfour{
  var grid: Array[Array[Char]] = Array()
  var adjacentPositions: List[(Int, Int)] = List()

  val up = (0,-1)
  val down = (0,1)
  val left = (-1,0)
  val right = (1,0)

  val upLeft = (-1,-1)
  val upRight = (1,-1)
  val downLeft = (-1,1)
  val downRight = (1,1)
  val adjacentDirections = List(up, down, left, right, upLeft, upRight, downLeft, downRight)
  val adjacentValue = '@'

  def collect_paper(grid: Array[Array[Char]]): Int = {
    var accessibleCount = 0
    
    for (row <- grid.indices) {
      for (col <- grid(row).indices) {
        // Only check positions that have paper rolls
        if (grid(row)(col) == adjacentValue) {
          if (is_accessible(row, col, grid)) {
            adjacentPositions = adjacentPositions :+ (col, row)
            accessibleCount += 1
          }
        }
      }
    }
    for (pos <- adjacentPositions) {
      replace_paper(pos._2, pos._1, grid)
    }
    
    println(s"Accessible paper roll positions: $adjacentPositions")
    println(s"Total accessible paper rolls: $accessibleCount")
    accessibleCount
  }

  def replace_paper(row: Int, col: Int, grid: Array[Array[Char]]): Unit = {
    grid(row)(col) = 'x'
  }

  def is_accessible(row: Int, col: Int, grid: Array[Array[Char]]): Boolean = {
    var adjacentPaperCount = 0
    
    for (direction <- adjacentDirections) {
      val newRow = row + direction._2
      val newCol = col + direction._1

      if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid(0).length) {
        if (grid(newRow)(newCol) == adjacentValue) {
          adjacentPaperCount += 1
        }
      }
    }
    
    // Accessible if fewer than 4 adjacent paper rolls
    adjacentPaperCount < 4
  }





  def main(): Unit = {
    val lines = ReadUtil.readLines("src/main/scala/day4/input.txt")
    grid = lines.map(_.toArray).toArray
    var collectedPaper = 0

    var beforeLength = -1
    while(beforeLength != adjacentPositions.length){
      beforeLength = adjacentPositions.length
      var paper = collect_paper(grid)
      

      collectedPaper += paper
    }
    println(s"Total collected paper rolls: $collectedPaper")

    

  }
}