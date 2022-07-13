package quynh.java.sm.langlearning.english.mapper;

import quynh.java.sm.langlearning.english.dto.SymbolDto;
import quynh.java.sm.langlearning.english.model.SymbolLearning;

public class SymbolMapper {
	public SymbolDto convertSymbolLearningToSymbolDTO(SymbolLearning symbol) {
		SymbolDto symbolDTO = new SymbolDto();
		symbolDTO.setContent(symbol.getSymbol().getContent());
		symbolDTO.setExample(symbol.getSymbol().getExample());
		symbolDTO.setExamplePhonetic(symbol.getSymbol().getExamplePhonetic());
		symbolDTO.setImgGuideURL(symbol.getSymbol().getImgGuideURL());
		symbolDTO.setVideoGuideURL(symbol.getSymbol().getVideoGuideURL());
		symbolDTO.setViewCount(symbol.getViewCount());
		return symbolDTO;
	}
}
