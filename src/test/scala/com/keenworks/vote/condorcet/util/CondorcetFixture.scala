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

  /*
  The "BadSmith" scenario is where the Smith Set is arguably contentious,
  and where d should arguably be the winner, even though it is not in the
  Smith Set. (The Schwartz Set should be the same as the Smith Set in this
  case.)

  A>B 66:33
  B>C 66:33
  C>A 66:33

  A>D 50:49
  B>D 50:49
  C>D 50:49
  */
  val badSmithCandidates = List(
    "1:A",
    "2:B",
    "3:C",
    "4:d"
  )
  val badSmithBallots = List(
    "17:1>2>4>3",
    "16:1>4>2>3",
    "17:2>3>4>1",
    "16:2>4>3>1",
    "17:3>1>4>2",
    "16:3>4>1>2"
  )
}
