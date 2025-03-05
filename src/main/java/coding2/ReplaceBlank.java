package coding2;


/**
 * 替换空格
 */
public class ReplaceBlank {
    public static String replaceSpace(String str) {
        return str.replaceAll(" ", "%20");
    }

    public static void main(String[] args) {
        String str = new StringBuffer("We are happy.").toString();
        System.out.println(replaceSpace2(str));
    }

    public static String replaceSpace2(String str) {
        StringBuilder chars = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == ' ') {
                chars.append('%');
                chars.append('2');
                chars.append('0');
            } else {
                chars.append(str.charAt(i));
            }
        }
        return chars.toString();
    }
}
