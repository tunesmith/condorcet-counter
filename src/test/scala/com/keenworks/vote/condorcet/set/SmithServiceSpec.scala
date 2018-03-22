package com.keenworks.vote.condorcet.set

import com.keenworks.vote.condorcet.TallyService
import com.keenworks.vote.condorcet.input.{BallotService, CandidateService}
import com.keenworks.vote.condorcet.util.{CondorcetFixture, CondorcetSpec}

class SmithServiceSpec extends CondorcetSpec {
  "The SmithService" should "identify all candidates for the Smith Set in the SchwartzSmith fixture" in {
    val candidates = CandidateService.getCandidates(CondorcetFixture.smithSchwartzCandidates)
    val ballots = BallotService.getBallots(CondorcetFixture.smithSchwartzBallots)
    val tally = TallyService.tallyBallots(ballots, candidates.size)
    val candidateKeys: Seq[Int] = candidates.keys.toSeq.sortBy(x => x)
    val smithSet: List[List[Int]] = SmithService.getSmith(candidateKeys, tally)
    assert(smithSet.head.size == 3)
  }
}
