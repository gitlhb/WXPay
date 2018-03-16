package com.wx.pay.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;



/**
 * AES加解密处理类
 * 
 * @author liuhongbing
 *
 */
public class AesUtil {

	private AesUtil() {
	}

	/**
	 * AES加密
	 * 
	 * @param sKey
	 *            key
	 * @param sSrc
	 *            待加密的字符串
	 * @return 密文
	 */
	public static String encrypt(String sKey, String sSrc) {
		try {
			byte[] raw = sKey.getBytes("utf-8");
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
			byte[] encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));
			return new Base64().encodeToString(encrypted);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/**
	 * AES解密
	 * 
	 * @param sKey
	 *            key
	 * @param sSrc
	 *            待解密的字符串
	 * @return 明文
	 */
	public static String decrypt(String sKey, String sSrc) {
		try {
			byte[] raw = sKey.getBytes("utf-8");
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec);
			byte[] encrypted1 = new Base64().decode(sSrc);
			try {
				byte[] original = cipher.doFinal(encrypted1);
				String originalString = new String(original, "utf-8");
				return originalString;
			} catch (Exception e) {
				System.out.println(e.toString());
				return null;
			}
		} catch (Exception ex) {
			System.out.println(ex.toString());
			return null;
		}
	}

	/**
	 * 密钥算法
	 */
	private static final String ALGORITHM = "AES";
	/**
	 * 加解密算法/工作模式/填充方式
	 */
	private static final String ALGORITHM_MODE_PADDING = "AES/ECB/PKCS5Padding";
	/**
	 * 生成key
	 */
	private static SecretKeySpec key = new SecretKeySpec(MD5Util.MD5Encode(ConstantParam.MCH_KEY, "UTF-8").toLowerCase().getBytes(), ALGORITHM);

	/**
	 * WX AES加密
	 * 
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static String encryptData(String data) throws Exception {
		// 创建密码器
		Cipher cipher = Cipher.getInstance(ALGORITHM_MODE_PADDING);
		// 初始化
		cipher.init(Cipher.ENCRYPT_MODE, key);
		return Base64Util.encode(cipher.doFinal(data.getBytes()));
	}

	/**
	 * WX AES解密
	 * 
	 * @param base64Data
	 * @return
	 * @throws Exception
	 */
	public static String decryptData(String base64Data) throws Exception {
		// 创建密码器
		Cipher cipher = Cipher.getInstance(ALGORITHM_MODE_PADDING);
		// 初始化
		cipher.init(Cipher.DECRYPT_MODE, key);
		return new String(cipher.doFinal(Base64Util.decode(base64Data)));
	}

	public static void main(String[] args) throws Exception {
		String encrypt = encrypt("DFCC9DCA8ED7AA668E1DCC2996455191", "1111");
		System.out.println(encrypt);
		
		System.out.println(decrypt("DFCC9DCA8ED7AA668E1DCC2996455191",encrypt));
		
	}


}
