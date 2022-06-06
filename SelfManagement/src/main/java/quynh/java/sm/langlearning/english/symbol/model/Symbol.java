package quynh.java.sm.langlearning.english.symbol.model;

public class Symbol {
	private int id;
	private String symbol;
	private String example;
	private String examplePhonetic;
	private String imgGuideURL;
	private String videoGuideURL;
	private String type;
	private int userId;
	private int viewCount;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
}
