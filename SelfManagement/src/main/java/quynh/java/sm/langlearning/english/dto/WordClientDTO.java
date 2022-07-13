package quynh.java.sm.langlearning.english.dto;

public class WordClientDTO {
	private int id;
	private String content;
	private int userId;
	private boolean knownState;
	
	public WordClientDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WordClientDTO(int id, String content, int userId, boolean knownState) {
		super();
		this.id = id;
		this.content = content;
		this.userId = userId;
		this.knownState = knownState;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public boolean getKnownState() {
		return knownState;
	}
	public void setKnownState(boolean knownState) {
		this.knownState = knownState;
	}
}
