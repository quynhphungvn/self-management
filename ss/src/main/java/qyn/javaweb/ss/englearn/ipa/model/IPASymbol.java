package qyn.javaweb.ss.englearn.ipa.model;

public class IPASymbol {
	private int id;
	private String symbol;
	private String example;
	private String examplePhonetic;
	private String imgGuideLink;
	private String videoGuideLink;
	private String ipaType;
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
	public String getImgGuideLink() {
		return imgGuideLink;
	}
	public void setImgGuideLink(String imgGuideLink) {
		this.imgGuideLink = imgGuideLink;
	}
	public String getVideoGuideLink() {
		return videoGuideLink;
	}
	public void setVideoGuideLink(String videoGuideLink) {
		this.videoGuideLink = videoGuideLink;
	}
	public String getIpaType() {
		return ipaType;
	}
	public void setIpaType(String ipaType) {
		this.ipaType = ipaType;
	}
}
