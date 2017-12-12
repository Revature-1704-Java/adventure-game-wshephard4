

public abstract class CommandList {
	private String[] validCommands = { "go", "quit", "help" };
	
	public boolean checkCommand(String str) {
		for(int i = 0; i < validCommands.length; i++) {
			if(validCommands[i].equals(str)){
				return true;
			}
		}
		return false;
	}
	
	public void showCommands() {
		for(String command: validCommands) {
			System.out.print(command + " ");
		}
		System.out.println();
	}
}
