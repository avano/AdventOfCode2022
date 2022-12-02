package day02

import static day02.Constants.DRAW
import static day02.Constants.LOSS
import static day02.Constants.MY_POINTS
import static day02.Constants.RPS
import static day02.Constants.WIN

import util.Input
import util.Inputs

Inputs.load(this)

int part1(Input input = Inputs.input1) {
	return input.asLines().inject(0) { result, line ->
		def (opponent, me) = line.split(" ")
		result += MY_POINTS.get(me) + RPS.get(opponent).get(me)
	}
}

int part2(Input input = Inputs.input2) {
	def results = [
			'X': (LOSS),
			'Y': (DRAW),
			'Z': (WIN)
	]
	return input.asLines().inject(0) { result, line ->
		def (opponent, r) = line.split(" ")
		result += results.get(r) + MY_POINTS.get(RPS.get(opponent).find { e -> e.value == results.get(r) }.key)
	}
}

println "Part 1: ${part1()}"
println "Part 2: ${part2()}"
