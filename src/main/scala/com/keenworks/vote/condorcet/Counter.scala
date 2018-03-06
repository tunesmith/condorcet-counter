package com.keenworks.vote.condorcet

import com.keenworks.vote.condorcet.input.{BallotService, CandidateService}
import com.keenworks.vote.condorcet.set.{SchwartzService, SmithService}

object Counter extends App {
  val candidates = CandidateService.getBargamel
  val ballots = BallotService.getBallots

  val candidateCount = candidates.size
  val candidateKeys: Seq[Int] = candidates.keys.toSeq.sortBy(x => x)

  val tally: Array[Array[Int]] = TallyService.tallyBallots(ballots, candidateCount)

  val schwartzSet: Seq[Int] = SchwartzService.getSchwartz(candidateCount, candidateKeys, tally)
  println("schwartz: " + schwartzSet.toString)
  val smithSet: List[Int] = SmithService.getSmith(candidateCount, candidateKeys, tally)
  print("smith: ")
  smithSet.sortBy(f => f).foreach(f => print(f + 1 + ", "))
  println
}
