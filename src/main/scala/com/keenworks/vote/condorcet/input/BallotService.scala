package com.keenworks.vote.condorcet.input

import scala.io.Source

object BallotService {
  /*

  Each element of the returned array is an array of preferences, e.g.
  [0] = 1
  [1] = 2,3
  [2] = 4

  This means that the user (represented by the row) prefers 1 to 2 and 3,
  and also prefers 2 and 3 to 4.

      2
    /   \
  1       4
    \   /
      3
  (------->)

  */
  def getBallots: List[List[String]] = {
    System.out.println("Input Condorcet votes in format 3:0>1=2")
    val ballotInput = Source.stdin.getLines.toList

    ballotInput.flatMap(ln => {
      val ballotGroup: Array[String] = ln.split(':').take(2)
      val (count, rank): (Int, String) = ballotGroup(0).toInt -> ballotGroup(1)
      List.fill(count)(rank.split('>').toList)
    })
  }
}
