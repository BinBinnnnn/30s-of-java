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

import java.util.Arrays;

/**
 * CompareVersionSnippet.
 */
public class CompareVersionSnippet {

  /**
   * Private constructor to prevent instantiation.
   */
  private CompareVersionSnippet() {
    // Utility class
  }

  /**
   * Compares two version strings.
   * Credits: https://stackoverflow.com/a/6702000/6645088 and https://stackoverflow.com/a/44592696/6645088
   *
   * @param v1 the first version string to compare
   * @param v2 the second version string to compare
   * @return the value {@code 0} if the two strings represent same versions;
   *     a value less than {@code 0} if {@code v1} is greater than {@code v2}; and
   *     a value greater than {@code 0} if {@code v2} is greater than {@code v1}
   */
  public static int compareVersion(String v1, String v2) {
    var components1 = getVersionComponents(v1);
    var components2 = getVersionComponents(v2);
    int length = Math.max(components1.length, components2.length);
    for (int i = 0; i < length; i++) {
      Integer c1 = i < components1.length ? Integer.parseInt(components1[i]) : 0;
      Integer c2 = i < components2.length ? Integer.parseInt(components2[i]) : 0;
      int result = c1.compareTo(c2);
      if (result != 0) {
        return result;
      }
    }
    return 0;
  }

  private static String[] getVersionComponents(String version) {
    var start = firstVersionDigit(version);
    if (start < 0) {
      return new String[0];
    }
    var end = start;
    while (end < version.length() && (Character.isDigit(version.charAt(end))
        || version.charAt(end) == '.' || version.charAt(end) == '-')) {
      end++;
    }
    return Arrays.stream(version.substring(start, end).split("[.-]"))
        .filter(part -> !part.isEmpty())
        .toArray(String[]::new);
  }

  /**
   * Finds the first digit that starts a version-like sequence. Digits that continue a word,
   * such as the "2" in "beta2", do not count.
   *
   * @param version the version string to inspect
   * @return the index of the first version digit, or -1 when there is none
   */
  private static int firstVersionDigit(String version) {
    for (var i = 0; i < version.length(); i++) {
      if (Character.isDigit(version.charAt(i)) && !isWordCharacter(version, i - 1)) {
        return i;
      }
    }
    return -1;
  }

  private static boolean isWordCharacter(String version, int index) {
    if (index < 0) {
      return false;
    }
    var character = version.charAt(index);
    return Character.isLetterOrDigit(character) || character == '_';
  }
}
