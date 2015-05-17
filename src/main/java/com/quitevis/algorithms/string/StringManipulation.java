package com.quitevis.algorithms.string;

import java.util.*;

public class StringManipulation {
    public boolean hasUniqueCharacters(String input) {
        Set<Character> lookup = new HashSet<>();

        for (Character c : input.toCharArray()) {
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

    public boolean isAnagram(String input1, String input2) {
        char[] input1CharArray = input1.toCharArray();
        char[] input2CharArray = input2.toCharArray();

        int hash1 = 0;
        int hash2 = 0;

        for (Character c : input1CharArray) {
            hash1 ^= c;
        }

        for (Character c : input2CharArray) {
            hash2 ^= c;
        }

        return hash1 == hash2;

    }
}