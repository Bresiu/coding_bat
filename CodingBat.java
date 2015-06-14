import java.util.*;

/**
 * @author Michal Brewczak
 */
public class CodingBat {
	public static void main(String[] args) {
		CodingBat codingBat = new CodingBat();
/*
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++) {
			codingBat.achangePi("xpix");
		}
		System.out.println(System.currentTimeMillis() - startTime);
		*/
		System.out.println(codingBat.split53(new int[]{2, 4, 2}));
	}

	public boolean split53(int[] nums) {
		return split53Helper(0, nums, 0, 0);
	}

	private boolean split53Helper(int index, int[] nums, int firstSum, int secondSum) {
		if (index >= nums.length) return firstSum == secondSum;

		int value = nums[index];

		if (value % 5 == 0) {
			firstSum += value;
			return split53Helper(index + 1, nums, firstSum, secondSum);
		} else if (value % 3 == 0) {
			secondSum += value;
			return split53Helper(index + 1, nums, firstSum, secondSum);
		} else {
			return split53Helper(index + 1, nums, firstSum + value, secondSum) ||
					split53Helper(index + 1, nums, firstSum, secondSum + value);
		}
	}

	public boolean splitOdd10(int[] nums) {
		return splitOdd10Helper(0, nums, 0, 0);
	}

	private boolean splitOdd10Helper(int index, int[] nums, int firstSum, int secondSum) {
		if (index >= nums.length) return firstSum % 10 == 0 && secondSum % 2 != 0;

		return splitOdd10Helper(index + 1, nums, firstSum + nums[index], secondSum) ||
				splitOdd10Helper(index + 1, nums, firstSum, secondSum + nums[index]);
	}

	public boolean splitArray(int[] nums) {
		return splitArrayHelper(0, nums, 0, 0);
	}

	private boolean splitArrayHelper(int index, int[] nums, int firstSum, int secondSum) {
		if (index >= nums.length) return firstSum == secondSum;

		return splitArrayHelper(index + 1, nums, firstSum + nums[index], secondSum) ||
				splitArrayHelper(index + 1, nums, firstSum, secondSum + nums[index]);
	}

	public boolean groupSumClump(int start, int[] nums, int target) {
		if (start >= nums.length) return target == 0;
		int count = 1;
		int tmp = nums[start];
		for (int i = start + 1; i < nums.length; i++)
			if (nums[i] == nums[start]) {
				tmp += nums[i];
				count++;
			}

		return groupSumClump(start + count, nums, target - tmp) || groupSumClump(start + count, nums, target);
	}

	public boolean groupSum5(int start, int[] nums, int target) {
		if (start >= nums.length) return target == 0;
		if (nums[start] % 5 == 0 && start != nums.length - 1)
			return nums[start + 1] == 1 ? groupSum5(start + 2, nums, target - nums[start]) : groupSum5(start + 1, nums, target - nums[start]);
		return groupSum5(start + 1, nums, target - nums[start]) || groupSum5(start + 1, nums, target);
	}

	public boolean groupNoAdj(int start, int[] nums, int target) {
		if (start >= nums.length) return target == 0;
		return groupNoAdj(start + 2, nums, target - nums[start]) || groupNoAdj(start + 1, nums, target);
	}

	public boolean groupSum6(int start, int[] nums, int target) {
		if (start >= nums.length) return target == 0;
		if (nums[start] == 6) return groupSum6(start + 1, nums, target - 6);
		return groupSum6(start + 1, nums, target - nums[start]) || groupSum6(start + 1, nums, target);
	}

	public boolean groupSum(int start, int[] nums, int target) {
		if (start >= nums.length) return target == 0;
		return groupSum(start + 1, nums, target - nums[start]) || groupSum(start + 1, nums, target);
	}

	public int strDist(String str, String sub) {
		if (str.length() < 1) {
			return 0;
		} else if (!str.startsWith(sub)) {
			return strDist(str.substring(1), sub);
		} else if (!str.endsWith(sub)) {
			return strDist(str.substring(0, str.length() - 1), sub);
		} else {
			return str.length();
		}
	}

	public boolean strCopies(String str, String sub, int n) {
		if (n == 0) {
			return true;
		} else if (str.length() < sub.length()) {
			return false;
		} else if (str.startsWith(sub)) {
			return strCopies(str.substring(1), sub, --n);
		} else {
			return strCopies(str.substring(1), sub, n);
		}
	}

	public int strCount(String str, String sub) {
		if (str.length() < sub.length()) {
			return 0;
		} else if (str.startsWith(sub)) {
			return 1 + strCount(str.substring(sub.length()), sub);
		} else {
			return strCount(str.substring(1), sub);
		}
	}

	public boolean nestParen(String str) {
		if (str.length() == 0)
			return true;
		else if (str.length() == 1)
			return str.charAt(0) != ')' && str.charAt(0) != '(';
		else
			return str.charAt(0) == '(' && str.charAt(str.length() - 1) == ')' && nestParen(str.substring(1, str.length() - 1));
	}

	public String parenBit(String str) {
		if (str.length() < 2) {
			return "";
		} else if (str.charAt(0) != '(') {
			return parenBit(str.substring(1));
		} else if (str.charAt(str.length() - 1) != ')') {
			return parenBit(str.substring(0, str.length() - 1));
		} else {
			return str;
		}
	}

	public int countHi2(String str) {
		if (str.length() < 2) {
			return 0;
		} else if (str.startsWith("hi")) {
			return 1 + countHi2(str.substring(2));
		} else if (str.startsWith("xhi")) {
			return countHi2(str.substring(3));
		} else {
			return countHi2(str.substring(1));
		}
	}

	public String stringClean(String str) {
		return str.length() <= 1 ? str : str.charAt(0) == str.charAt(1) ? stringClean(str.substring(1)) : str.charAt(0) + stringClean(str.substring(1));
	}

	public int count11(String str) {
		return str.length() <= 1 ? 0 : (str.startsWith("11") ? 1 + count11(str.substring(2)) : count11(str.substring(1)));
	}

	public int countAbc(String str) {
		return str.length() <= 2 ? 0 : (str.startsWith("abc") || str.startsWith("aba") ? 1 + countAbc(str.substring(2)) : countAbc(str.substring(1)));
	}

	public int countPairs(String str) {
		return str.length() <= 2 ? 0 : (str.charAt(0) == str.charAt(2) ? 1 + countPairs(str.substring(1)) : countPairs(str.substring(1)));
	}

	public String endX(String str) {
		return str.length() == 0 ? str : str.charAt(0) == 'x' ? endX(str.substring(1)) + 'x' : str.charAt(0) + endX(str.substring(1));
	}

	public String pairStar(String str) {
		return str.length() <= 1 ? str : (str.charAt(0) == str.charAt(1) ? str.charAt(0) + "*" + pairStar(str.substring(1)) : str.charAt(0) + pairStar(str.substring(1)));
	}

	public String allStar(String str) {
		return str.length() <= 1 ? str : str.charAt(0) + "*" + allStar(str.substring(1));
	}

	public boolean array220(int[] nums, int index) {
		return index <= nums.length - 2 && (nums[index] * 10 == nums[index + 1] || array220(nums, ++index));
	}

	public int array11(int[] nums, int index) {
		return (index == nums.length) ? 0 : ((nums[index] == 11) ? 1 + array11(nums, ++index) : array11(nums, ++index));
	}

	public boolean array6(int[] nums, int index) {
		return (index < nums.length) && (nums[index] == 6 || array6(nums, ++index));
	}

	public String noX(String str) {
		return str.length() == 0 ? str : (str.charAt(0) == 'x' ? noX(str.substring(1)) : str.charAt(0) + noX(str.substring(1)));
	}

	public String changePi(String str) {
		return str.length() < 2 ? str : (str.startsWith("pi") ? "3.14" + changePi(str.substring(2)) : str.charAt(0) + changePi(str.substring(1)));
	}

	public String achangePi(String str) {
		return str.replaceAll("pi", "3.14");
	}

	public String achangeXY(String str) {
		if (str.equals("")) return str;
		if (str.charAt(0) == 'x') return "y" + achangeXY(str.substring(1));
		return str.charAt(0) + achangeXY(str.substring(1));
	}

	public String changeXY(String str) {
		return str.replaceAll("x", "y");
	}

	public int acountHi(String str) {
		if (str.length() < 2) return 0;
		if (str.substring(0, 2).equals("hi")) return 1 + countHi(str.substring(1));
		else return countHi(str.substring(1));
	}

	public int countHi(String str) {
		return (str.contains("hi")) ? 1 + countHi(str.substring(str.indexOf("hi") + 2)) : 0;
	}

	public int countX(String str) {
		return str.length() != 0 ? (((str.charAt(0) == 'x') ? 1 + countX(str.substring(1)) : countX(str.substring(1)))) : 0;
	}

	public int powerN(int base, int n) {
		return n == 1 ? base : base * powerN(base, --n);
	}

	private int anotherCount8(int n) {
		if (n < 1) return 0;
		if (n % 10 == 8 && (n / 10) % 10 == 8) return 2 + count8(n / 10);
		else if (n % 10 == 8) return 1 + count8(n / 10);
		else return count8(n / 10);

	}

	public int count8(int n) {
		if (n < 10) return n == 8 ? 1 : 0;
		else return n % 10 == 8 ? (n % 100 / 10 == 8 ? 2 + count8(n / 10) : 1 + count8(n / 10)) : count8(n / 10);
	}

	public int count7(int seven) {
		if (seven < 10) return seven == 7 ? 1 : 0;
		else return seven % 10 == 7 ? 1 + count7(seven / 10) : count7(seven / 10);
	}

	public int sumDigits(int n) {
		if (n < 10) return n;
		else return n % 10 + sumDigits(n / 10);
	}

	public int triangle(int rows) {
		if (rows == 0) return 0;
		else return rows + triangle(--rows);
	}

	public int bunnyEars2(int bunnies) {
		if (bunnies == 0) return 0;
		else if (bunnies % 2 == 0) return 3 + bunnyEars2(--bunnies);
		else return 2 + bunnyEars2(--bunnies);
	}

	public int makeChocolate(int small, int big, int goal) {
		while (big * 5 > goal) {
			big--;
		}
		goal -= big * 5;
		return small >= goal ? goal : -1;
	}

	public int commonTwo(String[] a, String[] b) {
		LinkedHashSet<String> setA = new LinkedHashSet<String>();
		Collections.addAll(setA, a);
		LinkedHashSet<String> setB = new LinkedHashSet<String>();
		Collections.addAll(setB, b);

		int result = 0;
		for (String aSetA : setA) {
			if (setB.contains(aSetA)) {
				result++;
				setB.remove(aSetA);
			}
		}

		return result;
	}

	public int bigHeights(int[] heights, int start, int end) {
		int result = 0;
		for (int i = start; i < end; i++) {
			int distance = Math.abs(heights[i] - heights[i + 1]);
			if (distance > 4) {
				result++;
			}
		}
		return result;
	}

	public int sumHeights2(int[] heights, int start, int end) {
		int result = 0;
		for (int i = start; i < end; i++) {
			int distance = heights[i] - heights[i + 1];
			if (distance < 0) {
				result += Math.abs(distance * 2);
			} else {
				result += Math.abs(distance);
			}
		}
		return result;
	}

	public int sumHeights(int[] heights, int start, int end) {
		int result = 0;
		for (int i = start; i < end; i++) {
			result += Math.abs(heights[i] - heights[i + 1]);
		}
		return result;
	}

	public int userCompare(String aName, int aId, String bName, int bId) {
		int nameComparison = aName.compareTo(bName);
		if (nameComparison == 0) {
			if (aId < bId) {
				return -1;
			} else if (aId > bId) {
				return 1;
			} else {
				return 0;
			}
		} else if (nameComparison < 0) {
			return -1;
		} else {
			return 1;
		}
	}

	public int scoreUp(String[] key, String[] answers) {
		int score = 0;
		for (int i = 0; i < key.length; i++) {
			if (answers[i].equals("?")) {
			} else if (key[i].equals(answers[i])) {
				score += 4;
			} else {
				score--;
			}
		}
		return score;
	}

	public int matchUp(String[] a, String[] b) {
		int count = 0;

		for (int i = 0; i < a.length; i++) {
			if ((a[i].length() > 0 && b[i].length() > 0) && a[i].charAt(0) == b[i].charAt(0)) {
				count++;
			}
		}
		return count;
	}

	public int[] copyEndy(int[] nums, int count) {
		int[] result = new int[count];
		int countsAlready = 0;

		for (int num : nums) {
			if (isEndy(num)) {
				result[countsAlready] = num;
				countsAlready++;
			}
			if (countsAlready == count) {
				break;
			}
		}
		return result;
	}

	public boolean isEndy(int n) {
		return (((n >= 0) && (n <= 10)) || ((n >= 90) && (n <= 100)));
	}

	public int[] copyEvens(int[] nums, int count) {
		int[] result = new int[count];
		int countsAlready = 0;

		for (int num : nums) {
			if (num % 2 == 0) {
				result[countsAlready] = num;
				countsAlready++;
			}
			if (countsAlready == count) {
				break;
			}
		}
		return result;
	}

	public boolean dividesSelf(int n) {
		String intString = Integer.toString(n);
		for (int i = 0; i < intString.length(); i++) {
			int ch = Character.getNumericValue(intString.charAt(i));
			if (ch == 0 || !(n % ch == 0)) {
				return false;
			}
		}
		return true;
	}

	public boolean hasOne(int n) {
		return Integer.toString(n).contains("1");
	}

	public List wordsWithoutList(String[] words, int len) {
		List<String> strings = new ArrayList<>();
		for (String word : words) {
			if (word.length() != len) {
				strings.add(word);
			}
		}
		return strings;
	}

	public int wordsCount(String[] words, int len) {
		int count = 0;
		for (String word : words) {
			if (word.length() == len) {
				count++;
			}
		}
		return count;
	}

	public int scoresSpecial(int[] a, int[] b) {
		int biggerA = 0;
		int biggerB = 0;

		for (int aA : a) {
			if (aA % 10 == 0 && aA > biggerA) {
				biggerA = aA;
			}
		}
		for (int aB : b) {
			if (aB % 10 == 0 && aB > biggerB) {
				biggerB = aB;
			}
		}
		return biggerA + biggerB;
	}


	public String[] wordsWithout(String[] words, String target) {
		ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(words));
		arrayList.removeAll(Collections.singleton(target));
		return arrayList.toArray(new String[arrayList.size()]);
	}

	public String sameEnds(String string) {
		String start;
		for (int i = string.length() / 2; i >= 0; i--) {
			start = string.substring(0, i);
			if (string.endsWith(start)) {
				return start;
			}
		}
		return "";
	}


	public String mirrorEnds(String string) {
		String reversed = new StringBuffer(string).reverse().toString();

		String result = "";
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			if (c == reversed.charAt(i)) {
				result += c;
			} else {
				break;
			}
		}

		return result;
	}

	public String notReplace(String str) {
		return str.replaceAll("(?<![^\\W_])is(?![^\\W_])", "is not");
	}

	public int sumNumbers(String str) {
		String[] s = str.split("[^0-9]");
		int result = 0;
		for (String tmp : s) {
			if (!tmp.equals("")) {
				result += Integer.parseInt(tmp);
			}
		}

		return result;
	}

	public String withoutString(String base, String remove) {

		return base.replaceAll("(?i)" + remove, "");
	}

	public int countTriple(String str) {
		int triple = 0;
		for (int i = 0; i < str.length() - 2; i++) {
			char c = str.charAt(i);
			if (str.charAt(i + 1) == c && str.charAt(i + 2) == c) {
				triple++;
			}
		}
		return triple;
	}

	public String[] wordsFront(String[] words, int n) {
		return Arrays.copyOf(words, n);
	}

	public String[] mergeTwo(String[] a, String[] b, int n) {
		SortedSet<String> c = new TreeSet<String>();

		c.addAll(Arrays.asList(a));
		c.addAll(Arrays.asList(b));


		return Arrays.copyOf(c.toArray(new String[c.size()]), n);
	}

	public int scoresAverage(int[] scores) {
		int avgFirstHalf = this.average(scores, 0, scores.length / 2);
		int avgSecondHalf = this.average(scores, scores.length / 2, scores.length);

		return Math.max(avgFirstHalf, avgSecondHalf);
	}

	public int average(int[] scores, int start, int end) {
		int avg = 0;
		for (int i = start; i < end; i++) {
			avg += scores[i];
		}
		return avg / (end - start);
	}

	public boolean equalIsNot(String str) {
		int isCount = 0;
		int notCount = 0;
		for (int i = 0; i < str.length() - 1; i++) {
			if (str.substring(i, i + 2).equals("is")) {
				isCount++;
			}
		}
		for (int i = 0; i < str.length() - 2; i++) {
			if (str.substring(i, i + 3).equals("not")) {
				notCount++;
			}
		}
		System.out.println(isCount + " " + notCount);
		return isCount == notCount;
	}

	public int sumDigits(String str) {
		str = str.replaceAll("[^1-9]", "");
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			sum += Character.getNumericValue(str.charAt(i));
		}
		return sum;
	}


	public int maxBlock(String str) {
		System.out.println(str);
		int max = 0;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			System.out.println(c);
			int tmpMax = 1;
			for (int j = i + 1; j < str.length(); j++) {
				if (c == str.charAt(j)) {
					tmpMax++;
					i++;
				} else {
					break;
				}
			}
			if (tmpMax > max) {
				max = tmpMax;
			}
		}
		System.out.println(max);
		return max;
	}


	public boolean gHappy(String str) {
		str = str.replaceAll("[g]{2,}", "");
		System.out.println(str);
		return !str.contains("g");
	}

	public String[] fizzBuzz(int start, int end) {
		String[] array = new String[end - start];
		for (int i = start, pointer = 0; i < end; i++, pointer++) {
			String element;
			if (i % 3 == 0 && i % 5 == 0) {
				element = "FizzBuzz";
			} else if (i % 3 == 0) {
				element = "Fizz";
			} else if (i % 5 == 0) {
				element = "Buzz";
			} else {
				element = String.valueOf(i);
			}
			array[pointer] = element;
		}
		return array;
	}

	public String[] fizzArray(int n) {
		String[] array = new String[n];
		for (int i = 0; i < array.length; i++) {
			String element;
			if (i % 3 == 0 && i % 5 == 0) {
				element = "FizzBuzz";
			} else if (i % 3 == 0) {
				element = "Fizz";
			} else if (i % 5 == 0) {
				element = "Buzz";
			} else {
				element = String.valueOf(i);
			}
		}
		return array;
	}

	public String fizzString(String str) {
		if (str.startsWith("f") && str.endsWith("b")) {
			return "FizzBuzz";
		}
		if (str.startsWith("f")) {
			return "Fizz";
		}
		if (str.endsWith("b")) {
			return "Buzz";
		}
		return str;
	}

	public String fizzString2(int n) {
		if (n % 3 == 0 && n % 5 == 0) {
			return "FizzBuzz!";
		}
		if (n % 3 == 0) {
			return "Fizz!";
		}
		if (n % 5 == 0) {
			return "Buzz!";
		}
		return n + "!";
	}

	private void test() {
		String test = "DAY=abc!XYZ";
		int result = countYZ(test);
		System.out.println("result: " + result);
	}

	public int countYZ(String str) {
		int count = 0;

		String[] parts = str.split("[^a-zA-Z']+");

		for (String part : parts) {
			String partsLowerCase = part.toLowerCase();
			if (partsLowerCase.endsWith("y") || partsLowerCase.endsWith("z")) {
				count++;
			}
		}
		System.out.println(Arrays.toString(parts));

		return count;
	}
}
