package com.quitevis.algorithms.string;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by lordbritishix on 17/05/15.
 */
public class StringManipulationTest {
    private StringManipulation stringUtils;

    @Before
    public void beforeEachTests() {
        stringUtils = new StringManipulation();
    }

    @Test
    public void hasDuplicatesReturnsCorrectResult() {
        assertThat(stringUtils.hasUniqueCharacters("abc"), is(true));
        assertThat(stringUtils.hasUniqueCharacters("aba"), is(false));
        assertThat(stringUtils.hasUniqueCharacters("a"), is(true));
        assertThat(stringUtils.hasUniqueCharacters(""), is(true));
    }

    @Test
    public void reverseReturnsReversedString() {
        assertThat(stringUtils.reverse("abc"), is("cba"));
        assertThat(stringUtils.reverse("a"), is("a"));
        assertThat(stringUtils.reverse(""), is(""));
        assertThat(stringUtils.reverse("abba"), is("abba"));
    }

    @Test
    public void reverseRecursiveReturnsReversedString() {
        assertThat(stringUtils.reverseRecursive("abc"), is("cba"));
        assertThat(stringUtils.reverseRecursive("a"), is("a"));
        assertThat(stringUtils.reverseRecursive(""), is(""));
        assertThat(stringUtils.reverseRecursive("abba"), is("abba"));
    }

    @Test
    public void isPalindromeReturnsCorrectResult() {
        assertThat(stringUtils.isPalindrome("aba"), is(true));
        assertThat(stringUtils.isPalindrome("aa"), is(true));
        assertThat(stringUtils.isPalindrome("a"), is(true));
        assertThat(stringUtils.isPalindrome("abba"), is(true));
        assertThat(stringUtils.isPalindrome("abbc"), is(false));
        assertThat(stringUtils.isPalindrome("ab"), is(false));
    }

    @Test
    public void isPalindromeRecursiveReturnsCorrectResult() {
        assertThat(stringUtils.isPalindromeRecursive("aba"), is(true));
        assertThat(stringUtils.isPalindromeRecursive("aa"), is(true));
        assertThat(stringUtils.isPalindromeRecursive("a"), is(true));
        assertThat(stringUtils.isPalindromeRecursive("abba"), is(true));
        assertThat(stringUtils.isPalindromeRecursive("abbc"), is(false));
        assertThat(stringUtils.isPalindromeRecursive("ab"), is(false));
    }


    @Test
    public void isAnagramReturnsCorrectResult() {
        assertThat(stringUtils.isAnagram("abc", "cba"), is(true));
        assertThat(stringUtils.isAnagram("abc", "cb"), is(false));
        assertThat(stringUtils.isAnagram("abc", "cbaa"), is(false));
        assertThat(stringUtils.isAnagram("a", "a"), is(true));
        assertThat(stringUtils.isAnagram("aa", "aaa"), is(false));
        assertThat(stringUtils.isAnagram("", ""), is(true));
        assertThat(stringUtils.isAnagram("abracadabra", "abracadabra"), is(true));
        assertThat(stringUtils.isAnagram("mary", "army"), is(true));
    }

    @Test
    public void reverseWordsInStringReversesWordsInInput() {
        assertThat(stringUtils.reverseWordsInString("abc def ghi"), is("ihg fed cba"));
        assertThat(stringUtils.reverseWordsInString("abc"), is("cba"));
        assertThat(stringUtils.reverseWordsInString("abcd efgh"), is("hgfe dcba"));

    }
}
