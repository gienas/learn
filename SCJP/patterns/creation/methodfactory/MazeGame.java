package creation.methodfactory;

import java.util.HashSet;
import java.util.Set;

interface Room {
	public void connect(Room r);
}

class MagicRoom implements Room {

	@Override
	public void connect(Room r) {
		// TODO Auto-generated method stub

	}
}

class OrdinaryRoom implements Room {

	@Override
	public void connect(Room r) {
		// TODO Auto-generated method stub

	}
}

public abstract class MazeGame {
	Set<Room> rooms = new HashSet<>();
	public MazeGame() {
		Room room1 = makeRoom();
		Room room2 = makeRoom();
		this.addRoom(room1);
		this.addRoom(room2);
		room1.connect(room2);

	}

	private void addRoom(Room r) {
		// TODO Auto-generated method stub
		rooms.add(r);
	}

	/*********************/
	abstract protected Room makeRoom();
}

class MagicMazeGame extends MazeGame {
	@Override
	protected Room makeRoom() {
		return new MagicRoom();
	}
}

class OrdinaryMazeGame extends MazeGame {
	@Override
	protected Room makeRoom() {
		return new OrdinaryRoom();
	}
}
