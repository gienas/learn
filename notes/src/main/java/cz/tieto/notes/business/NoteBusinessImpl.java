package cz.tieto.notes.business;

import java.util.List;

import cz.tieto.notes.dao.NoteDao;

/**
 * Implementation of business logic for notes operation. 
 * Class should use Dao for persistence operations {@link cz.tieto.notes.dao.NoteDao} 
 * @author neugeeug
 *
 */
//FIXME place annotation here
public class NoteBusinessImpl implements NoteBusiness {

	//FIXME place annotation here
	private NoteDao noteDao;
	
	@Override
	public void addNote(String n) {
		noteDao.add(n);
	}

	@Override
	public List<String> getAllNotes() {
		return noteDao.getAll();
	}
	

}
