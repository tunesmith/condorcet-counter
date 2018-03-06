package com.keenworks.vote.condorcet

import com.keenworks.vote.condorcet.input.{BallotService, CandidateService}
import com.keenworks.vote.condorcet.set.{SchwartzService, SetPrinter, SmithService}

object Counter extends App {
  val candidates = CandidateService.getBargamel
  val ballots = BallotService.getBallots
  val tally: Array[Array[Int]] = TallyService.tallyBallots(ballots, candidates.size)

  val candidateKeys: Seq[Int] = candidates.keys.toSeq.sortBy(x => x)

  val schwartzSet = SchwartzService.getSchwartz(candidateKeys, tally)
  println("Schwartz: ")
  SetPrinter.print(schwartzSet, candidates)
  val smithSet = SmithService.getSmith(candidateKeys, tally)
  println("Smith: ")
  SetPrinter.print(smithSet, candidates)

}
