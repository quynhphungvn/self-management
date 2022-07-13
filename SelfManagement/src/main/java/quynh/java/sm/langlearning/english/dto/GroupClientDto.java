package quynh.java.sm.langlearning.english.dto;

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
public class GroupClientDto {
	private String name;
	private String typeName;
	private int userId;
}
