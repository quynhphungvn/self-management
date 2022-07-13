package quynh.java.sm.langlearning.english.dto;

public class SymbolDto {
	private String content;
	private String example;
	private String examplePhonetic;
	private String imgGuideURL;
	private String videoGuideURL;
	private int viewCount;
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
