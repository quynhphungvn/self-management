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
public class Group {
	private int id;
	private User user;
	private String name;
	private Type type;
}
