class Untitled {
	public static void main(String[] args) {
		int x = 55;
		System.out.println(Integer.toString(55));
		String test = "  hello   ";
		test = test.replace(" ", "");
		System.out.println(test);
		String s = "Hello";
		
		System.out.println(charInStringToLower("HELLOHHHH", 'H'));
		//System.out.println(trimifyLoop(test));
	}
	public static String trimify (String s) {
		if (s.equals("")) return "";
		if (s.charAt(0) == ' ' && s.charAt(s.length() - 1) == ' ') {
			return trimify(s.substring(1,s.length() - 1));
		}
		if (s.charAt(0) == ' ') return trimify(s.substring(1));
		if (s.charAt(s.length() - 1) == ' ') return trimify(s.substring(0,s.length() - 1));
		return s;
	}
	public static String trimifyLoop(String s) {
		if (s.equals("")) return s;
		int i = 0;
		while (s.charAt(i) == ' ') i++;
		int j = s.length() - 1;
		while (s.charAt(j) == ' ') j--;
		return s.substring(i,j+1);
	}
	public static String charInStringToLower (String s, char c) {
		c = Character.toUpperCase(c);
		String rv = "";
		for (int i = 0; i < s.length(); i++) {
			char toAdd;
			if (s.charAt(i) == c) {
				toAdd = Character.toLowerCase(s.charAt(i));
			}
			else toAdd = s.charAt(i);
			rv += toAdd;
		}
		return rv;
	}
}