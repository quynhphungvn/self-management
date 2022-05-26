package quynh.java.sm.langlearning.english.ipa.mapper;

import quynh.java.sm.langlearning.english.ipa.dto.IPASymbolDTO;
import quynh.java.sm.langlearning.english.ipa.model.IPASymbol;

public class IPAMapper {
	public IPASymbolDTO convertIPASymbolToIPASymbolDTO(IPASymbol ipaSymbol) {
		IPASymbolDTO ipaSymbolDTO = new IPASymbolDTO();
		ipaSymbolDTO.setSymbol(ipaSymbol.getSymbol());
		ipaSymbolDTO.setExample(ipaSymbol.getExample());
		ipaSymbolDTO.setExamplePhonetic(ipaSymbol.getExamplePhonetic());
		ipaSymbolDTO.setImgGuideURL(ipaSymbol.getImgGuideURL());
		ipaSymbolDTO.setVideoGuideURL(ipaSymbol.getVideoGuideURL());
		ipaSymbolDTO.setViewCount(ipaSymbol.getViewCount());
		return ipaSymbolDTO;
	}
}
