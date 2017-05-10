package cz.tieto.notes.controllers;

import java.io.Serializable;
import java.util.List;

import cz.tieto.notes.business.NoteBusiness;

/**
 * 
 * Controller for notes operations, 
 * should use business classes for notes operations {@link cz.tieto.notes.business.NoteBusiness}
 * 
 * @author neugeeug
 *
 */

//FIXME place annotation here
public class NoteController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7007385942336707671L;
	
	//FIXME place annotation here
	private NoteBusiness noteBusiness;
	
	private String note;
	
	
	public String getNote() {
		return note;
	}
	
	public void setNote(String note) {
		this.note = note;
	}
	
	public void addNote() {
		noteBusiness.addNote(note);
	}
	
	public List<String> getAllNotes() {
		List<String> list = noteBusiness.getAllNotes();
		return list;
	}
	
}
