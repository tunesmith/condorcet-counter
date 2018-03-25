package com.keenworks.vote.condorcet.tally

object TallyService {

  // For each preference, record it winning over every preference that comes after it
  def tallyBallots(ballots: List[List[String]], candidateCount: Int): Array[Array[Int]] = {
    val tally: Array[Array[Int]] = Array.ofDim[Int](candidateCount, candidateCount)

    ballots.foreach(ranks => {
      ranks.combinations(2).foreach(f => recordVictories(f.head, f(1)))
    })

    /*
    TODO: This is a little ugly because it assumes candidates are 1-indexed.
     */
    def recordVictories(victor: String, vanquished: String): Unit =
      for {
        winnerStr <- victor.split('=')
        loserStr <- vanquished.split('=')
        winner = winnerStr.toInt
        loser = loserStr.toInt
      } tally(winner-1)(loser-1) += 1

    tally
  }
}
