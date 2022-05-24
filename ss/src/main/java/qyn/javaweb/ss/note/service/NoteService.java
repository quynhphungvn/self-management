package qyn.javaweb.ss.note.service;

import java.util.List;

import qyn.javaweb.ss.note.dao.NoteDAO;
import qyn.javaweb.ss.note.dao.NoteTypeDAO;
import qyn.javaweb.ss.note.dao.PriorityDAO;
import qyn.javaweb.ss.note.dto.NoteClientDTO;
import qyn.javaweb.ss.note.dto.NoteDTO;
import qyn.javaweb.ss.note.dto.NoteTypeDTO;
import qyn.javaweb.ss.note.dto.PriorityDTO;
import qyn.javaweb.ss.note.mapper.NoteMapper;
import qyn.javaweb.ss.util.Status;

public class NoteService {
	NoteMapper mapper = new NoteMapper();
	public Status addNote(NoteClientDTO noteClientDTO) {
		return NoteDAO.addNote(noteClientDTO);
	}
	public Status deleteNoteById(int id) {
		return NoteDAO.deleteNoteById(id);
	}
	public List<NoteDTO> getAllNoteDTO() {
		return mapper.mapListNoteToListNoteDTO(NoteDAO.getAllNote());	
	}
	public List<PriorityDTO> getAllPriorityDTO() {
		return mapper.mapListPriorityToListPriorityDTO(PriorityDAO.getAllPriority());
	}
	public List<NoteTypeDTO> getAllNoteTypeDTO() {
		return mapper.mapListNoteTypeToListNoteTypeDTO(NoteTypeDAO.getAllNoteType());
	}
}
