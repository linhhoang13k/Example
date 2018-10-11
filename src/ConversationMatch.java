package companyBots.Wizelinebot;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class ConversationMatch {

	/**
	 * @param conversations
	 * @param currentConversation
	 * @return
	 */
	public String[] chatBot(String[][] conversations, String[] currentConversation) {
		//
		Map<Integer, int[]> map = new LinkedHashMap<>();
		int i = 0;
		for (String[] conversation : conversations) {
			int[] countLastIndex = count(conversation, currentConversation);
			map.put(i, countLastIndex);
			i++;
		}
		Set<Integer> css = map.keySet();
		int cIndexMax = -1;
		int max = -1;
		int lastMatchingIndex = -1;
		for (Integer cs : css) {
			int[] value = map.get(cs);
			if (value[0]>0 && value[0] > max) {
				cIndexMax = cs;
				max = value[0];
				lastMatchingIndex = value[1];
			}
		}
		//
		if (cIndexMax >= 0) {
			String[] selectedConv = conversations[cIndexMax];
			String[] missingPart = Arrays.copyOfRange(selectedConv, lastMatchingIndex+1, selectedConv.length);
			String[] c = new String[(currentConversation.length + missingPart.length)];
			System.arraycopy(currentConversation, 0, c, 0, currentConversation.length);
			System.arraycopy(missingPart, 0, c, currentConversation.length, missingPart.length);
			return c;
		}
		return currentConversation;
	}

	/**
	 * @param conversation
	 * @param currentConversation
	 * @return
	 */
	private int[] count(String[] conversation, String[] currentConversation) { 
		 Map<String, Integer> map = new HashMap<>();
		 for(int i=0; i<conversation.length; i++) {
			 String cc = conversation[i];
			Integer value = map.get(cc);
			 if(value==null){
				 if(isPresent(currentConversation, cc)) {
					 map.put(cc,i);
				 }
			 } else {
				 map.put(cc,i);
		 }
		 }
		 Set<String> set = map.keySet();
		    int counter = set.size();
		    int max = -1;
		    for(int c : map.values()) {
		    	if(c>max) {
		    		max = c;
		    	}
		    }
		return new int[] {counter, max};
	}
	
	/** 
	 * @param currentConversation
	 * @param cc
	 * @return
	 */
	private boolean isPresent(String[] currentConversation, String cc) {
		for(String c : currentConversation) {
			 if(c.equals(cc)) {
				 return true;
			 }
		} 
		return false;
	}

//	/**
//	 * @param conversation
//	 * @param currentConversation
//	 * @return
//	 */
//	private int[] count(String[] conversation, String[] currentConversation) {
//		int counter = 0;
//		int lastMatchingIndex = -1;
//		for (String cc : currentConversation) {
//			int index = search(conversation, cc);
//			if (index >= 0) {
//				counter++;
//				if(index>=lastMatchingIndex) {
//					lastMatchingIndex = index;
//				}
//			}
//		}
//		return new int[] { counter, lastMatchingIndex };
//	}
	

	private int search(String[] conversation, String cc) {
		int index = -1;
		for(int i=0; i<conversation.length; i++) {
			if(conversation[i].equalsIgnoreCase(cc)){
				index = i;
			}
		}
		return index;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[][] conversations = { {"tonight","i","need","dollar","bills"}, 
				 {"i","dont","keep","fun"}, 
				 {"cheap","thrills","long","to","feel","money"}, 
				 {"the","bills","dont","need","the","dancing","baby"}, 
				 {"fun","dollar","dancing","thrills","the","baby","i","need"}, 
				 {"dont","have","fun"}, 
				 {"no","no","dont","have","dancing","fun","tonight"} };

		String[] currentConversation = { 
				 "the", 
				 };
		
		
		ConversationMatch cm = new ConversationMatch();
		String[] results = cm.chatBot(conversations, currentConversation);
		System.out.println(Arrays.toString(results));
	}

}
