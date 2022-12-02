package day02

class Constants {
	static final String OPP_ROCK = 'A'
	static final String OPP_PAPER = 'B'
	static final String OPP_SCISSORS = 'C'

	static final String ME_ROCK = 'X'
	static final String ME_PAPER = 'Y'
	static final String ME_SCISSORS = 'Z'

	static final int WIN = 6
	static final int DRAW = 3
	static final int LOSS = 0

	static final Map<String, Integer> MY_POINTS = [
			(ME_ROCK)    : 1,
			(ME_PAPER)   : 2,
			(ME_SCISSORS): 3
	]

	static final Map<String, Map<String, Integer>> RPS = [
			(OPP_ROCK)    : [
					(ME_ROCK)    : DRAW,
					(ME_PAPER)   : WIN,
					(ME_SCISSORS): LOSS
			],
			(OPP_PAPER)   : [
					(ME_ROCK)    : LOSS,
					(ME_PAPER)   : DRAW,
					(ME_SCISSORS): WIN
			],
			(OPP_SCISSORS): [
					(ME_ROCK)    : WIN,
					(ME_PAPER)   : LOSS,
					(ME_SCISSORS): DRAW
			]
	]
}
