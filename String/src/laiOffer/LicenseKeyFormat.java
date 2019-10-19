package laiOffer;

public class LicenseKeyFormat {
	public String licenseKeyFormatting(String S, int K) {
		if (S == null || S.length() == 0) return S;
		int n = S.length();
		S = S.toUpperCase();
		int countDash = 0;
		for (int i = 0; i < n; i++) {
			if (S.charAt(i) == '-') {
				countDash++;
			}
		}
		int newDash = n == countDash ? 0 : ((n - countDash) % K == 0 ? (n - countDash) / K - 1 : (n - countDash) / K);
		int finalLen = n - countDash + newDash;
		char[] arr = newDash <= countDash ? S.toCharArray() : new char[finalLen];
		int right = arr.length - 1;
		int count = 0;
		for (int i = n - 1; i >= 0; i--) {
			if (S.charAt(i) != '-') {
				arr[right--] = S.charAt(i);
				count++;
			}
			if (count == K && newDash != 0 && i != 0) {
				arr[right--] = '-';
				count = 0;
			}
		}
		return new String(arr, arr.length - finalLen, finalLen);
	}
}
