package fun.czrj.type;

/**
 * @author zhangjian
 * @email 13120082225@163.com
 * @date 2020/6/9
 */
public final class StringBox {

    private static StringBox stringBox = null;

    private StringBox() {
    }

    public static StringBox getInstance() {
        if (stringBox == null) {
            synchronized (StringBox.class) {
                if (stringBox == null) {
                    stringBox = new StringBox();
                }
            }
        }
        return stringBox;
    }

    /**
     * string 转int
     * @param str
     * @return
     */
    public int stringToInt(String str){
        if (isEmpty(str)){
            return  -1;
        }
        return Integer.parseInt(str);
    }

    /**
     * string 转double
     * @param str
     * @return
     */
    public double stringtoDouble(String str){
        if (isEmpty(str)){
            return  -1;
        }
        return Double.parseDouble(str);
    }

    /**
     * 判断字符串对象是否为空
     *
     * @param str 需校验字符串
     * @return
     */
    public boolean isEmpty(Object str) {
        return (str == null || "".equals(str));
    }

    /**
     * 判断字符串的长度是否大于0
     *
     * @param str 需校验字符串
     * @return " " => true; "" => false
     */
    public boolean hasLength(CharSequence str) {
        return (str != null && str.length() > 0);
    }

    /**
     * 判断一个字符串是否有内容
     *
     * @param str
     * @return
     */
    public boolean hasText(String str) {
        return (hasLength((CharSequence) str) && containsText((CharSequence) str));
    }

    /**
     * 判断字符串的内容是否为空白字符
     * isWhitespace()方法用于判断指定字符是否为空白字符
     *
     * @param str 需校验字符串
     * @return
     */
    private boolean containsText(CharSequence str) {
        int strLen = str.length();
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    /**
     * 校验给定的字符串str是否以prefix开头，忽略大小写
     *
     * @param str    需校验字符串
     * @param prefix 检验字符串的开头的字符串
     * @return
     */
    public boolean startsWithIgnoreCase(String str, String prefix) {
        return (str != null && prefix != null && str.length() >= prefix.length() &&
                str.regionMatches(true, 0, prefix, 0, prefix.length()));
    }

    /**
     * 校验给定的字符串str是否以suffix结尾，忽略大小写
     *
     * @param str    需校验字符串
     * @param suffix 检验字符串的结尾的字符串
     * @return
     */
    public boolean endsWithIgnoreCase(String str, String suffix) {
        return (str != null && suffix != null && str.length() >= suffix.length() &&
                str.regionMatches(true, str.length() - suffix.length(),
                        suffix, 0, suffix.length()));
    }

    /**
     * 判断sub在str中出现的次数
     *
     * @param str 全字符串
     * @param sub 判断出现次数的字符串
     * @return
     */
    public int countOccurrencesOf(String str, String sub) {
        if (!hasLength(str) || !hasLength(sub)) {
            return 0;
        }
        int count = 0;
        int pos = 0;
        int idx;
        while ((idx = str.indexOf(sub, pos)) != -1) {
            ++count;
            pos = idx + sub.length();
        }
        return count;
    }

    /**
     * 删除给定字符串中包含有的任意字符
     *
     * @param inString      给定字符串
     * @param charsToDelete 需要删除的字符
     * @return
     */
    public String deleteAny(String inString, String charsToDelete) {
        if (!hasLength(inString) || !hasLength(charsToDelete)) {
            return inString;
        }
        StringBuilder sb = new StringBuilder(inString.length());
        for (int i = 0; i < inString.length(); i++) {
            char c = inString.charAt(i);
            if (charsToDelete.indexOf(c) == -1) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
