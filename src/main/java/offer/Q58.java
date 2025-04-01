package offer;

/**
 * 58
 * 翻转单词顺序。
 * <p>
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student."，则输出"student. a am I"。
 */
public class Q58 {
    public static String sum(String str) {

        String[] strs = str.split(" ");
        String[] res = new String[strs.length];

        int j = 0;
        for (int i = strs.length - 1; i >= 0; i--) {
            res[j] = strs[i];
            j++;
        }
        return String.join(" ", res);

    }
}
