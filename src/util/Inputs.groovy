package util

import java.nio.file.Files
import java.nio.file.Path

class Inputs {
	static Input input1
	static Input input2

	static void load(Script script) {
		String baseDir = new File(script.getClass().protectionDomain.codeSource.location.path).parent
		Path input = Path.of(baseDir, "input.txt")
		if (Files.exists(input)) {
			String content = new String(input.readBytes())
			input1 = new Input(input: content)
			input2 = new Input(input: content)
		} else {
			input1 = new Input(input: new String(Path.of(baseDir, "input1.txt").readBytes()))
			input2 = new Input(input: new String(Path.of(baseDir, "input2.txt").readBytes()))
		}
	}
}
