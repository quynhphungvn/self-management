package qyn.javaweb.ss.englearn.word.service;

import java.util.List;

import qyn.javaweb.ss.englearn.word.dao.WordKnownDAO;
import qyn.javaweb.ss.englearn.word.dto.WordKnownDTO;
import qyn.javaweb.ss.englearn.word.mapper.WordKnownMapper;

public class WordService {
	WordKnownMapper wordKnownMapper;
	
	public WordService() {
		wordKnownMapper = new WordKnownMapper();
	}
	
	public List<WordKnownDTO> getAllWordKnown() {
		return wordKnownMapper.mapListWordKnownToListWordKnownDTO(WordKnownDAO.getAllWordKnown());
	}
}
