package util

class Input {
	private String input

	String asString() {
		return input.trim()
	}

	List<String> asLines() {
		return asString().readLines()
	}

	List<String> asElements(String separator) {
		return asString().split(separator)
	}
}
