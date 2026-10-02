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

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * CommonLettersSnippet.
 */
public class CommonLettersSnippet {

  /**
   * Private constructor to prevent instantiation.
   */
  private CommonLettersSnippet() {
    // Utility class
  }

  /**
   * Find Common Characters inside given two strings.
   *
   * @param firstStr  first string
   * @param secondStr second string
   * @return Common Characters.
   */
  public static String getCommonLetters(String firstStr, String secondStr) {
    Set<String> commonLetters = firstStr.chars()
        .mapToObj(character -> (char) character)
        .filter(character -> isCommonLetter(secondStr, character))
        .map(String::valueOf)
        .collect(Collectors.toCollection(HashSet::new));
    return String.join(" ", commonLetters);
  }

  private static boolean isCommonLetter(String str, Character character) {
    return str.contains(character.toString()) && Character.isLetter(character);
  }
}
