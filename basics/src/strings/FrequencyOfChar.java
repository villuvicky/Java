package strings;

public class FrequencyOfChar {
    public static char highestOccurringChar(String str) {
        int[] freq = new int[26];

        // Count frequency of each character
        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i) - 'a']++;
        }

        int maxFreq = 0;
        char result = str.charAt(0);

        // Find highest occurring character
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            int currentFreq = freq[currentChar - 'a'];

            if (currentFreq > maxFreq) {
                maxFreq = currentFreq;
                result = currentChar;
            }
        }

        return result;
    }

	public static void main(String[] args) {
		
		System.out.println(highestOccurringChar("abbbbbbbhdhhpppppppppppppd"));

	}

}
