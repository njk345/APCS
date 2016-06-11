class Untitled {
	public static void main(String[] args) {
		System.out.println(reformatDate("mm/dd/yyyy"));
		System.out.println(scroll("hello"));
		System.out.println(convertName("keirstead, nick"));
	}
	public static String reformatDate(String date) {
		if (date.length() != 10) return null;
		return date.substring(0,2) + "-" + date.substring(3,5) + "-" + date.substring(6);
	}
	public static String scroll(String s) {
		return s.substring(1) + s.substring(0,1);
	}
	public static String convertName(String n) {
		String[] rv = n.split(",", 2);
		rv[1] = rv[1].trim();
		return rv[1] + " " + rv[0];
	}
}