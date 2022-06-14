package quynh.java.sm.langlearning.english.dto;

public class SymbolDTO {
	private String symbol;
	private String example;
	private String examplePhonetic;
	private String imgGuideURL;
	private String videoGuideURL;
	private int viewCount;
	
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getExample() {
		return example;
	}
	public void setExample(String example) {
		this.example = example;
	}
	public String getExamplePhonetic() {
		return examplePhonetic;
	}
	public void setExamplePhonetic(String examplePhonetic) {
		this.examplePhonetic = examplePhonetic;
	}
	public String getImgGuideURL() {
		return imgGuideURL;
	}
	public void setImgGuideURL(String imgGuideURL) {
		this.imgGuideURL = imgGuideURL;
	}
	public String getVideoGuideURL() {
		return videoGuideURL;
	}
	public void setVideoGuideURL(String videoGuideURL) {
		this.videoGuideURL = videoGuideURL;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
}
