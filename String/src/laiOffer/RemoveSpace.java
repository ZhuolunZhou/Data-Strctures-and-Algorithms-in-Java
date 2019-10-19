package laiOffer;

public class RemoveSpace {
	public String removeSpaces(String input) {
		char[] charArr = input.toCharArray();
		int fast = 0;
		int slow = 0;
		for (fast = 0; fast < charArr.length; fast++) {
			if (charArr[fast] == ' ') {
				if (fast != 0 && slow != 0) {
					if (charArr[slow - 1] != ' ') {
						charArr[slow++] = charArr[fast++];
					}
				}
			} else {
				charArr[slow++] = charArr[fast];
			}
		}
		if (slow > 0 && charArr[slow - 1] == ' ') {
			slow--;
		}
		return new String(charArr, 0, slow);
	}
}
