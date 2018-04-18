package com.keenworks.vote.condorcet.set

import com.keenworks.vote.condorcet.input.{BallotService, CandidateService}
import com.keenworks.vote.condorcet.tally.TallyService
import com.keenworks.vote.condorcet.util.{CondorcetFixture, CondorcetSpec}

class SmithServiceSpec extends CondorcetSpec {
  "The SmithService" should "identify all candidates for the Smith Set in the SchwartzSmith fixture" in {
    val candidates = CandidateService.getCandidates(CondorcetFixture.smithSchwartzCandidates)
    val ballots = BallotService.getBallots(CondorcetFixture.smithSchwartzBallots)
    val smithSet: List[List[Int]] = getSmithSet(candidates, ballots)
    assert(smithSet.head.size == 3)
  }

  it should "identify the first three candidates for the Smith Set in the BadSmith fixture" in {
    val candidates = CandidateService.getCandidates(CondorcetFixture.badSmithCandidates)
    val ballots = BallotService.getBallots(CondorcetFixture.badSmithBallots)
    val smithSet: List[List[Int]] = getSmithSet(candidates, ballots)
    assert(smithSet.head.contains(1))
    assert(smithSet.head.contains(2))
    assert(smithSet.head.contains(3))
    assert(smithSet(1).contains(4))
  }

  it should "identify all candidates as the Smith Set in the UnionSchwartz fixture" in {
    val candidates = CandidateService.getCandidates(CondorcetFixture.unionSchwartzCandidates)
    val ballots = BallotService.getBallots(CondorcetFixture.unionSchwartzBallots)
    val smithSet: List[List[Int]] = getSmithSet(candidates, ballots)
//    SetPrinter.print(smithSet, candidates)
    assert(smithSet.nonEmpty)
  }

  it should "identify all candidates as the Smith Set in the SchulzeWiki fixture" in {
    val candidates = CandidateService.getCandidates(CondorcetFixture.schulzeWikiCandidates)
    val ballots = BallotService.getBallots(CondorcetFixture.schulzeWikiBallots)
    val smithSet: List[List[Int]] = getSmithSet(candidates, ballots)
//    SetPrinter.print(smithSet, candidates)
    assert(smithSet.nonEmpty)
    assert(smithSet.head.size == 5)
  }

  private def getSmithSet(candidates: Map[Int, String], ballots: List[List[String]]) = {
    val tally = TallyService.tallyBallots(ballots, candidates.size)
    val candidateKeys: Seq[Int] = candidates.keys.toSeq.sortBy(x => x)
    val smithSet: List[List[Int]] = SmithService.getSmith(candidateKeys, tally)
    smithSet
  }
}
