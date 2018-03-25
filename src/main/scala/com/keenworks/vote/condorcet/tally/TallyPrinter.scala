package com.keenworks.vote.condorcet.tally

object TallyPrinter {
  def print(tally: Array[Array[Int]], candidates: Map[Int, String]): Unit = {
    tally.zipWithIndex.foreach {
      case (row, count) =>
        val length: Int = candidates.maxBy{ case (_, candidate) => candidate.length}._2.length // wdyj ... ?
        val candidateName = candidates(count + 1)
        val formatString = "%-" + length.toString + "s"  // wdyj ... ?
        printf(formatString, candidateName + ": ")
        row foreach (s => {
          printf("%-3s", s + ",")
        })
        println
    }
  }
}
