package qyn.javaweb.ss.note.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import qyn.javaweb.ss.note.dto.PriorityDTO;
import qyn.javaweb.ss.note.model.Priority;

public class NoteMapperTest {
	private NoteMapper mapper;

	@BeforeEach
	public void setup() {
	    this.mapper = new NoteMapper();
	}

	@Test
	public void whenMapPriorityToPriorityDTO_thenReturnPriorityDTOShouldBeExpected() {
	    Priority priority = new Priority();
	    priority.setPriorityId(1);
	    priority.setPriorityLevel("hell");
	    priority.setPriorityColor("#333");
	    PriorityDTO pr = mapper.mapPriorityToPriorityDTO(priority);
	    assertEquals(pr.getPriorityId(), priority.getPriorityId());
	    assertEquals(pr.getPriorityColor(), priority.getPriorityColor());
	}
}
