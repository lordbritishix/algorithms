package com.quitevis.algorithms.string;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

public class StringManipulation {
    public boolean hasUniqueCharacters(String input) {
        Set<Character> lookup = new HashSet<>();
        char[] charArray = input.toCharArray();

        for (char c : charArray) {
            if (!lookup.add(c)) {
                return false;
            }
        }

        return true;
    }

    public String reverse(String input) {
        int first = 0;
        int last = input.length() - 1;
        char[] charArray = input.toCharArray();

        while (first < last) {
            char temp = charArray[first];
            charArray[first] = charArray[last];
            charArray[last] = temp;

            first++;
            last--;
        }

        return String.copyValueOf(charArray);
    }

    public String reverseRecursive(String input) {
        if (input.length() <= 1) {
            return input;
        }

        return reverseRecursive(input.substring(1)) + input.charAt(0);
    }

    public boolean isPalindrome(String input) {
        int first = 0;
        int last = input.length() - 1;
        char[] charArray = input.toCharArray();

        while (first < last) {
            if (charArray[first] != charArray[last]) {
                return false;
            }

            first++;
            last--;
        }

        return true;
    }

    public boolean isPalindromeRecursive(String input) {
        if (input.length() <= 1) {
            return true;
        }

        if (input.charAt(0) != input.charAt(input.length() - 1)) {
            return false;
        }
        else {
            return isPalindromeRecursive(input.substring(1, input.length() - 1));
        }
    }


    public boolean isAnagram(String input1, String input2) {
        char[] input1CharArray = input1.toCharArray();
        char[] input2CharArray = input2.toCharArray();

        int hash1 = 0;
        int hash2 = 0;

        for (char c : input1CharArray) {
            hash1 ^= c;
        }

        for (char c : input2CharArray) {
            hash2 ^= c;
        }

        return hash1 == hash2;
    }

    public String reverseWordsInString(String input) {
        int right = input.length() - 1;
        char[] charArray = input.toCharArray();
        StringBuilder buffer = new StringBuilder();
        StringBuilder ret = new StringBuilder();

        while (right >= 0) {
            if (charArray[right] == ' ') {
                ret.append(buffer.toString());
                ret.append(' ');
                buffer.setLength(0);
            }
            else if (right == 0) {
                buffer.append(charArray[right]);
                ret.append(buffer.toString());
                buffer.setLength(0);
            }
            else {
                buffer.append(charArray[right]);
            }


            right--;
        }

        return ret.toString();
    }

}
