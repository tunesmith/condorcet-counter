package com.keenworks.vote.condorcet.util

object CondorcetFixture {
  /*
  Taken from https://en.wikipedia.org/wiki/Schwartz_set -
  A should be in the Schwartz set, while all three will be in Smith
   */
  val smithSchwartzCandidates = List(
    "1:A",
    "2:B",
    "3:C"
  )
  val smithSchwartzBallots = List(
    "3:1>2>3",
    "1:2>3>1",
    "1:3>1>2",
    "1:3>2>1"
  )
}
