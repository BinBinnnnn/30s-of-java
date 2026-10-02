/*
 * MIT License
 *
 * Copyright (c) 2017-2022 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package string;

/**
 * PalindromCheckSnippet.
 */
public class PalindromCheckSnippet {

  /**
   * Private constructor to prevent instantiation.
   */
  private PalindromCheckSnippet() {
    // Utility class
  }

  /**
   * Checks if given string is palindrome (same forward and backward). Skips non-letter characters
   * Credits: https://github.com/kousen/java_8_recipes
   *
   * @param s string to check
   * @return true if palindrome
   */
  public static boolean isPalindrome(String s) {
    var start = 0;
    var end = s.length() - 1;
    while (start < end) {
      while (start < end && !Character.isLetter(s.charAt(start))) {
        start++;
      }
      while (start < end && !Character.isLetter(s.charAt(end))) {
        end--;
      }

      if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
        return false;
      }
      start++;
      end--;
    }

    return true;
  }
}
