package quynh.java.sm.langlearning.english.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Symbol {
	private int id;
	private String content;
	private String example;
	private String examplePhonetic;
	private String imgGuideURL;
	private String videoGuideURL;
	private Type type;
}
