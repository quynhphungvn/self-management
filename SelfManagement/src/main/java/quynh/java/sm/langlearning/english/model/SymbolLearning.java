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
public class SymbolLearning {
	private int id;
	private Symbol symbol;
	private User user;
	private int viewCount;
}
