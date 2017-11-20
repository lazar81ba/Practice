package ciphers;

public class CaesarCipher {
    private char[] encoder = new char[26];
    private char[] decoder = new char[26];

    public CaesarCipher(int rotation) {
        for(int k=0;k<26;k++){
            encoder[k] = (char) ('A'+(k+rotation)%26);
            decoder[k] = (char) ('A'+(k-rotation+26)%26);
        }
    }

    public String encrypt(String message){
        return transform(message,encoder);
    }

    public String decrypt(String secret){
        return transform(secret,decoder);
    }

    private String transform(String message, char[] code) {
        char [] tmp = message.toCharArray();
        for(int k = 0; k<tmp.length;k++){
            if(Character.isUpperCase(tmp[k])){
                int j = tmp[k]-'A';
                tmp[k] = code[j];
            }
            else if(Character.isLowerCase(tmp[k])){
                int j = Character.toUpperCase(tmp[k]) -'A';
                tmp[k] = Character.toLowerCase(code[j]);
            }
        }
        return new String(tmp);
    }

}
