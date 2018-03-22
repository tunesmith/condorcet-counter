package com.keenworks.vote.condorcet.input

import com.keenworks.vote.condorcet.util.CondorcetSpec

class BallotServiceSpec extends CondorcetSpec {
  "A BallotService" should "parse the example ballot line" in {
    val ballotLine = "3:0>1=2"
    val ballots: List[List[String]] = BallotService.getBallots(List(ballotLine))
    assert(ballots.size == 3)
    ballots.foreach(ballotList => {
      assert(ballotList.size == 2)
      assert(ballotList.head == "0")
      assert(ballotList(1) == "1=2")
    })
  }
}
