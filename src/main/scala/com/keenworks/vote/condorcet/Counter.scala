package com.keenworks.vote.condorcet

import com.keenworks.vote.condorcet.input.{BallotService, CandidateService}
import com.keenworks.vote.condorcet.set.{SchwartzService, SetPrinter, SmithService}

import scala.io.Source

object Counter extends App {
//  println("Input candidate ID:Name pairs, one per line")
//  val candidateInput: List[String] = Source.stdin.getLines.toList
//  val candidates = CandidateService.getCandidates(candidateInput)
  val candidates = CandidateService.getBargamel

  System.out.println("Input Condorcet votes in format 3:0>1=2")
  val ballotLines = Source.stdin.getLines.toList
  val ballots = BallotService.getBallots(ballotLines)
  
  val tally: Array[Array[Int]] = TallyService.tallyBallots(ballots, candidates.size)

  val candidateKeys: Seq[Int] = candidates.keys.toSeq.sortBy(x => x)

  val schwartzSet = SchwartzService.getSchwartz(candidateKeys, tally)
  println("Schwartz: ")
  SetPrinter.print(schwartzSet, candidates)
  val smithSet = SmithService.getSmith(candidateKeys, tally)
  println("Smith: ")
  SetPrinter.print(smithSet, candidates)

}
