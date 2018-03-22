package com.keenworks.vote.condorcet.input

object CandidateService {
  def getCandidates(candidateInput: List[String]): Map[Int, String] = {
    candidateInput.map(f => {
      val ballotLine: Array[String] = f.split(':')
      ballotLine(0).toInt -> ballotLine(1)
    }).toMap
  }

  def getBargamel: Map[Int, String] = {
    Map(
      1 -> "Bargamel's Consortium",
      2 -> "Bargamel's Envoy",
      3 -> "Sudden Lee Allies",
      4 -> "The Faircrest Consortium",
      5 -> "The Faircrest Envoy",
      6 -> "The Faircrest Syndicate",
      7 -> "The Heralds of Faircrest",
      8 -> "Legion of Faircrest",
      9 -> "Faircrest Alliance",
      10 -> "Faircrest Confederation",
      11 -> "Guild of Cedar Hills",
      12 -> "The Faircrest Foundation",
      13 -> "Faircrest",
      14 -> "Flock of Smeagols (write-in)",
      15 -> "The Protectorate of Plunder (PoP) (write-in)",
      16 -> "The Renegade Crusade (write-in)",
      17 -> "The Five Fearless of Faircrest (write-in)",
      18 -> "LEAP: League of Extraordinarily Ambivalent Potential (write-in)",
      19 -> "Alliance of Inadvisable Do-Goodery (write-in)",
      20 -> "SIT: Syndicate of Insufficent Tredpidation (write-in)",
      21 -> "The Order of Faircrest (write-in)"
    )
  }
}
