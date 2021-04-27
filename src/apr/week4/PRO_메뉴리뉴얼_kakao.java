package apr.week4;

import java.util.*;

class PRO_메뉴리뉴얼_kakao {
	static HashMap<String, Integer> map;
	static ArrayList<String> check;
	static int max;

	public String[] solution(String[] orders, int[] course) {
		ArrayList<String> answer = new ArrayList<>();
		map = new HashMap<String, Integer>();
		for (int i = 0; i < orders.length; i++) {
			char[] menus = orders[i].toCharArray();
			Arrays.sort(menus);

			for (int j = 0; j < course.length; j++) {
				check = new ArrayList<>();
				max = 0;
				for (int idx = 0; idx < menus.length - 1; idx++) {
					dfs(menus, idx, 1, course[j], "" + menus[idx]);
				}

			}
		}

		ArrayList<String>[] list = new ArrayList[11];
		for (int i = 0; i < 11; i++)
			list[i] = new ArrayList<>();

		int[] maxs = new int[11];
		for (String key : map.keySet()) {
			int value = map.get(key);
			int len = key.length();

			if (value < 2)
				continue;

			if (list[len].isEmpty() || map.get(list[len].get(0)) == value) {
				list[len].add(key);
			} else if (map.get(list[len].get(0)) < value) {
				list[len] = new ArrayList<>();
				list[len].add(key);
			}
			Collections.sort(list[value]);
		}

		for (int i = 0; i < list.length; i++) {
			for (String str : list[i])
				answer.add(str);
		}

		int len = answer.size();
		String[] ans = new String[len];

		answer.toArray(ans);
		Arrays.sort(ans);
		return ans;
	}

	void dfs(char[] menus, int idx, int cnt, int kind, String tmp) {

		if (cnt == kind) {
			map.put(tmp, map.getOrDefault(tmp, 0) + 1);
		}

		for (int i = idx + 1; i < menus.length; i++)
			dfs(menus, i, cnt + 1, kind, tmp + menus[i]);
	}
}