

import java.io.IOException;

public class Game {

	private Parser parser;
	private Room currentRoom;
	
	public static void main(String[] args) throws IOException {
		Game game = new Game();
		game.start();
	}

	public Game() throws IOException {
		
		createRooms();
		parser = new Parser();
	}
	
	private void createRooms(){
		currentRoom = new Room("");
		String description = currentRoom.getRoom("Rooms.txt", "empty room -");
		Room emptyRoom = new Room(description);
		
		description = currentRoom.getRoom("Rooms.txt", "closet -");
		Room closet = new Room(description);
		
		description = currentRoom.getRoom("Rooms.txt", "basement -");
		Room basement = new Room(description);
		
		emptyRoom.setExits("closet", closet);
		emptyRoom.setExits("basement", basement);
		closet.setExits("None", null);
		basement.setExits("empty", emptyRoom);
		
		currentRoom = emptyRoom;
	}
	
	public void start() {
		System.out.println("You awaken in a strange place. You can not remember"
				+ " what happened or how you got here.");
		if(currentRoom.getDescription() == null){
		}
		else System.out.println(currentRoom.getDescription());
		
		boolean death = false;
		
		while(!death) {
			if(checkDeath()){
				death = true;
				System.out.println("You have died! GAME OVER");
				break;
			}
			Commands command = parser.getCommand();
			death = completeCommand(command);
		}
		System.out.println("Thanks for playing! Now go outside and have a real adventure.");
	}
	
	private boolean completeCommand(Commands command) {
		boolean endIt = false;
		
		if(command.isUnknown()) {
			System.out.println("Please enter a vslid command.");
			return false;
		}
		
		String action = command.getAction();
		if(action.equals("help")) {
			displayHelp();
		}
		else if (action.equals("go")) {
			enterRoom(command);
		}
		else if(action.equals("quit")) {
			endIt = quit(command);
		}
		
		return endIt;
	}
	
	private void displayHelp() {
		System.out.println("Valid commands: \n");
		parser.showCommands();
	}
	
	private void enterRoom(Commands command) {
		if(!command.hasCommand()) {
			System.out.println("Where would you like to go?");
			return;			
		}
		
		String direction = command.getCommand();
		
		Room nextRoom = currentRoom.getExit(direction);
		
		if(nextRoom == null) {
			System.out.println("There is nothing there!");
		}
		else {
			currentRoom = nextRoom;
			System.out.println(currentRoom.getDescription());
		}
	}
	
	private boolean checkDeath() {
		if(currentRoom.getDescription().contains("DEATH")) {
			return true;			
		}
		return false;
	}
	
	private boolean quit(Commands command) {
		if(command.hasCommand()) {
			System.out.println("What would you like to quit?");
			return false;
		}
		else {
			return true;
		}
	}
}
