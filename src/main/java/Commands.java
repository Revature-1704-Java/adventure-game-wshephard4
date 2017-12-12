

public class Commands extends CommandList {
	private String actionWord;
	private String commandWord;
	
	public Commands(String word1, String word2) {
		actionWord = word1;
		commandWord = word2;
	}
	
	public Commands() {
		// TODO Auto-generated constructor stub
	}

	public String getAction() {
		return actionWord;
	}
	
	public String getCommand() {
		return commandWord;
	}
	
	public boolean isUnknown() {
		return (actionWord == null);
	}
	
	public boolean hasCommand() {
		return (commandWord != null);
	}
}
