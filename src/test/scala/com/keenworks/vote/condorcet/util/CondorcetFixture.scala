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

  /*
  The "UnionSchwartz" scenario is one where the Schwartz Set is {A, B, C, D, E},
  but the Weak Condorcet Winner is E. This is because the Schwartz Set is the union
  of all such minimal sets that defeat or tie all other candidates. Unlike Smith,
  there can be multiple such sets in the Schwartz Set. That said, I would like
  the algorithm to identify the single Weak Condorcet Winner if it exists.
  That will be a future enhancement, and this is a useful test case for that.
   */
  val unionSchwartzCandidates = List(
    "1:A",
    "2:B",
    "3:C",
    "4:D",
    "5:E",
    "6:F",
    "7:G",
    "8:H",
    "9:I",
    "10:J",
    "11:K",
    "12:L"
  )
  val unionSchwartzBallots = List(
    "6:1>2>3=4=5=6=7=8=9=10=11=12",
    "1:1>3>8>4>2>7>6>5>12>9>11>10",
    "6:3>4>1=2=5=6=7=8=9=10=11=12",
    "3:5>1>3>8>4>2>6=7=9=10=11=12",
    "3:5>2>4>3>1>6=7=8=9=10=11=12",
    "2:5>6>7>8>1>2>3=4=9=10=11=12",
    "2:5>7>6>8>2>3>1=4=9=10=11=12",
    "4:6>4>7>8>1>2=3=5=9=10=11=12",
    "1:6>7>5>8>2>4>3>1>12>9=10=11",
    "4:7>2>6>8>3>1=4=5=9=10=11=12",
    "1:8>7>6>5>4>3>2>10>9>11>12>1",
    "9:8>7>6>5>4>3>2>12>9>10>11>1",
    "10:11>10>9>12>1>2>3>4>5>6>7>8"
  )

  /*
  The "Schulze Wiki" scenario is taken from the Schulze Method wikipedia page at
  https://en.wikipedia.org/wiki/Schulze_method

  While the Schulze method determines an order, the initial Schwartz Set (and Smith
  Set) is still the set of all candidates.
   */
  val schulzeWikiCandidates = List(
    "1:A",
    "2:B",
    "3:C",
    "4:D",
    "5:E"
  )

  val schulzeWikiBallots = List(
    "5:1>3>2>5>4",
    "5:1>4>5>3>2",
    "8:2>5>4>1>3",
    "3:3>1>2>5>4",
    "7:3>1>5>2>4",
    "2:3>2>1>4>5",
    "7:4>3>5>2>1",
    "8:5>2>1>4>3"
  )
}
