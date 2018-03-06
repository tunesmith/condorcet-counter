package com.keenworks.vote.condorcet.set

object SchwartzService {

  def getSchwartz(candidateCount: Int, candidateKeys: Seq[Int], tally: Array[Array[Int]]): Seq[Int] = {
    val dummy = Array.ofDim[Boolean](candidateCount,candidateCount)

    for {
      index <- candidateKeys
      jindex <- candidateKeys
      if jindex != index
      i = index -1
      j = jindex-1
    } dummy(i)(j) = tally(i)(j) > tally(j)(i)

    //  dummy foreach { row => row foreach (s => { print({
    //    if (s) '1' else '0'
    //  } + ",") }); println }

    for {
      kindex <- candidateKeys
      index <- candidateKeys
      if kindex != index
      jindex <- candidateKeys
      if kindex != jindex && jindex != index
    } {
      val i = index -1
      val j = jindex -1
      val k = kindex - 1
      if (dummy(i)(k) && dummy(k)(j)) {
        dummy(i)(j) = true
      }
    }

    //    dummy foreach { row => row foreach (s => { print({
    //      if (s) '1' else '0'
    //    } + ",") }); println }

    val losers: Seq[Int] = for {
      index <- candidateKeys
      jindex <- candidateKeys
      if jindex != index
      i = index - 1
      j = jindex - 1
      if dummy(j)(i) && !dummy(i)(j)
    } yield i + 1

    //  println("losers: " + losers.toString)

    candidateKeys.filterNot(p => losers.contains(p))
  }
}
