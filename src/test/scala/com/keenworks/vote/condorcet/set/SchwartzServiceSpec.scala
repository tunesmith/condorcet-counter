package com.keenworks.vote.condorcet.set

import com.keenworks.vote.condorcet.input.{BallotService, CandidateService}
import com.keenworks.vote.condorcet.tally.{TallyPrinter, TallyService}
import com.keenworks.vote.condorcet.util.{CondorcetFixture, CondorcetSpec}

class SchwartzServiceSpec extends CondorcetSpec {
  "The SchwartzService" should "find the single Schwartz winner in the SchwartzSmith fixture" in {
    val candidates = CandidateService.getCandidates(CondorcetFixture.smithSchwartzCandidates)
    val ballots = BallotService.getBallots(CondorcetFixture.smithSchwartzBallots)
    val schwartzSet: List[List[Int]] = getSchwartz(candidates, ballots)
    assert(schwartzSet.head.size == 1)
    assert(candidates(schwartzSet.head.head) == "A")
  }

  it should "identify the first three candidates for the Schwartz Set in the BadSmith fixture" in {
    val candidates = CandidateService.getCandidates(CondorcetFixture.badSmithCandidates)
    val ballots = BallotService.getBallots(CondorcetFixture.badSmithBallots)
    val schwartzSet: List[List[Int]] = getSchwartz(candidates, ballots)
    assert(schwartzSet.head.contains(1))
    assert(schwartzSet.head.contains(2))
    assert(schwartzSet.head.contains(3))
    assert(schwartzSet(1).contains(4))
  }

  it should "identify a WCW different than the Schwartz Set in the UnionSchwartz fixture" in {
    val candidates = CandidateService.getCandidates(CondorcetFixture.unionSchwartzCandidates)
    val ballots = BallotService.getBallots(CondorcetFixture.unionSchwartzBallots)
    val schwartzSet: List[List[Int]] = getSchwartz(candidates, ballots)
//    SetPrinter.print(schwartzSet, candidates)
    assert(schwartzSet.nonEmpty)
  }

  it should "identify all candidates as the Schwartz Set in the SchulzeWiki fixture" in {
    val candidates = CandidateService.getCandidates(CondorcetFixture.schulzeWikiCandidates)
    val ballots = BallotService.getBallots(CondorcetFixture.schulzeWikiBallots)
    val schwartzSet: List[List[Int]] = getSchwartz(candidates, ballots)
//    SetPrinter.print(schwartzSet, candidates)
    assert(schwartzSet.nonEmpty)
    assert(schwartzSet.head.size == 5)
  }

  private def getSchwartz(candidates: Map[Int, String], ballots: List[List[String]]) = {
    val tally = TallyService.tallyBallots(ballots, candidates.size)
//    TallyPrinter.print(tally, candidates)
    val candidateKeys: Seq[Int] = candidates.keys.toSeq.sortBy(x => x)
    SchwartzService.getSchwartz(candidateKeys, tally)
  }
}
