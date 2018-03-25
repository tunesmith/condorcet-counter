package com.keenworks.vote.condorcet.set

import com.keenworks.vote.condorcet.input.{BallotService, CandidateService}
import com.keenworks.vote.condorcet.tally.TallyService
import com.keenworks.vote.condorcet.util.{CondorcetFixture, CondorcetSpec}

class SmithServiceSpec extends CondorcetSpec {
  "The SmithService" should "identify all candidates for the Smith Set in the SchwartzSmith fixture" in {
    val smithSet: List[List[Int]] = getSmithSet(CondorcetFixture.smithSchwartzCandidates, CondorcetFixture.smithSchwartzBallots)
    assert(smithSet.head.size == 3)
  }

  it should "identify the first three candidates for the Smith Set in the BadSmith fixture" in {
    val smithSet: List[List[Int]] = getSmithSet(CondorcetFixture.badSmithCandidates, CondorcetFixture.badSmithBallots)
    assert(smithSet.head.contains(1))
    assert(smithSet.head.contains(2))
    assert(smithSet.head.contains(3))
    assert(smithSet(1).contains(4))
  }

  private def getSmithSet(candidateList: List[String], ballotList: List[String]) = {
    val candidates = CandidateService.getCandidates(candidateList)
    val ballots = BallotService.getBallots(ballotList)
    val tally = TallyService.tallyBallots(ballots, candidates.size)
    val candidateKeys: Seq[Int] = candidates.keys.toSeq.sortBy(x => x)
    val smithSet: List[List[Int]] = SmithService.getSmith(candidateKeys, tally)
    smithSet
  }
}
