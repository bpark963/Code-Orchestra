
//to run the program, place your cursor inside the parenthesis and type command-return
(
//this is set up to use a Korg nanoKONTROL2, if one is available. it is not necessary
MIDIClient.init;
MIDIIn.connectAll;

s.waitForBoot({
	Photokeratitis(s, version:1, outChannel:0)  //there are two different versions of the software: 1 and 2. It might work to create a mix of the systems, where some of the players are using version 1 and some are using version 2.
})
)

//each time played, the group should make a new score
(
	Photokeratitis.makeScore(numPlayers: 8, duration: 600, min_density: 2, max_density: 8, lowDur: 20, highDur: 70);
)


