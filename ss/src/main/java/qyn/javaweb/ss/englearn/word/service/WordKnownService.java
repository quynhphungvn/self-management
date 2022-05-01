package qyn.javaweb.ss.englearn.word.service;

import qyn.javaweb.ss.englearn.word.dao.WordKnownDAO;
import qyn.javaweb.ss.englearn.word.dto.WordKnownDTO;
import qyn.javaweb.ss.englearn.word.mapper.WordKnownMapper;
import qyn.javaweb.ss.util.Status;

public class WordKnownService {
	WordKnownMapper wordKnownMapper;
	public WordKnownService() {
		wordKnownMapper = new WordKnownMapper();
	}
	public Status addWordKnown(WordKnownDTO wordKnownDTO) {
		return WordKnownDAO.addWordKnown(wordKnownMapper.mapWordKnownDTOToWordKnown(wordKnownDTO));
	}
}
