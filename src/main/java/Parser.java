

import java.util.Scanner;

public class Parser {
	private CommandList commands;
	private Scanner sc;
	
	public Parser() {
		commands = new Commands();
		sc = new Scanner(System.in);
	}
	
	public Commands getCommand() {
		String input;
		String firstWord = null;
		String secondWord = null;
		
		System.out.println("What would you like to do?: ");
		input = sc.nextLine();
		
		Scanner tokenizer = new Scanner(input);
		if(tokenizer.hasNext()) {
			firstWord = tokenizer.next();
			if(tokenizer.hasNext()) {
				secondWord = tokenizer.next();
			}
		}
		tokenizer.close();
		
		if(commands.checkCommand(firstWord)) {
			return new Commands(firstWord, secondWord);
		} else {
			return new Commands(null, secondWord);
		}
	}
	
	public void showCommands() {
		commands.showCommands();
	}
}
