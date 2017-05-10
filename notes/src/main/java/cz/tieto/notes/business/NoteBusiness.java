package cz.tieto.notes.business;

import java.util.List;

/**
 * Definition of business operations for notes
 * @author neugeeug
 *
 */

//FIXME Place annotation here
public interface NoteBusiness {

	/**
	 * Add new note to set
	 */
	void addNote(String n);
	
	/**
	 * Get all notes
	 * @return list of notes
	 */
	List<String> getAllNotes();
	
}
