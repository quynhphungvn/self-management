package qyn.javaweb.ss.englearn.word.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import qyn.javaweb.ss.englearn.word.dto.WordKnownDTO;
import qyn.javaweb.ss.englearn.word.model.Word;
import qyn.javaweb.ss.englearn.word.model.WordKnown;

public class WordKnownMapper {
	ModelMapper modelMapper;
	public WordKnownMapper() {
		super();
		modelMapper = new ModelMapper();
	}
	public WordKnownDTO mapWordKnownToWordKnownDTO(WordKnown word) {
		modelMapper.typeMap(WordKnown.class, WordKnownDTO.class).addMappings(mapper -> {
			mapper.map(src -> src.getWord().getWord(), WordKnownDTO::setWord);
		});
		return modelMapper.map(word, WordKnownDTO.class);
	}
	public List<WordKnownDTO> mapListWordKnownToListWordKnownDTO(List<WordKnown> lWordKnown) {
		List<WordKnownDTO> lWordKnownDTO = new ArrayList<WordKnownDTO>();
		lWordKnown.forEach(wordKnown -> lWordKnownDTO.add(mapWordKnownToWordKnownDTO(wordKnown)));
		return lWordKnownDTO;
	}
	public WordKnown mapWordKnownDTOToWordKnown(WordKnownDTO wordKnownDTO) {
		WordKnown wordKnown = new WordKnown();
		Word word = new Word();
		word.setWord(wordKnownDTO.getWord());
		wordKnown.setWord(word);
		return wordKnown;
	}
}
