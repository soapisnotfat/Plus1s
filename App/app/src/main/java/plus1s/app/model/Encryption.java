package plus1s.app.model;

/**
 * Created by ivorycandy on 7/25/17.
 * the class providing the password encryption
 */

public class Encryption {
    private static final int[] chain = {47891, 13578, 39784, 35456, 12314, 89696, 18658, 35756};

    /**
     * encrypt the password
     * @param password password will be encrypted
     * @return encrypted password
     */
    public static String encrypt(String password) {
        String output = "";
        int length = password.length();
        int ck = 0;
        char c;
        for (int i = 0; i < length; i++) {
            if (ck >= chain.length -1) {
                ck  = 0;
            }
            c = password.charAt(i);
            c += chain[ck];
            output += c;
            ck++;
        }
        return output;
    }

    /**
     * decrypt the password
     * @param key string will be decrypted
     * @return decrypted password
     */
    public static String decrypt(String key) {
        String output = "";
        int length = key.length();
        int ck = 0;
        char c;
        for (int i = 0; i < length; i++) {
            if (ck >= chain.length -1) {
                ck  = 0;
            }
            c = key.charAt(i);
            c -= chain[ck];
            output += c;
            ck++;
        }
        return output;
    }
}
