package chenqx.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenqx 2020-02-27
 * @instruction
 */
public class CodeTest6 {
    @Test
    public void should_61() {
        System.out.println(convert("PAYPALISHIRING", 3));
    }

    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0) return "";
        if (numRows == 1) return s;
        char[][] helpArray = new char[numRows][s.length()];
        char[] chars = s.toCharArray();
        boolean isDown = true;
        int j = 0;
        int index = 0;
        for (int i = 0; ; i++) {
            while (true) {
                if (isDown) {
                    helpArray[j][i] = chars[index++];
                    if (index == s.length()) return tran(helpArray);
                    if (j == numRows - 1) {
                        isDown = false;
                        break;
                    }
                    if (j < numRows - 1) j++;
                } else {
                    if (j == 1) {
                        j--;
                        isDown = true;
                        break;
                    }
                    helpArray[--j][i] = chars[index++];
                    if (index == s.length()) return tran(helpArray);

                    break;
                }
            }
        }

    }

    String tran(char[][] chars) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[i].length; j++) {
                if (chars[i][j] != 0) {
                    stringBuilder.append(chars[i][j]);
                }
            }
        }
        return stringBuilder.toString();
    }


    public String convert1(String s, int numRows) {
        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;
        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow = goingDown ? curRow + 1 : curRow - 1;
        }
        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }

    public String convert3(String s, int numRows) {

        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }

    @Test
    public void should_31() {
        convert3("abcdefghi", 3);
    }

}
