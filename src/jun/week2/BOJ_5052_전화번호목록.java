/*
 * 트라이라는걸 써야하나봄 트라이 공부해보고 풀어보자 
 */

package jun.week2;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class BOJ_5052_전화번호목록 {

	static class TrieNode {
		// 자식 노드 맵
		private Map<Character, TrieNode> childNodes = new HashMap<>();

		// 마지막 글자인지 여부
		private boolean isLastChar;

		Map<Character, TrieNode> getChildNodes() {
			return childNodes;
		}

		boolean getIsLastChar() {
			return isLastChar;
		}

		void setIsLastChar(boolean isLastChar) {
			this.isLastChar = isLastChar;
		}
	}

	static class Trie {
		private TrieNode rootNode;

		Trie() {
			rootNode = new TrieNode();
		}

		void insert(String word) {
			TrieNode thisNode = this.rootNode;
			for (int i = 0; i < word.length(); i++) {
				thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());
			}
			thisNode.setIsLastChar(true);
		}

		boolean available(String word) {
			TrieNode thisNode = this.rootNode;
			for (int i = 0; i < word.length(); i++) {
				char character = word.charAt(i);
				TrieNode node = thisNode.getChildNodes().get(character);
				if (thisNode.getIsLastChar())
					return false;
				thisNode = node;
			}
			return thisNode.getIsLastChar();
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int test = 0; test < T; test++) {
			boolean check = true;
			int n = Integer.parseInt(in.readLine());
			Trie trie = new Trie();
			String[] strs = new String[n];
			for(int i= 0 ;i < n; i++) {
				strs[i] = in.readLine();
				trie.insert(strs[i]);
			}
			
			for(int i = 0 ; i < n; i++) {
				if(!trie.available(strs[i])) {
					check = false;
					break;
				}
			}
			
			if(check)
				sb.append("YES").append("\n");
			else
				sb.append("NO").append("\n");
		}
		System.out.println(sb);

	}
}
