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
public class Video {
	private int id;
	private String title;
	private String url;
	private String subtitle;
	private Group group;
	private int viewCount;
}
