package com.keenworks.vote.condorcet

object TallyService {

  // For each preference, record it winning over every preference that comes after it
  def tallyBallots(ballots: List[List[String]], candidateCount: Int): Array[Array[Int]] = {
    val tally: Array[Array[Int]] = Array.ofDim[Int](candidateCount, candidateCount)

    ballots.foreach(ranks => {
      ranks.combinations(2).foreach(f => recordVictories(f.head, f(1)))
    })

    def recordVictories(victor: String, vanquished: String): Unit =
      for {
        winnerStr <- victor.split('=')
        loserStr <- vanquished.split('=')
        winner = winnerStr.toInt
        loser = loserStr.toInt
      } tally(winner-1)(loser-1) += 1

    //  tally.zipWithIndex.foreach {
    //    case (row, count) =>
    //      val name = domains(count + 1)
    //      printf("%-70s", name + ": ")
    //      row foreach (s => {
    //        printf("%-3s", s + ",")
    //      })
    //      println
    //  }

    tally
  }
}
