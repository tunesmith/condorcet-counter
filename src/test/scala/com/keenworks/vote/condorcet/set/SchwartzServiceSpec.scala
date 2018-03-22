package com.keenworks.vote.condorcet.set

import com.keenworks.vote.condorcet.TallyService
import com.keenworks.vote.condorcet.input.{BallotService, CandidateService}
import com.keenworks.vote.condorcet.util.{CondorcetFixture, CondorcetSpec}

class SchwartzServiceSpec extends CondorcetSpec {
  "The SchwartzService" should "find the single Schwartz winner in the SchwartzSmith fixture" in {
    val candidates = CandidateService.getCandidates(CondorcetFixture.smithSchwartzCandidates)
    val ballots = BallotService.getBallots(CondorcetFixture.smithSchwartzBallots)
    val tally = TallyService.tallyBallots(ballots, candidates.size)
    val candidateKeys: Seq[Int] = candidates.keys.toSeq.sortBy(x => x)
    val schwartzSet: List[List[Int]] = SchwartzService.getSchwartz(candidateKeys, tally)
    assert(schwartzSet.head.size == 1)
    assert(candidates(schwartzSet.head.head) == "A")
  }
}
