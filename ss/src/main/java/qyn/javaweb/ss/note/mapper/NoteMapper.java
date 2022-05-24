package qyn.javaweb.ss.note.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import qyn.javaweb.ss.note.dto.NoteDTO;
import qyn.javaweb.ss.note.dto.NoteTypeDTO;
import qyn.javaweb.ss.note.dto.PriorityDTO;
import qyn.javaweb.ss.note.model.Note;
import qyn.javaweb.ss.note.model.NoteType;
import qyn.javaweb.ss.note.model.Priority;

public class NoteMapper {
	ModelMapper modelMapper;
	public NoteMapper() {
		super();
		modelMapper = new ModelMapper();
	}
	public List<PriorityDTO> mapListPriorityToListPriorityDTO(List<Priority> lPriority) {
		  List<PriorityDTO> lPriorityDTO = new ArrayList<PriorityDTO>(); for (int i =
		  0; i < lPriority.size(); i++) {
		  lPriorityDTO.add(this.mapPriorityToPriorityDTO(lPriority.get(i))); }
		  return lPriorityDTO;	 
	}
	public PriorityDTO mapPriorityToPriorityDTO(Priority priority) {
		modelMapper.typeMap(Priority.class, PriorityDTO.class).addMappings(mapper -> {
			  mapper.map(src -> src.getPriorityId(),
			      PriorityDTO::setPriorityId);
			  mapper.map(src -> src.getPriorityLevel(),
			      PriorityDTO::setPriorityLevel);
			  mapper.map(src -> src.getPriorityColor(),
				  PriorityDTO::setPriorityColor);
		});
		return modelMapper.map(priority, PriorityDTO.class);
	}
	public List<NoteTypeDTO> mapListNoteTypeToListNoteTypeDTO(List<NoteType> lNoteType) {
		List<NoteTypeDTO> lNoteTypeDTO = new ArrayList<NoteTypeDTO>();
		for (int i = 0; i < lNoteType.size(); i++)
			lNoteTypeDTO.add(this.mapNoteTypeToNoteTypeDTO(lNoteType.get(i)));
		return lNoteTypeDTO;
	}
	public NoteTypeDTO mapNoteTypeToNoteTypeDTO(NoteType noteType) {
		modelMapper.typeMap(NoteType.class, NoteTypeDTO.class).addMappings(mapper -> {
			  mapper.map(src -> src.getNoteTypeId(),
			      NoteTypeDTO::setNoteTypeId);
			  mapper.map(src -> src.getNoteTypeType(),
			      NoteTypeDTO::setNoteTypeType);
		});
		return modelMapper.map(noteType, NoteTypeDTO.class);
	}
	public List<NoteDTO> mapListNoteToListNoteDTO(List<Note> lNote) {
		List<NoteDTO> lNoteDTO = new ArrayList<NoteDTO>();
		for (int i = 0; i < lNote.size(); i++) {
			lNoteDTO.add(this.mapNoteToNoteDTO(lNote.get(i)));
		}
		return lNoteDTO;
	}
	public NoteDTO mapNoteToNoteDTO(Note note) {
		modelMapper.typeMap(Note.class, NoteDTO.class).addMappings(mapper -> {
			mapper.map(src -> src.getNoteId(), NoteDTO::setNoteId);
			mapper.map(src -> src.getNoteContent(), NoteDTO::setNoteContent);
			mapper.map(src -> src.getNoteComment(), NoteDTO::setNoteComment);
			mapper.map(src -> src.getNoteTimeAdded(), NoteDTO::setNoteTimeAdded);
			mapper.map(src -> src.getNotePriority(), NoteDTO::setNotePriority);
			mapper.map(src -> src.getNoteType(), NoteDTO::setNoteType);
		});
		return modelMapper.map(note, NoteDTO.class);
	}
}
