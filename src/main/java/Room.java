

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Room {
	private String description;
	private HashMap<String, Room> exits;
	
	public Room(String str) {
		description = str;
		exits = new HashMap<>();
	}
	
	public void setExits(String direction, Room nextRoom) {
		exits.put(direction, nextRoom);
	}
	
	public String getDescription() {
		return description + getExitDescription();
	}
	
	private String getExitDescription() {
		String exitString = "\nExits: ";
		Set<String> keys = exits.keySet();
		
		for(String exit : keys) {
			exitString += " " + exit;
		}
		return exitString;
	}
	
	public Room getExit(String direction) {
		return exits.get(direction);
	}
	
	public String getRoom(String filename, String roomName) {
		Scanner file = null;
		String line = null;
		try {
			file = new Scanner(new File(filename));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		while(file.hasNext()){
			 line = file.nextLine();
		
		String temp = roomName.toString();
        if(line.indexOf(roomName) != -1) {
        	line = line.replace(temp.toString(), "");//("\\W" + temp + "-\\W|^" + temp + " -\\W|\\W" + temp + " -$", "");
        	line = line.replace("-", "");
        	line = line.substring(1);
        	break;
        }
		}
        file.close();
        
        return line;
    }
}
