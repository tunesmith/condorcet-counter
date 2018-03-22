package com.keenworks.vote.condorcet.set

import scala.collection.immutable.ListMap

/**
  * SmithService
  *
  * Begin with a list of (n) candidates. Find the candidate(s)
  * with the fewest number of defeats, and place them at the
  * beginning of the list, since they are guaranteed to be
  * members of Smith.
  *
  * Then scan through the (n-1) candidates remaining, and if
  * a candidate pairwise beats or ties any member of the current
  * smith set, move it to the next position at the beginning of
  * the list.
  *
  * Keep scanning through the remaining candidates until
  * none of them beat or tie any member of the current
  * smith set, and then you're done.
  *
  */
object SmithService {
  def getSmith(candidateKeys: Seq[Int], tally: Array[Array[Int]]): List[List[Int]] = {

    /**
      * We want to end up with a sorted-by-value map of key->defeats,
      * in ascending order. So the first candidate has the fewest defeats.
      */
    val defeats: Array[Int] = Array.ofDim[Int](tally.length)
    for {
      i <- candidateKeys
      j <- candidateKeys
      row = i - 1
      column = j - 1
      if row != column
    } if (tally(row)(column) <= tally(column)(row)) defeats(row) += 1
    val defeatMap = for ((defeats, count) <- defeats.zipWithIndex) yield (count, defeats)
    val sortedDefeatMap: Map[Int, Int] = ListMap(defeatMap.toSeq.sortBy(_._2):_*)
    val sortedDefeatKeys = sortedDefeatMap.keys.toList.filter(p => { candidateKeys.contains(p+1)})

    /**
      * We're simply adding candidates to the set of those that beat or tied each other.
      *
      * @param oldSmith       We've already checked these defeats on previous iterations
      * @param currentSmith   Checking these for defeats on this iteration
      * @param listToCheck    Check these to see if any have defeated any of currentSmith
      * @return               List of every candidate in the smith set (so far)
      */
    def calculateSmith(oldSmith: List[Int], currentSmith: List[Int], listToCheck: List[Int]): List[Int] = {
      val partialSmith: List[Int] = for {
        smith <- currentSmith
        maybe <- listToCheck
        if tally(smith)(maybe) <= tally(maybe)(smith)
      } yield maybe
      if (partialSmith.nonEmpty) { calculateSmith(oldSmith ++ currentSmith, partialSmith, listToCheck diff partialSmith) } else { oldSmith ++ currentSmith }
    }

    val smithList: List[Int] = calculateSmith(List(), List(sortedDefeatKeys.head), sortedDefeatKeys.tail).distinct
    val smithSet = smithList.map(_ + 1).sortBy(x => x)
    val losers: List[Int] = (candidateKeys diff smithSet).toList

    if(losers.nonEmpty) List(smithSet) ++ getSmith(losers, tally) else List(smithSet)
  }
}
