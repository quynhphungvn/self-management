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
public class WordLearning {
	private int id;
	private boolean knownState;
	private int appearCount;
	private Word word;
	private User user;
}
