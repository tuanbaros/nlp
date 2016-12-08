package app.nlp.features.check;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class Rules1 {

//	/**
//	 * ====================================================================
//	 * ======================= QUAN - CHECK VOWEL =====================
//	 * ====================================================================
//	 */
//
	static int count = 0;

	RuleVowel ruleVowel = new RuleVowel();
//	public HashMap<Integer, String> track;
//	public String vowel = "aăâeêioôơuưy";
	public String consonants = "bcdđghklmnpqrstvx";
//	public String finalConsonant = "chmngpt";
//	public String[] doubleVowel = {
//			"ai", "ao", "au", "âu", "ay", "ây",
//			"eo", "êu", "ia", "iê", "yê", "iu",
//			"oa", "oă", "oe", "oi", "ôi", "ơi",
//			"oo", "ôô", "ua", "uă", "uâ", "ưa",
//			"uê", "ui", "ưi", "uô", "uơ",
//			"ươ", "ưu", "uy"
//	};
//	public String[] tripleVowel = {
//			"iêu", "yêu", "oai", "oao", "oay",
//			"oeo", "uao", "uây", "uôi", "ươi",
//			"ươu", "uya", "uyê", "uyu"
//	};
//
//	// Vowel type 1
//	public String[] vowelAnyPosition = {"oa", "oe", "uê", "uy"};
//
//	// Vowel type 2
//	public String[] vowelForceFinalConsonant = {"ă", "oă", "oo", "ôô", "uă", "uyê"};
//
//	// Vowel type 3
//	public String[] vowelForceFinalLetter = {"â", "iê", "uâ", "uô", "ươ", "yê"};
//
//	public Rules1() {
//
//	}
//
//	/**
//	 * Loai bo dau trong tieng viet
//	 * @param alias
//	 * @return string without accent
//	 */
//	public static String removeAccent(String alias )
//	{
//	    String str = alias;
//	    str = str.toLowerCase();
//	    str = str.replaceAll("[àáạảã]", "a");
//	    str = str.replaceAll("[ằắặẳẵ]", "ă");
//	    str = str.replaceAll("[ầấậẩẫ]", "â");
//	    str = str.replaceAll("[èéẹẻẽ]", "e");
//	    str = str.replaceAll("[ềếệểễ]", "ê");
//	    str = str.replaceAll("[ìíịỉĩ]", "i");
//	    str = str.replaceAll("[òóọỏõ]", "o");
//	    str = str.replaceAll("[ồốộổỗ]", "ô");
//	    str = str.replaceAll("[ờớợởỡ]", "ơ");
//	    str = str.replaceAll("[ùúụủũ]", "u");
//	    str = str.replaceAll("[ừứựửữ]", "ư");
//	    str = str.replaceAll("[ỳýỵỷỹ]", "y");
//	    return str;
//	}
//
//	/**
//	 * Kiem tra xem tu x co nguyen am khong
//	 * @param x
//	 * @return integer
//	 */
//	public int checkVowel(String x) {
//		int count = 0;
//		x = x.toLowerCase();
//
//		for (int i = 0; i < x.length(); i++) {
//			if (vowel.contains(String.valueOf(x.charAt(i)))) {
//				count++;
//			}
//		}
//		if (count > 0) {
//			return count;
//		}
//		return 0;
//	}
//
//	/**
//	 * Kiem tra xem tu x co nguyen am doi hop le khong
//	 * @param x
//	 * @return
//	 */
//	public HashMap<Integer, String> checkDoubleTripleVowel(String x) {
//		x = removeAccent(x);
//		track = new HashMap<>();
//		int vowelNum = checkVowel(x);
//
//		if (vowelNum == 2) {
//			for (int i = 0; i < doubleVowel.length; i++) {
//				if (x.contains(doubleVowel[i])) {
//					track.put(Integer.valueOf(i), doubleVowel[i]);
//					break;
//				}
//			}
//			return track;
//		}
//
//		if (vowelNum == 3) {
//			for (int i = 0; i < tripleVowel.length; i++) {
//				if (x.contains(tripleVowel[i])) {
//					track.put(Integer.valueOf(i), tripleVowel[i]);
//					break;
//				}
//			}
//			return track;
//		}
//
//		if (vowelNum == 1) {
//			for (int i = 0; i < x.length(); i++) {
//				if (vowel.contains(String.valueOf(x.charAt(i)))) {
//					track.put(Integer.valueOf(i), String.valueOf(x.charAt(i)));
//					break;
//				}
//			}
//			return track;
//		}
//		return null;
//	}
//
//	/**
//	 * Kiem tra nguyen am bat buoc co phu am o cuoi
//	 * @param x
//	 * @return
//	 */
//	public boolean checkVowelFinalConsonant(String x) {
//		x = removeAccent(x);
//		HashMap<Integer, String> mVowel = checkDoubleTripleVowel(x);
//
//		if (mVowel != null && mVowel.size() > 0) {
//			Set<Entry<Integer, String>> mapSet = mVowel.entrySet();
//			Iterator<Entry<Integer, String>> mapIterator = mapSet.iterator();
//
//			while (mapIterator.hasNext()) {
//				Entry<Integer, String> mapEntry = mapIterator.next();
//
//				int start;
//				int size = mapEntry.getValue().length() - 1;
//
//				// Kiem tra vowel type
//				if (checkVowelType(mapEntry.getValue()) == 1) {
//
//					for (start = mapEntry.getKey() + size; start < x.length(); start++) {
//						if (finalConsonant.contains(String.valueOf(x.charAt(start)))) {
//							return true;
//						}
//					}
//				} else return true;
//			}
//		}
//		return false;
//	}
//
//	/**
//	 * Kiem tra sau nguyen am bat buoc phai co nguyen am hay phu am
//	 * @param x
//	 * @return
//	 */
//	public boolean checkVowelForceFinalLetter(String x) {
//		x = removeAccent(x);
//		HashMap<Integer, String> mVowel = checkDoubleTripleVowel(x);
//
//		if (mVowel != null && mVowel.size() > 0) {
//			Set<Entry<Integer, String>> mapSet = mVowel.entrySet();
//			Iterator<Entry<Integer, String>> mapIterator = mapSet.iterator();
//
//			while (mapIterator.hasNext()) {
//				Entry<Integer, String> mapEntry = mapIterator.next();
//
//				int start;
//				int size = mapEntry.getValue().length() - 1;
//
//				// Kiem tra vowel type
//				if (checkVowelType(mapEntry.getValue()) == 2) {
//
//					for (start = mapEntry.getKey() + size; start < x.length(); start++) {
//						if (finalConsonant.contains(String.valueOf(x.charAt(start)))
//								|| vowel.contains(String.valueOf(x.charAt(start)))) {
//							return true;
//						}
//					}
//				} else return true;
//			}
//		}
//		return false;
//	}
//
//	/**
//	 * Kiem tra xem x thuoc loai nguyen am nao
//	 * @param x
//	 * @return
//	 */
//	public int checkVowelType(String x) {
//		try {
//			for (int i = 0;; i++) {
//
//				if (i < vowelForceFinalConsonant.length &&
//						vowelForceFinalConsonant[i] == x) {
//					return 1;
//				}
//
//				if (i < vowelForceFinalLetter.length &&
//						vowelForceFinalLetter[i] == x) {
//					return 2;
//				}
//			}
//		} catch (Exception e) {
//			e.getStackTrace();
//			return 0;
//		}
//	}
	
	
	/**
	 * ====================================================================
	 * ======================= TOAN - CHECK CONSONANT =====================
	 * ====================================================================
	 */

	// Bo thanh dau trong tieng viet
	public static String removeAccent(String alias )
	{
		String str = alias;
		str = str.toLowerCase();
		str = str.replaceAll("[àáạảã]", "a");
		str = str.replaceAll("[ằắặẳẵ]", "ă");
		str = str.replaceAll("[ầấậẩẫ]", "â");
		str = str.replaceAll("[èéẹẻẽ]", "e");
		str = str.replaceAll("[ềếệểễ]", "ê");
		str = str.replaceAll("[ìíịỉĩ]", "i");
		str = str.replaceAll("[òóọỏõ]", "o");
		str = str.replaceAll("[ồốộổỗ]", "ô");
		str = str.replaceAll("[ờớợởỡ]", "ơ");
		str = str.replaceAll("[ùúụủũ]", "u");
		str = str.replaceAll("[ừứựửữ]", "ư");
		str = str.replaceAll("[ỳýỵỷỹ]", "y");
		return str;
	}

	// Kiem tra a
	public boolean checkA(String x) {
		x.toLowerCase().trim();
		String vowelA = "aáàạã";
		String[] nonFirstConsonantA = {"gh", "k", "ngh", "q"};
		String[] consonantA = {"c", "ch", "i", "m", "n", "ng", "nh", "o", "p", "t", "u", "y"};
		int count = 0;
		String temp = "";

		for (int i = 0; i < x.length(); i ++) {
			if (vowelA.contains(String.valueOf(x.charAt(i)))) {
				count++;
				temp = String.valueOf(x.charAt(i));
			}
		}
		if (count == 1) {
			String sub = x.substring(0, x.indexOf(temp));
			if (sub.equals(nonFirstConsonantA[0]) || sub.equals(nonFirstConsonantA[1])
					|| sub.equals(nonFirstConsonantA[2]) || sub.equals(nonFirstConsonantA[3])) {
				return false;
			}
			String last = x.substring(x.indexOf(temp) + 1, x.length());

			if (temp.equals("a") || temp.equals("à")) {
				if (consonantA[0].equals(last) || consonantA[1].equals(last) ||
						consonantA[8].equals(last) || consonantA[9].equals(last)) {
					return false;
				}
			}
			if (temp.equals("ã")) {
				if (consonantA[0].equals(last) || consonantA[8].equals(last) ||
						consonantA[9].equals(last)) {
					return false;
				}
			}
			for (int j = 0; j < consonantA.length; j++) {
				if (consonantA[j].contains(last)) {
					return true;
				}
			}
			return false;
		} else if (count > 2) {
			return false;
		}
		return true;
	}

	// check ă
	public boolean checkAW(String x) {
		x.toLowerCase().trim();
		String vowelAW = "ăắặẵ";
		String[] nonFirstConsonantAW = {"gh", "k", "ngh", "q"};
		String[] consonantAW = {"c", "m", "n", "ng", "p", "t"};
		int count = 0;
		String temp = "";

		for (int i = 0; i < x.length(); i ++) {
			if (vowelAW.contains(String.valueOf(x.charAt(i)))) {
				count++;
				temp = String.valueOf(x.charAt(i));
			}
		}
		if (count == 1) {
			String sub = x.substring(0, x.indexOf(temp));
			if (sub.equals(nonFirstConsonantAW[0]) || sub.equals(nonFirstConsonantAW[1])
					|| sub.equals(nonFirstConsonantAW[2]) || sub.equals(nonFirstConsonantAW[3])) {
				return false;
			}
			String last = x.substring(x.indexOf(temp) + 1, x.length());

			if (temp.equals("ă") || temp.equals("ẵ")) {
				if (consonantAW[0].equals(last) || consonantAW[4].equals(last) ||
						consonantAW[5].equals(last)) {
					return false;
				}
			}

			for (int j = 0; j < consonantAW.length; j++) {
				if (consonantAW[j].contains(last)) {
					return true;
				}
			}
			return false;
		} else if (count > 2) {
			return false;
		}
		return true;
	}

	// check â
	public boolean checkAA(String x) {
		x.toLowerCase().trim();
		String vowelAA = "âấậầẫ";
		String[] nonFirstConsonantAA = {"gh", "k", "ngh", "q"};
		String[] consonantAA = {"c", "m", "n", "ng", "p", "t", "u", "y"};
		int count = 0;
		String temp = "";

		for (int i = 0; i < x.length(); i ++) {
			if (vowelAA.contains(String.valueOf(x.charAt(i)))) {
				count++;
				temp = String.valueOf(x.charAt(i));
			}
		}
		if (count == 1) {
			String sub = x.substring(0, x.indexOf(temp));
			if (sub.equals(nonFirstConsonantAA[0]) || sub.equals(nonFirstConsonantAA[1])
					|| sub.equals(nonFirstConsonantAA[2]) || sub.equals(nonFirstConsonantAA[3])) {
				return false;
			}
			String last = x.substring(x.indexOf(temp) + 1, x.length());

			if (temp.equals("â") || temp.equals("ẫ") || temp.equals("ầ")) {
				if (consonantAA[0].equals(last) || consonantAA[4].equals(last) ||
						consonantAA[5].equals(last)) {
					return false;
				}
			}

			for (int j = 0; j < consonantAA.length; j++) {
				if (consonantAA[j].contains(last)) {
					return true;
				}
			}
			return false;
		} else if (count > 2) {
			return false;
		}
		return true;
	}

	// Kiem tra e
	public boolean checkE(String x) {
		x.toLowerCase().trim();
		String vowelE = "eèéẹ";
		String[] nonFirstConsonantE = {"c", "g", "ng", "q"};
		String[] consonantLastE = {"c", "ch", "m", "n", "ng", "o", "p", "t"};
		int count = 0;
		String temp = "";

		for (int i = 0; i < x.length(); i ++) {
			if (vowelE.contains(String.valueOf(x.charAt(i)))) {
				count++;
				temp = String.valueOf(x.charAt(i));
			}
		}
		if (count == 1) {
			String sub = x.substring(0, x.indexOf(temp));
			if (sub.equals(nonFirstConsonantE[0]) || sub.equals(nonFirstConsonantE[1])
					|| sub.equals(nonFirstConsonantE[2]) || sub.equals(nonFirstConsonantE[3])) {
				return false;
			}
			String last = x.substring(x.indexOf(temp) + 1, x.length());

			if (temp.equals("e") || temp.equals("è") || temp.equals("ẹ")) {
				if (consonantLastE[0].equals(last) || consonantLastE[1].equals(last) ||
						consonantLastE[6].equals(last) || consonantLastE[7].equals(last)) {
					return false;
				}
			}

			for (int j = 0; j < consonantLastE.length; j++) {
				if (consonantLastE[j].contains(last)) {
					return true;
				}
			}
			return false;
		} else if (count > 2) {
			return false;
		}
		return true;
	}

	// Check ê
	public boolean checkEE(String x) {
		x.toLowerCase().trim();
		String vowelEE = "êềệếễ";
		String[] nonFirstConsonantEE = {"c", "g", "ng", "q"};
		String[] consonantLastEE = {"ch", "m", "n", "nh", "p", "t", "u"};
		int count = 0;
		String temp = "";

		for (int i = 0; i < x.length(); i ++) {
			if (vowelEE.contains(String.valueOf(x.charAt(i)))) {
				count++;
				temp = String.valueOf(x.charAt(i));
			}
		}
		if (count == 1) {
			String sub = x.substring(0, x.indexOf(temp));
			if (sub.equals(nonFirstConsonantEE[0]) || sub.equals(nonFirstConsonantEE[1])
					|| sub.equals(nonFirstConsonantEE[2]) || sub.equals(nonFirstConsonantEE[3])) {
				return false;
			}
			String last = x.substring(x.indexOf(temp) + 1, x.length());

			if (temp.equals("ê") || temp.equals("ề") || temp.equals("ệ")) {
				if (consonantLastEE[0].equals(last) || consonantLastEE[4].equals(last) ||
						consonantLastEE[5].equals(last)) {
					return false;
				}
			}

			for (int j = 0; j < consonantLastEE.length; j++) {
				if (consonantLastEE[j].contains(last)) {
					return true;
				}
			}
			return false;
		} else if (count > 2) {
			return false;
		}
		return true;
	}
	// Kiem tra i
	public boolean checkI(String x) {
		x.toLowerCase().trim();
		String vowelE = "iíịìĩ";
		String[] nonFirstConsonantI = {"c","ng", "q", "qu"};
		String[] consonantLastI = {"a", "êc", "êm", "ên", "êng", "êp", "êu",
				"êt", "ch", "m", "n", "nh", "p", "t", "u"};
		int count = 0;
		String temp = "";

		for (int i = 0; i < x.length(); i ++) {
			if (vowelE.contains(String.valueOf(x.charAt(i)))) {
				count++;
				temp = String.valueOf(x.charAt(i));
			}
		}
		if (count == 1) {
			String sub = x.substring(0, x.indexOf(temp));
			if (sub.equals(nonFirstConsonantI[0]) || sub.equals(nonFirstConsonantI[1])
					|| sub.equals(nonFirstConsonantI[2]) || sub.equals(nonFirstConsonantI[3])) {
				return false;
			}
			String last = x.substring(x.indexOf(temp) + 1, x.length());

			last = removeAccent(last);

			if (temp.equals("i") || temp.equals("ì") || temp.equals("ĩ")) {
				if (consonantLastI[8].equals(last) || consonantLastI[12].equals(last) ||
						consonantLastI[13].equals(last)) {
					return false;
				}
			}
			if (temp.equals("ì") || temp.equals("í") || temp.equals("ĩ") || temp.equals("ị")) {
				if (consonantLastI[1].equals(last) || consonantLastI[2].equals(last) ||
						consonantLastI[3].equals(last) || consonantLastI[4].equals(last) ||
						consonantLastI[5].equals(last) || consonantLastI[6].equals(last) ||
						consonantLastI[7].equals(last)) {
					return false;
				}
			}
			for (int j = 0; j < consonantLastI.length; j++) {
				if (consonantLastI[j].contains(last)) {
					return true;
				}
			}
			return false;
		} else if (count > 2) {
			return false;
		}
		return true;
	}

	// Check o
	public boolean checkO(String x) {
		x.toLowerCase().trim();
		String vowelO = "oóọòõ";
		String[] nonFirstConsonantO = {"gh", "k", "ngh", "q"};
		String[] consonantLastO = {"a", "ac", "ăc", "ach", "ai", "am", "ăm", "an", "ăn",
				"ang", "ăng", "anh", "ao", "ap", "at", "ăt", "ay", "c"};
		int count = 0;
		String temp = "";

		for (int i = 0; i < x.length(); i ++) {
			if (vowelO.contains(String.valueOf(x.charAt(i)))) {
				count++;
				temp = String.valueOf(x.charAt(i));
			}
		}
		if (count == 1) {
			String sub = x.substring(0, x.indexOf(temp));
			if (sub.equals(nonFirstConsonantO[0]) || sub.equals(nonFirstConsonantO[1])
					|| sub.equals(nonFirstConsonantO[2]) || sub.equals(nonFirstConsonantO[3])) {
				return false;
			}
			String last = x.substring(x.indexOf(temp) + 1, x.length());
			last = removeAccent(last);

			if (temp.equals("o") || temp.equals("ò") || temp.equals("õ")) {
				if (consonantLastO[1].equals(last) || consonantLastO[2].equals(last) ||
						consonantLastO[13].equals(last) || consonantLastO[14].equals(last) ||
						consonantLastO[15].equals(last) || consonantLastO[16].equals(last)) {
					return false;
				}
			}

			for (int j = 0; j < consonantLastO.length; j++) {
				if (consonantLastO[j].contains(last)) {
					return true;
				}
			}
			return false;
		} else if (count == 2) {
			if ("o".equals(x.charAt(x.indexOf('o') + 1))) {
				return false;
			} else return true;
		}
		return true;
	}

	// Check oo
	public boolean checkOO(String x) {
		x.toLowerCase().trim();
		String vowelOO = "ôồốỗộ";
		String[] nonFirstConsonantOO = {"gh", "k", "ngh", "q"};
		String[] consonantLastOO = {"c", "i", "m", "n", "ng", "ôc", "ông", "p", "t"};
		int count = 0;
		String temp = "";

		for (int i = 0; i < x.length(); i ++) {
			if (vowelOO.contains(String.valueOf(x.charAt(i)))) {
				count++;
				temp = String.valueOf(x.charAt(i));
			}
		}
		if (count == 1) {
			String sub = x.substring(0, x.indexOf(temp));
			if (sub.equals(nonFirstConsonantOO[0]) || sub.equals(nonFirstConsonantOO[1])
					|| sub.equals(nonFirstConsonantOO[2]) || sub.equals(nonFirstConsonantOO[3])) {
				return false;
			}
			String last = x.substring(x.indexOf(temp) + 1, x.length());
			last = removeAccent(last);

			if (temp.equals("ô") || temp.equals("ồ") || temp.equals("ỗ")) {
				if (consonantLastOO[0].equals(last) || consonantLastOO[7].equals(last) ||
						consonantLastOO[8].equals(last)) {
					return false;
				}
			}

			for (int j = 0; j < consonantLastOO.length; j++) {
				if (consonantLastOO[j].contains(last)) {
					return true;
				}
			}
			return false;
		} else if (count > 2) {
			return false;
		}
		return true;
	}

	public boolean checkOW(String x) {
		x.toLowerCase().trim();
		String vowelOW = "ơớờợỡ";
		String[] nonFirstConsonantOW = {"gh", "k", "ngh", "q"};
		String[] consonantLastOW = {"c", "i", "m", "n", "ng", "p", "t"};
		int count = 0;
		String temp = "";

		for (int i = 0; i < x.length(); i ++) {
			if (vowelOW.contains(String.valueOf(x.charAt(i)))) {
				count++;
				temp = String.valueOf(x.charAt(i));
			}
		}
		if (count == 1) {
			String sub = x.substring(0, x.indexOf(temp));
			if (sub.equals(nonFirstConsonantOW[0]) || sub.equals(nonFirstConsonantOW[1])
					|| sub.equals(nonFirstConsonantOW[2]) || sub.equals(nonFirstConsonantOW[3])) {
				return false;
			}
			String last = x.substring(x.indexOf(temp) + 1, x.length());
			last = removeAccent(last);

			if (temp.equals("ơ") || temp.equals("ờ") || temp.equals("ỡ")) {
				if (consonantLastOW[0].equals(last) || consonantLastOW[5].equals(last) ||
						consonantLastOW[6].equals(last)) {
					return false;
				}
			}

			for (int j = 0; j < consonantLastOW.length; j++) {
				if (consonantLastOW[j].contains(last)) {
					return true;
				}
			}
			return false;
		} else if (count > 2) {
			return false;
		}
		return true;
	}

	// check u
	public boolean checkU(String x) {
		x.toLowerCase().trim();
		String vowelU = "uúùũụ";
		String[] nonFirstConsonantU = {"k", "ngh", "gh"};
		String[] consonantLastU = {"a", "âc", "âm", "ân", "ât", "ây", "c", "ê",
				"ên", "ênh", "êt", "i", "m", "n", "ng", "ơ", "ôc", "ôi", "ôm",
				"ôn", "ông", "ôt", "p", "t", "y", "ya", "ych", "yên", "yêt", "yn",
				"ynh", "yp", "yu"};
		int count = 0;
		String temp = "";

		for (int i = 0; i < x.length(); i ++) {
			if (vowelU.contains(String.valueOf(x.charAt(i)))) {
				count++;
				temp = String.valueOf(x.charAt(i));
			}
		}
		if (count == 1) {
			String sub = x.substring(0, x.indexOf(temp));
			if (sub.equals(nonFirstConsonantU[0]) || sub.equals(nonFirstConsonantU[1])
					|| sub.equals(nonFirstConsonantU[2])) {
				return false;
			}
			String last = x.substring(x.indexOf(temp) + 1, x.length());
			last = removeAccent(last);

			if (temp.equals("ú") || temp.equals("ù") || temp.equals("ũ") || temp.equals("ụ")) {
				if (consonantLastU[0].equals(last) || consonantLastU[11].equals(last) ||
						consonantLastU[12].equals(last) || consonantLastU[13].equals(last)) {
					return true;
				}
			}

			if (temp.equals("ù") || temp.equals("u") || temp.endsWith("ũ")) {
				if (consonantLastU[22].equals(last) || consonantLastU[23].equals(last)) {
					return false;
				}
			}

			for (int j = 0; j < consonantLastU.length; j++) {
				if (consonantLastU[j].contains(last)) {
					return true;
				}
			}
			return false;
		} else if (count > 2) {
			return false;
		}
		return true;
	}

	// check ư
	public boolean checkUW(String x) {
		x.toLowerCase().trim();
		String vowelUW = "ưứừựữ";
		String[] nonFirstConsonantUW = {"k", "ngh", "gh"};
		String[] consonantLastUW = {"a", "c", "i", "m", "n", "ng", "ơc", "ơi", "ơm",
				"ơn", "ơng", "ơp", "ơt", "ơu", "t", "u"};
		int count = 0;
		String temp = "";

		for (int i = 0; i < x.length(); i ++) {
			if (vowelUW.contains(String.valueOf(x.charAt(i)))) {
				count++;
				temp = String.valueOf(x.charAt(i));
			}
		}
		if (count == 1) {
			String sub = x.substring(0, x.indexOf(temp));
			if (sub.equals(nonFirstConsonantUW[0]) || sub.equals(nonFirstConsonantUW[1])
					|| sub.equals(nonFirstConsonantUW[2])) {
				return false;
			}
			String last = x.substring(x.indexOf(temp) + 1, x.length());
			last = removeAccent(last);
			for (int j = 0; j < consonantLastUW.length; j++) {
				if (consonantLastUW[j].contains(last)) {
					return true;
				}
			}
			return false;
		} else if (count > 2) {
			return false;
		}
		return true;
	}

	// check y
	public boolean checkY(String x) {
		x.toLowerCase().trim();
		String vowelY = "y";
		String[] firstConsonantY = {"k", "h", "l", "m", "n", "qu", "t", "th", "s", "v"};
		String[] consonantLastY = {"êm", "ên", "êng", "êt", "êu"};
		int count = 0;

		for (int i = 0; i < x.length(); i ++) {
			if (vowelY.contains(String.valueOf(x.charAt(i)))) {
				count++;
			}
		}
		if (count == 1) {
			String sub = x.substring(0, x.indexOf('y'));
			for (int s = 0; s < firstConsonantY.length; s++) {
				if (!firstConsonantY[s].equals(sub)) {
					return false;
				}
			}
			String last = x.substring(x.indexOf('y') + 1, x.length());
			last = removeAccent(last);
			for (int j = 0; j < consonantLastY.length; j++) {
				if (consonantLastY[j].contains(last)) {
					return true;
				}
			}
			return false;
		}
		if (count > 2) {
			return false;
		}
		return true;
	}

	public boolean checkVowelTotal(String x) {
		if (!checkA(x) || !checkAW(x) || !checkAA(x) || !checkE(x)
				|| !checkEE(x) || !checkI(x) || !checkO(x) || !checkOO(x) || !checkOW(x)
				|| !checkU(x) || !checkUW(x) || !checkY(x)) {
			return false;
		}
		return true;
	}
	
	
	// tu tieng viet sai neu co ky tu dac biet
	public boolean checkInvalid0(String x) {
		String kiTuDacBiet = "0123456789fwjz~`!@#$%^&*()-_=+[{}]|;:'<>?/";
		for (int i = 0; i < x.length(); i++) {
			if (kiTuDacBiet.contains(String.valueOf(x.charAt(i)))) {
				return true;
			}
		}
		return false;
	}

	public boolean checkInvalid1(String x) {
		if (x.length() > 7) {
			return true;
		} else
			return false;
	}

	//co it nhat 1 nguyen am
	public boolean checkInValid2(String x) {
		x.toLowerCase();
		for (int i = 0; i < x.length(); i++) {
			if (consonants.contains(String.valueOf(x.charAt(i)))) {
				count++;
			}
		}
		if (count == x.length()) {
			System.out.println("sai luat 2");
			return true;
		}

		return false;
	}
	//co 2 nguyen am tro len thi 2 nguyen am phai canh nhau
	public boolean checkInvalid3(String x) {

		for (int i = 0; i < x.length(); i++) {
			int temp = 0;
			if (!consonants.contains(String.valueOf(x.charAt(i)))) {
				temp = i;
				for (int j = i + 1; j < x.length(); j++) {
					if (!consonants.contains(String.valueOf(x.charAt(j)))) {
						temp++;
						if (j - temp > 0) {
							System.out.println("sai luat 3");
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	//tu tieng viet co toi da 3 nguyen am
	public boolean checkInvalid4(String x) {

		int temp = x.length();
		for (int i = 0; i < x.length(); i++) {
			if (consonants.contains(String.valueOf(x.charAt(i))))
				temp--;
		}
		if (temp > 3 || (temp == 3 &&
				consonants.contains(String.valueOf(x.charAt(x.length() - 1))))) {
			System.out.println("sai luat 4");
			return true;
		} else
			return false;
	}
	//	 tu tieng viet ko cho phep 2 chu cai giong nhau canh nhau (tru oo)
	public boolean checkInvalid5(String x) {
//		x.toLowerCase();
		for (int i = 0; i < x.length() - 1; i++) {
			if ((x.charAt(i) == x.charAt(i + 1)) && (x.charAt(i) != 'o')) {
				System.out.println("sai luat 5");
				return true;
			}
		}
		return false;
	}

	
	// nhung phu am chi co the dung dau
	public boolean checkInvalid6(String x) {
		String phuAmDau = "qsdklxvb";
		for (int i = 1; i < x.length(); i++) {
			if (phuAmDau.contains(String.valueOf(x.charAt(i)))) {
				return true;
			}
		}
		return false;
	}

	/* check phu am */
	// khong cho phep 3 phu am canh nhau tru ngh

	public boolean checkInvalid7(String x) {
		if (x.length() > 3) {
			for (int i = 0; i < x.length() - 2; i++) {
				if (consonants.contains(String.valueOf(x.charAt(i))) && (consonants.contains(String.valueOf(x.charAt(i + 1))))
						&& consonants.contains(String.valueOf(x.charAt(i + 2))) && ((x.charAt(i) != 'n')
						|| x.charAt(i + 1) != 'g' || x.charAt(i + 2) != 'h')) {
					return true;
				}
			}
		}
		return false;
	}

	// check h
	public boolean checkH(String x) {
		String apterH = "ngcktp";
		boolean c=true;
		if (x.contains("h")) {
			if(x.charAt(0)=='h'){
				if(consonants.contains(String.valueOf(x.charAt(1)))){
					c=false;
				}
			}
			if(x.charAt(x.length()-1)=='h'){
				if((x.charAt(x.length()-2)!='n')&&(x.charAt(x.length()-2)!='c')){
					c=false;
				}
			}
			if(x.charAt(1)=='h'){
				if(!apterH.contains(String.valueOf(x.charAt(0)))){
					c=false;
				}
			}
//			if(x.length()>3&&x.charAt(2)=='h'){
//				if((x.charAt(0)!='n')||(x.charAt(1)!='h')){
//					c=false;
//				}
//			}
		}
		return c;
	}

	// check p
	public boolean checkP(String x) {
		String nguyenAm = "áạặắấậéẹếệíịóọốộớợúụứự";
		// if(!x.contains("p"))
		// return true;
		if(x.contains("p")){
		if (x.charAt(x.length() - 1) == 'p' && !(nguyenAm.contains(String.valueOf(x.charAt(x.length() - 2))))) {
			return false;
		}
		if (x.charAt(0) == 'p' && x.charAt(1) != 'h') {
			return false;
		}
		}
		return true;
	}
	
	
	//check c
	public boolean checkC(String x){
		String tempC=consonants;
		String nguyenAmSau = "iíìịỉĩeéèẹẻẽêếềệểễ";
		String nguyenAmTruoc = "áạặắấậéẹếệíịóọốộớợúụứự";
		if(x.contains("c")){
			if(x.charAt(0)=='c'&&(nguyenAmSau.contains(String.valueOf(x.charAt(1)))
					||tempC.replace('h', 'c').contains(String.valueOf(x.charAt(1))))){
				return false;
			}
			if (x.charAt(x.length() - 1) == 'c' && !(nguyenAmTruoc.contains(String.valueOf(x.charAt(x.length() - 2))))) {
				return false;
			}
			return true;
		}
		
		return true;
	}
	//check q
	public boolean checkQ(String x){
		if(x.length()>2&&x.contains("q")){
			if(x.charAt(0)=='q'){
				if(x.charAt(1)!='u'){
					return false;
				}else if(consonants.contains(String.valueOf(x.charAt(2)))){
					return false;
				}	
			}
			 return true;
		}
		return true;
	}

	//check r
	public boolean checkR(String x){
		if(x.contains("r")){
			if(x.charAt(0)=='r'){
				if(consonants.contains(String.valueOf(x.charAt(1)))){
					return false;
				}else return true;
			}else if(x.charAt(1)=='r'){
				if(x.charAt(0)!='t'){
					return false;
				}else return true;
			}
			else{
				return false;
			}
		}
		return true;
	}
	
	public boolean checkT(String x) {
		String nguyenAm = "ếệắáạặấậéẹíịóọốộớợúụýỵuứự";
		String temp = consonants;
		try {
			if (x.contains("t")) {
				if (x.charAt(0) == 't' && temp.replace('h', 't').replace('r', 't').contains(String.valueOf(x.charAt(1)))) {
					return false;
				} else if (x.charAt(x.length() - 1) == 't'
						&& !(nguyenAm.contains(String.valueOf(x.charAt(x.length() - 2))))) {
					return false;
				} else
					return true;
			}
		} catch (Exception e){

		}
		return true;
	}

	public boolean checkN(String x) {
		String temp = consonants;
		if (x.contains("n")) {
			if (x.charAt(0) != 'n' && x.charAt(x.length() - 1) != 'n' && x.charAt(x.length() - 2) != 'n') {
				return false;
			}
			if (x.charAt(x.length() - 1) == 'n' && consonants.contains(String.valueOf(x.charAt(x.length() - 2)))) {
				return false;
			} else if ((x.charAt(0) == 'n' && (x.charAt(1) != 'g' && x.charAt(1) != 'h'
					&& temp.replace('g', 'n').replace('h', 'n').contains(String.valueOf(x.charAt(1)))))) {
				return false;
			} else if ((x.charAt(x.length() - 2) == 'n'
					&& (x.charAt(x.length() - 1) != 'g' && x.charAt(x.length() - 1) != 'h'
							&& temp.replace('g', 'n').replace('h', 'n').contains(String.valueOf(x.charAt(1)))))) {
				return false;
			} else
				return true;

		}
		return true;
	}

	// check k

	public boolean checkK(String x) {
		String nguyenam = "iíìịỉĩeéèẹẻẽêếềệểễyýỳỵỷỹ";
		if (x.contains("k")) {
			if (x.charAt(0) == 'k' && (x.charAt(1) == 'h' || nguyenam.contains(String.valueOf(x.charAt(1)))))
				return true;
			else {
				return false;
			}
		}
		return true;
	}

	// check g
	public boolean checkG(String x) {
		String nguyenam = "iíìịỉĩeéèẹẻẽêếềệểễ";
		String tempG = consonants;
		boolean c = true;
		if (x.contains("g")) {
			if (x.charAt(0) == 'g') {
				if (x.charAt(1) == 'h' && x.length() > 2) {
					if (nguyenam.contains(String.valueOf(x.charAt(2))))
						c = true;
					else {
						c = false;
					}
				}
				if (tempG.replace('h', 'g').contains(String.valueOf(x.charAt(1)))) {
					c = false;
				}
			}
			if (x.charAt(x.length() - 1) == 'g') {
				if (x.charAt(x.length() - 2) != 'n') {
					c = false;
				}
			}
		}

		return c;
	}

	//check s
	
	public boolean checkS(String x){
		if(x.contains("s")){
			if(x.charAt(0)=='s'){
				if(!consonants.contains(String.valueOf(x.charAt(1))))
					return true;
				else {
					return false;
				}
			}else{
				return false;
			}
		}
		return true;
	}
	
	//kiem tra x
	public boolean checkX(String x){
		if(x.contains("x")){
			if(x.charAt(0)=='x'){
				if(!consonants.contains(String.valueOf(x.charAt(1))))
					return true;
				else {
					return false;
				}
			}else{
				return false;
			}
		}
		return true;
	}
	
	//kiem tra m
	public boolean checkM(String x){
		if(x.contains("m")){
			if(x.charAt(0)=='m'){
				if(!consonants.contains(String.valueOf(x.charAt(1))))
					return true;
				else {
					return false;
				}
			}else if(x.charAt(x.length()-1)=='m'){
				if(!consonants.contains(String.valueOf(x.length()-2)))
					return true;
				else{
					return false;
				}
			}
			else{
				return false;
			}
		}
		return true;
	}
	
	//kiem tra b
	
	public boolean checkB(String x){
		try {
			if(x.contains("b")){
				if(x.charAt(0)=='b'){
					if(!consonants.contains(String.valueOf(x.charAt(1))))
						return true;
					else {
						return false;
					}
				}else{
					return false;
				}
			}

		} catch (Exception e) {

		}
		return true;
	}
	
	
	//check D
	public boolean checkD(String x){
		if(x.contains("d")){
			if(x.charAt(0)=='d'){
				if(!consonants.contains(String.valueOf(x.charAt(1))))
					return true;
				else {
					return false;
				}
			}else{
				return false;
			}
		}
		return true;
	}
	
	
	//check D
	public boolean checkĐ(String x){
		try {
			if (x.contains("đ")) {
				if (x.charAt(0) == 'đ') {
					if (!consonants.contains(String.valueOf(x.charAt(1))))
						return true;
					else {
						return false;
					}
				} else {
					return false;
				}
			}
		}catch(Exception e) {

		}
		return true;
	}
	
	//check L
	public boolean checkL(String x){
		if(x.contains("l")){
			if(x.charAt(0)=='l'){
				if(!consonants.contains(String.valueOf(x.charAt(1))))
					return true;
				else {
					return false;
				}
			}else{
				return false;
			}
		}
		return true;
	}
	//check V
	public boolean checkV(String x){
		if(x.contains("v")){
			if(x.charAt(0)=='v'){
				if(!consonants.contains(String.valueOf(x.charAt(1))))
					return true;
				else {
					return false;
				}
			} else {
				return false;
			}
		}
		return true;
	}
	
	public boolean check(String x) {
		x = x.trim().toLowerCase();

		if (checkInvalid0(x) ||checkInvalid1(x)  ||checkInvalid6(x) || checkInvalid7(x) ||
				(!checkS(x))||(!checkX(x))||(!checkD(x))||(!checkĐ(x))||(!checkL(x))||(!checkV(x))||
				(!checkB(x))||(!checkM(x))||(!checkQ(x))||(!checkR(x))||(!checkC(x))||(!checkH(x))||
				(!checkP(x))|| (!checkT(x)) || (!checkN(x))||(!checkG(x))||(!checkK(x))) {

				return false;

		}


		return true;
	}
	}


