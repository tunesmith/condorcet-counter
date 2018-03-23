# Condorcet Counter

This is a simple excuse to play with [Scala Native](http://www.scala-native.org/en/latest/)
and some Condorcet algorithms.

## Usage

This is a simple script designed to be run from the shell. It
first prompts for the list of candidates starting with id 1:

    1: Teddy Roosevelt
    2: Ned Stark
    3: Sauron

Hit Control-D to continue. Then it prompts for the list of 
ballots:

    3:1>2>3
    5:2>1=3
    1:3>2>1

The first number is the number of ballots with that preference
order, and the part after the colon is the preference order.
Ties are allowed via the `=` sign.

The output is the complete order of candidates, grouped by 
Schwartz and Smith set. This is accomplished by finding the 
set, removing those candidates from the ballots, and recounting
until a complete order is calculated.

## Condorcet Discussion
For a brief review, a `Condorcet Winner` is a candidate that would **beat** 
all other candidates head-to-head. A `Weak Condorcet Winner` is a candidate
that would **beat or tie** all other candidates head-to-head.

The `Smith Set` is the smallest set of candidates that would beat all
other candidates head-to-head.

The `Schwartz Set` is the smallest set of candidates that would beat or
tie all other candidates head-to-head.

A single-candidate Smith Set is a Condorcet Winner. A single-candidate
Schwartz Set is at least a Weak Condorcet Winner.

There are many other algorithms that purport to elect a single 
winner from a multi-candidate Smith Set or a Schwartz Set. The 
literature at this point is deeply misleading, as the flaws 
with these "tiebreaking" algorithms are often painted as flaws 
with Condorcet methods in general. 

Complicating this is that several so-called "Condorcet Method" 
algorithms entirely skip the identification of the Smith or Schwartz
sets, in favor of identifying a single winner even if there isn't
a Condorcet Winner. This contributes to the confusion in the literature.

A multi-candidate set often (but not always) indicates a preference
cycle, and it is impossible to fairly select a single winner from
a preference cycle. But this is not the fault of the Smith/Schwartz
Set. "The fault, dear Brutus, is not in our stars / But in ourselves".
It is the electorate itself that has this inconsistency.

It's this author's view that a method should only be called a Condorcet 
if it is limited to identifying the Smith Set, or the Schwartz Set 
if Weak Condorcet Winners are allowable.

All other so-called "Condorcet Completion" algorithms should be
described as they are - tiebreakers that are by their very nature
flawed, in that they try to force consistency on a set of ballots
that is by definition not consistent.

For elections that are willing to accept these risks and flaws
in the count, this is of course allowable. But for those that
wish to find a true Condorcet Winner, the appropriate remedy
is to identify the Smith or Schwartz set, allow the electorate
further time to discuss and decide, and then hold additional 
rounds of elections restricted to those candidates in each 
round's Smith or Schwartz set, until a single winner is 
identified.
