package com.keenworks.vote.condorcet.input

import com.keenworks.vote.condorcet.util.CondorcetSpec

class CandidateServiceSpec extends CondorcetSpec {
  "A CandidateService" should "parse a single candidate" in {
    val candidateLine: String = "0:My name"
    val candidateMap: Map[Int, String] = CandidateService.getCandidates(List(candidateLine))
    assert(candidateMap(0) == "My name")
  }

  it should "parse multiple candidates" in {
    val candidateStrings = List(
      "3:Jim",
      "4:Bob",
      "5:Mister Twister"
    )
    val candidateMap: Map[Int, String] = CandidateService.getCandidates(candidateStrings)
    assert(candidateMap(3) == "Jim")
    assert(candidateMap(5) == "Mister Twister")
  }
}
