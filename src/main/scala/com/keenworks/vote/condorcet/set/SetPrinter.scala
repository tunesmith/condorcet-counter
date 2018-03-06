package com.keenworks.vote.condorcet.set

object SetPrinter {
  def print(set: List[List[Int]], candidates: Map[Int, String]): Unit = {
    set.foreach(group => {
      println("(")
      group.foreach(id => {
        println("  " + candidates(id))
      })
      println(")")
    })
  }
}
