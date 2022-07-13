package quynh.java.sm.langlearning.english.service.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import quynh.java.sm.langlearning.english.dao.impl.VideoDaoImpl;
import quynh.java.sm.langlearning.english.dao.impl.GroupDaoImpl;
import quynh.java.sm.langlearning.english.dao.impl.WordDAO;
import quynh.java.sm.langlearning.english.model.Video;
import quynh.java.sm.langlearning.english.model.WordLearning;
import quynh.java.sm.support.app.util.WordProcessor;

public class VideoService {
	public VideoDaoImpl videoDAO = new VideoDaoImpl();
	public GroupDaoImpl videoGroupDAO = new GroupDaoImpl();
	public WordDAO wordDAO = new WordDAO();
	
	public Video addVideo(Connection conn, Video video) {
		Video videoAdded = null;
		boolean urlExisted = videoDAO.getVideoByUrl(video.getUrl(), video.getGroupId(), video.getUserId()) != null ? true : false;
		if (!urlExisted) {
			int result = videoDAO.addVideo(video);
			if (result == 1) {
				videoAdded = videoDAO.getVideoByUrl(video.getUrl(), video.getGroupId(), video.getUserId());
				if (video.getSubtitle().length() > 10) {
					processSubtitleToManageWord(conn, video.getSubtitle(), video.getUserId());
				}
			}
		}
		System.out.println("Add video done");
		return videoAdded;
	}
	public void processSubtitleToManageWord(Connection conn, String subtitle, int userId) {
		List<WordLearning> listWordKnown = wordDAO.getWordsKnown(conn, userId);
		List<WordLearning> listWordSub = distinctWordFromSubtitle(subtitle);
		
		for (WordLearning word : listWordSub) {
			WordLearning wordFound = findWordInListWordKnown(word, listWordKnown);
			if (wordFound != null)
			{
				wordDAO.updateAppearCount(conn, wordFound.getId(), word.getAppearCount(), userId);
			}
			else {
				wordDAO.addWordToManage(conn, word.getContent(), userId, false);
				int newWordId = wordDAO.getWordIdFromDictionaryByContent(conn, word.getContent());
				wordDAO.updateAppearCount(conn, newWordId, word.getAppearCount(), userId);
			}
		}
	}
	public List<WordLearning> distinctWordFromSubtitle(String subtitle) {
		List<WordLearning> listWordFromSub = new ArrayList<WordLearning>();
		List<String> listAllStringInSub = new ArrayList<String>();
		
		String[] subLines = subtitle.split("\n");
		for (int i = 0; i < subLines.length; i++) {
			if (i % 2 != 0) {
				String[] wordsInLine = subLines[i].split(" ");
				for (String s : wordsInLine) {
					listAllStringInSub.add(WordProcessor.removeUnexpectedChar(s));
				}
			}
		}
		for (String s : listAllStringInSub) {
			if (!checkWordInList(s, listWordFromSub)) {
				int count = countWordInSub(s, listAllStringInSub);
				WordLearning word = new WordLearning();
				word.setContent(s);
				word.setAppearCount(count);
				listWordFromSub.add(word);
			}
		}
		return listWordFromSub;
	}
	private int countWordInSub(String word, List<String> sub) {
		int result = 0;
		for (String s : sub) {
			if (word.equals(s)) {
				result = result + 1;
			}
		}
		return result;
	}
	private boolean checkWordInList(String word, List<WordLearning> listWords) {
		for (WordLearning temp : listWords)
			if (temp.getContent().equals(word))
				return true;
		return false;
	}
	private WordLearning findWordInListWordKnown(WordLearning word, List<WordLearning> listWordKnown) {
		for (WordLearning tempWord : listWordKnown) {
			if (tempWord.getContent().equals(word.getContent()))
				return tempWord;
		}
		return null;
	}
	public List<Video> getVideosByGroupId(int groupId, int userId) {
		return videoDAO.getVideosByGroupId(groupId, userId);
	}

	public Video getVideoById(int videoId, int userId) {
		return videoDAO.getVideoById(videoId, userId);
	}

	public int updateVideo(Video video) {
		return videoDAO.updateVideo(video);		
	}

	public int deleteVideo(int id) {
		return videoDAO.deleteVideoById(id);
	}
	public int updateVideoViewCount(int videoId, int userId) {
		return videoDAO.updateVideoViewCount(videoId, userId);
		
	}
}
