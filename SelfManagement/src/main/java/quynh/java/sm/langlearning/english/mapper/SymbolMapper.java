package quynh.java.sm.langlearning.english.mapper;

import quynh.java.sm.langlearning.english.dto.SymbolDTO;
import quynh.java.sm.langlearning.english.model.Symbol;

public class SymbolMapper {
	public SymbolDTO convertSymbolToSymbolDTO(Symbol ipaSymbol) {
		SymbolDTO ipaSymbolDTO = new SymbolDTO();
		ipaSymbolDTO.setSymbol(ipaSymbol.getSymbol());
		ipaSymbolDTO.setExample(ipaSymbol.getExample());
		ipaSymbolDTO.setExamplePhonetic(ipaSymbol.getExamplePhonetic());
		ipaSymbolDTO.setImgGuideURL(ipaSymbol.getImgGuideURL());
		ipaSymbolDTO.setVideoGuideURL(ipaSymbol.getVideoGuideURL());
		ipaSymbolDTO.setViewCount(ipaSymbol.getViewCount());
		return ipaSymbolDTO;
	}
}
