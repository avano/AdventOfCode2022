package day13

enum Result {
	YES, NO, MAYBE

	Result and(Result other) {
		return switch (this) {
			case YES -> YES
			case MAYBE -> other
			case NO -> NO
		}
	}
}
