package cz.tieto.notes.cache;

import java.util.ArrayList;
import java.util.List;

/**
 * Store for notes. 
 * All application clients should use the same store instance. 
 * 
 * @author neugeeug
 *
 */
//FIXME place annotation here
public class NoteCache {

	private List<String> notes;

	//FIXME place annotation here
	public void initData() {
		notes = new ArrayList<>();
		//place to read notes e.g from file
	}

	//FIXME place annotation here
	public void saveData() {
		//place to save notes e.g to file
	}
	
	/**
	 * Add new note
	 * @param note
	 */
	public void addNote(String note) {
		notes.add(note);
	}
	
	/**
	 * Get all notes
	 */
	public List<String> getAll() {
		return notes;
	}
	
}
