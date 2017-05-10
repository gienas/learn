package cz.tieto.notes.dao;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import cz.tieto.notes.cache.NoteCache;

/**
 * Dao for notes, should persist notes in cache
 * {@link cz.tieto.notes.cache.NoteCache}
 * 
 * @author neugeeug
 *
 */
// FIXME place operation here
public class NoteDao implements BaseDao<String> {

	// FIXME place operation here
	private NoteCache cache;

	public void add(String t) {
		cache.addNote(t);
	}

	@Override
	public List<String> getAll() {
		return cache.getAll();
	}

}
