import com.keenworks.vote.condorcet.Counter.{candidateCount, tally}

val victor: String = "0=3"
val vanquished: String = "1=2"

val tally = Array.ofDim[Int](3,3)
val defeats = Array.ofDim[Int](3)

for {
  row <- tally
  column <- row
} println(row, column)

val dummy = Array.ofDim[Boolean](2,2)
dummy(0)(0)

//tally.zipWithIndex.foreach {
//  case(blah, count) => {
//    print(count)
//    blah.foreach(s => {
//      print(s + ",")
//    })
//    println
//  }
//}

//for {
//  winner <- victor.split('=')
//  loser <- vanquished.split('=')
//} println(winner.toInt, loser.toInt)
//
//val list = List(1,2,3,4)
//
//for {
//  i <- list
//  j <- list
//  k <- list
//} print (i,j,k)
//
//for {
//  first <- list
//  second <- list.tail if second > first
//} println(first, second)

//val domains = Map(
//  "1" -> "Bargamel's Envoy",
//  "2" -> "Faircrest",
//  "3" -> "Blah",
//  "4" -> "Blah",
//  "5" -> "Blah",
//  "6" -> "Blah",
//  "7" -> "Blah",
//  "8" -> "Blah",
//  "9" -> "Blah",
//  "10" -> "Blah",
//  "11" -> "Blah",
//  "12" -> "Blah",
//  "13" -> "Blah",
//  "14" -> "Blah",
//  "15" -> "Blah",
//  "16" -> "Blah",
//  "17" -> "Blah",
//  "18" -> "Blah",
//  "19" -> "Blah",
//  "20" -> "Blah",
//  "21" -> "Blah"
//)


//for {
//  i <- domains.toSeq.sortBy(_._1.toInt)
//  j <- domains.toSeq.sortBy(_._1.toInt) if j._1 != i._1
//} println(i.toString + j.toString)

/*
    for {
      winners <- victor.split('=')
      winner <- winners
      losers <- vanquished.split('=')
      loser <- losers
    } yield tally(winner)(loser) += 1
 */