package ciphers;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CaesarCipherTest {

    private CaesarCipher cipher ;
    private String textToEncrypt ;
    private String textToDecrypt;

    @Before
    public void setUp(){
        cipher = new CaesarCipher(2);
        textToEncrypt="AbCXyZ";
        textToDecrypt="CdEZaB";
    }

    @Test
    public void testEncrypt(){
        assertEquals(textToDecrypt,cipher.encrypt(textToEncrypt));
    }

    @Test
    public void testDecrypt(){
        assertEquals(textToEncrypt,cipher.decrypt(textToDecrypt));
    }

}