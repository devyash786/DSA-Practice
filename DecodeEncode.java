package com.dev.dsa;
/*if A=1, B=2, ... Z=26
Decode message in alphates of lenght X, X = 9. 2324252627291, output message should be on length X, WXYZBGBIA, */
import java.util.ArrayList;
import java.util.List;

public class DecodeEncode {
	static void generateDecodings(char[] digits, int n, int length, StringBuilder decoded, List<String> result) {
		if (n == 0) {
			if (length == 0) {
				result.add(decoded.toString());
			}
			return;
		}

		// If the last digit is not 0, then
		// last digit must add to
		// the number of words
		if (digits[n - 1] > '0') {
			char ch = (char) ('A' + digits[n - 1] - '1');
			generateDecodings(digits, n - 1, length - 1, decoded.insert(0, ch), result);
			decoded.deleteCharAt(0);
		}

		// If the last two digits form a number
		// smaller than or equal to 26,
		// then consider last two digits and recur
		if (n >= 2 && (digits[n - 2] == '1' || (digits[n - 2] == '2' && digits[n - 1] < '7'))) {
			char ch = (char) ('A' + Integer.parseInt(new String(digits, n - 2, 2)) - 1);
			generateDecodings(digits, n - 2, length - 1, decoded.insert(0, ch), result);
			decoded.deleteCharAt(0);
		}
	}

	// Given a digit sequence of length n,
	// returns list of possible decodings by
	// replacing 1 with A, 2 with B, ... 26 with Z
	static List<String> decodeWays(char[] digits, int length) {
		List<String> result = new ArrayList<>();
		if (digits == null || digits.length == 0 || (digits.length == 1 && digits[0] == '0')) {
			return result;
		}
		generateDecodings(digits, digits.length, length, new StringBuilder(), result);
		return result;
	}

	public static void main(String[] args) {
		String input = "2324252627291";
		char digits[] = input.toCharArray();
		int length = 9; // Specify the desired length

		List<String> decodings = decodeWays(digits, length);
		for (String decoding : decodings) {
			System.out.println("Decoded value: " + decoding);
		}
	}
}
