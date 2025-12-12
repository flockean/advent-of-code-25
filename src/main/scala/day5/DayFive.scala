package day5

import helpers.ReadUtil


object dayfive{

  var ingredientRanges: List[(Long, Long)] = List()
  var listOfIngredients: List[Long] = List()

  var listOfFreshIngredients: List[Long] = List()
  var listOfSpoiledIngredients: List[Long] = List()

  var listUniquieIds: List[Long] = List()

  def filterFreshIngredients(): Unit = {
    for ingredient <- listOfIngredients do
      var isFresh = true
      for range <- ingredientRanges do
        if ingredient >= range._1 && ingredient <= range._2 then
          isFresh = false
      if isFresh then
        listOfFreshIngredients = listOfFreshIngredients :+ ingredient
      else
        listOfSpoiledIngredients = listOfSpoiledIngredients :+ ingredient
  }

  def parseList(ingredientList: List[String]): Unit = {
    for line <- ingredientList do
      if (line.nonEmpty) then
        if line.contains("-") then
          println(line)
          val parts = line.split("-")
          ingredientRanges = ingredientRanges :+ (parts(0).toLong, parts(1).toLong)
        if !line.contains("-") then
          listOfIngredients = listOfIngredients :+ line.toLong
    
  }

  def partTwo(): Long = {
    val mergedRanges = mergeOverlappingRanges(ingredientRanges.sortBy(_._1))
    mergedRanges.map(range => range._2 - range._1 + 1).sum
  }
  
  def mergeOverlappingRanges(ranges: List[(Long, Long)]): List[(Long, Long)] = {
    if (ranges.isEmpty) return List()
    
    var merged: List[(Long, Long)] = List(ranges.head)
    
    for (current <- ranges.tail) {
      val last = merged.last
      if (current._1 <= last._2 + 1) {
        
        merged = merged.dropRight(1) :+ (last._1, math.max(last._2, current._2))
      } else {
        
        merged = merged :+ current
      }
    }
    
    merged
  }


  def main(): Unit = {
    parseList(ReadUtil.readLines("src/main/scala/day5/input.txt"))
    filterFreshIngredients()
    val totalUniqueIds = partTwo()
    
    println(s"Fresh ${listOfFreshIngredients.length}")
    println(s"Spoiled ${listOfSpoiledIngredients.length}")
    println(s"Total unique IDs $totalUniqueIds")
  }
}
