package fun.czrj.type;

/**
 * @author zhangjian
 * @email 13120082225@163.com
 * @date 2020/6/9
 */
public final class IntBox {

    private static IntBox intBox = null;

    private IntBox() {

    }

    public static IntBox getIntBox() {
        if (intBox == null) {
            synchronized(IntBox.class){
                if (intBox == null){
                    intBox = new IntBox();
                }
            }
        }
        return intBox;
    }

    /**
     * int 类型转换 byte 数组 低字节序
     * @param primary
     * @return
     */
    public  byte[] intToByteArrayLH(int primary){
        byte[] result = new byte[4];
        // 由高位到低位
        result[0] = (byte) ((primary >> 24) & 0xFF);
        result[1] = (byte) ((primary >> 16) & 0xFF);
        result[2] = (byte) ((primary >> 8) & 0xFF);
        result[3] = (byte) (primary & 0xFF);
        return result;
    }

    /**
     * int 类型转换 byte 数组 高字节序
     * @param primary
     * @return
     */
    public static byte[] intToByteArrayHH(int primary) {
        byte[] b = new byte[4];
        b[3] = (byte) (primary & 0xff);
        b[2] = (byte) (primary >> 8 & 0xff);
        b[1] = (byte) (primary >> 16 & 0xff);
        b[0] = (byte) (primary >> 24 & 0xff);
        return b;
    }

}
