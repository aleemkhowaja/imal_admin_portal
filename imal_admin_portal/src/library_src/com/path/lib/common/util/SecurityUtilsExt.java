package com.path.lib.common.util;

import java.security.Key;
import java.security.MessageDigest;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.util.Base64Utils;


/**
 * DENISK_LATEST_VERS_UPDATED
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: deniskhaddad
 * 
 *          SecurityUtilsExt.java used to provide methods for security Used By
 *          PB code, and within Java aslo
 */
public final class SecurityUtilsExt
{
    public final static String ALGORITHM = "AES";
    public final static String ALGORITHM_CBC_NOPADDING = "AES/CBC/NoPadding";
    private final static String ALGORITHM_CBC_NOPADDING_PWD = "PATHSOLUTIONS123";
    private final static String ALGORITHM_SESSION_TOKEN_PWD = "123PATHSOLUTIONS";
    public final static String DEFAULT_ENCODING = "UTF-8";
    public final static String SESSION_TOKEN_KEY = "PATH_SESSION_TOKEN";
    public final static String PATH_ENC_PWD = "PATH_ENC_PWD";

    /**
     * Private constructor to prevent class from instantiation
     */
    private SecurityUtilsExt()
    {
	// no need to include anything since this class is used for PB to call
	// security encryption process
    }

    /**
     * 
     * Used for encryption using AES Java Algorithm
     * 
     * @param theKey
     * @param theValue
     * @return
     */
    public static String encryptAES(String theKey, String theValue) throws Exception
    {
	if(theKey != null && theKey.length() != 16)
	{
	    throw new Exception("ERROR: Key should be exact of 16 Character Length");
	}
	Cipher c = Cipher.getInstance(ALGORITHM);
	Key aesKey = new SecretKeySpec(theKey.getBytes(DEFAULT_ENCODING), ALGORITHM);
	c.init(Cipher.ENCRYPT_MODE, aesKey);
	byte[] encVal = c.doFinal(theValue.getBytes(DEFAULT_ENCODING));
	return encodeB64(encVal);
    }

    /**
     * Method that perform Cypher Java standard encryption
     * @param theAlgorithm the Algorithm used for Encryption Example AES, AES/CBC/PKCS5Padding
     * @param theKey The secret Key to encrypt with
     * @param theIv THe Initialization Vector to use in encryption
     * @param theValue Value to encrypt
     * @return encrypted value
     * @throws Exception
     */
    public static String encryptCustom(String theAlgorithm, String theKey,String theIv,String theValue) throws Exception
    {
	Cipher cipher = Cipher.getInstance(theAlgorithm);
	cipher.init(Cipher.ENCRYPT_MODE, generateKey(theKey), generateIv(theIv));
	return encodeB64(cipher.doFinal(theValue.getBytes()));
    }
    /**
     * Method that perform Cypher Java standard encryption
     * @param theAlgorithm the Algorithm used for Encryption Example AES, AES/CBC/PKCS5Padding
     * @param theKey The secret Key to encrypt with
     * @param theIv THe Initialization Vector to use in encryption
     * @param theValue Value to encrypt
     * @return encrypted value
     * @throws Exception
     */
    public static String encryptCustom(String theAlgorithm, byte[] theKey,byte[] theIv,byte[] theValue) throws Exception
    {
	Cipher cipher = Cipher.getInstance(theAlgorithm);
	cipher.init(Cipher.ENCRYPT_MODE, generateKey(theKey), generateIv(theIv));
	return encodeB64(cipher.doFinal(theValue));
    }
    /**
     * Method that perform Cypher Java standard decryption
     * @param theAlgorithm the Algorithm used for decryption Example AES, AES/CBC/PKCS5Padding
     * @param theKey The secret Key to derypt with
     * @param theIv THe Initialization Vector to use in decryption
     * @param theValue Value to derypt
     * @return decrypted value 
     * @throws Exception
     */
    public static String decryptCustom(String theAlgorithm, String theKey,String theIv,String theValue) throws Exception
    {
	Cipher cipher = Cipher.getInstance(theAlgorithm);
	cipher.init(Cipher.DECRYPT_MODE, generateKey(theKey), generateIv(theIv));
	return new String(cipher.doFinal(decodeB64(theValue)));
    }
    /**
     * Method that perform Cypher Java standard decryption
     * @param theAlgorithm the Algorithm used for decryption Example AES, AES/CBC/PKCS5Padding
     * @param theKey The secret Key to derypt with
     * @param theIv THe Initialization Vector to use in decryption
     * @param theValue Value to derypt
     * @return decrypted value 
     * @throws Exception
     */
    public static String decryptCustom(String theAlgorithm, byte[] theKey,byte[] theIv,byte[] theValue) throws Exception
    {
	Cipher cipher = Cipher.getInstance(theAlgorithm);
	cipher.init(Cipher.DECRYPT_MODE, generateKey(theKey), generateIv(theIv));
	return new String(cipher.doFinal(SecurityUtils.decodeB64NoCharEncoding(theValue)));
    }
    
    private static Key generateKey(String theKeyValue) throws Exception
    {
	return generateKey(theKeyValue.getBytes(DEFAULT_ENCODING));
	
    }
    
    private static Key generateKey(byte[] theKeyValue) throws Exception
    {
	MessageDigest md = MessageDigest.getInstance("SHA-256");
	byte[] key = md.digest(theKeyValue);
	return new SecretKeySpec(key, ALGORITHM);
	
    }
    
    private static AlgorithmParameterSpec generateIv(String theIv) throws Exception
    {
	return generateIv(theIv.getBytes(DEFAULT_ENCODING));
    }
    
    private static AlgorithmParameterSpec generateIv(byte[] theIv) throws Exception
    {
	return new IvParameterSpec(theIv);
    }
    /**
     * 
     * Used for Base 64 encoding
     * 
     * @param theBytes
     * @return
     */
    public static String encodeB64(byte[] theBytes) throws Exception
    {
	String result = "";
	if(theBytes != null)
	{
	    result = new String(Base64Utils.encode(theBytes), DEFAULT_ENCODING);
	}
	return result;
    }
    /**
     * Method to decode BAse64 encoded String as UTF-8 encoding and return related bytes
     * @param theEncodedValue, the Encoded Values
     * @return Byte array of the decoded result
     * @throws Exception
     */
    public static byte[] decodeB64(String theEncodedValue) throws Exception
    {
	byte[] result = null;
	if(theEncodedValue != null)
	{
	    result = Base64Utils.decode(theEncodedValue.getBytes(DEFAULT_ENCODING));
	}
	return result;
    }

    /**
     * 
     * Used for decryption of encrypted Data using particular Key
     * 
     * @param theKey
     * @param encryptedData
     * @return
     * @throws Exception
     */
    public static String decryptAES(String theKey, String encryptedData) throws Exception
    {
	if(theKey != null && theKey.length() != 16)
	{
	    throw new Exception("ERROR: Key should be of 16 Character Length");
	}
	Key aesKey = new SecretKeySpec(theKey.getBytes(DEFAULT_ENCODING), ALGORITHM);
	Cipher c = Cipher.getInstance(ALGORITHM);
	c.init(Cipher.DECRYPT_MODE, aesKey);
	byte[] decodedValue = Base64Utils.decode(encryptedData.getBytes(DEFAULT_ENCODING));
	byte[] decValue = c.doFinal(decodedValue);
	return new String(decValue, DEFAULT_ENCODING);
    }
    
    /**
     * return the ALGORITHM_CBC_NOPADDING_PWD
     * @return
     */
    public static String returnAlgorithmCbcNopaddingPwd()
    {
	return ALGORITHM_CBC_NOPADDING_PWD;
    }
    /**
     * return the ALGORITHM_SESSION_TOKEN_PWD
     * @return
     */
    public static String returnAlgorithmSessionTokenPwd()
    {
	return ALGORITHM_SESSION_TOKEN_PWD;
    }
    
}
