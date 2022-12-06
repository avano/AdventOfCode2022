package util

class Input {
	private String input

	String asString() {
		return input
	}

	List<String> asLines() {
		return asString().readLines()
	}

	List<String> asElements(String separator = '') {
		if (separator) {
			return asString().trim().tokenize(separator)
		} else {
			return asString().trim().toList()
		}
	}
}
