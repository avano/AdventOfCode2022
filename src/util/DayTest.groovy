package util

abstract class DayTest {
	protected Script script = loadScript()
	protected Input input = loadInput()

	private Script loadScript() {
		script = new GroovyShell().parse(new File("src/" + this.getClass().getCanonicalName().replace('.', '/') - 'Test' + '.groovy'))
	}

	private Input loadInput() {
		input = new Input(input: input())
	}

	abstract String input()
}
