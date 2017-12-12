import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class MavenTest {
	String temp = "Test";
	Commands command = new Commands();
	Room room = new Room(temp);
	
	@Test
	public void  getDescriptionTest(){
		assertTrue(room.getDescription() != null );
	}
	
	@Test
	public void getRoomTest(){
		assertTrue(room.getRoom("Rooms.txt", "empty") != null);
	}
	
	@Test
	public void checkCommandTest(){
		assertTrue(command.checkCommand("go"));
	}
}
