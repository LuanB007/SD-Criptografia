
package com.ifpb.edu.view;

/**
 *
 * @author Diones Gomes
 */

import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
  
import javax.crypto.Cipher;

public class AdvancedEncryptionStandard {  

        
       static String IV = "AAAAAAAAAAAAAAAA"; //Tamanho da chave
       static String textopuro = "Hello World"; // Palavra a ser encriptada
       static String chaveencriptacao = "012345678910cafe"; // Chave da criptografia.
  
       public static void main(String [] args) {
  
             try {
                     
                    System.out.println("Texto Puro: " + textopuro);
                      
                    byte[] textoencriptado = encrypt(textopuro,chaveencriptacao); // chama o método de encriptar e joga 
                    //dentro do array de bytes. 
                      
                    System.out.print("Texto Encriptado: ");
  
                    for (int i=0; i<textoencriptado.length; i++)
                           System.out.print(new Integer(textoencriptado[i])+" ");// Percorre byte por byte e converte em inteiro
                     
                    System.out.println("");
                      
                    String textodecriptado = decrypt(textoencriptado, chaveencriptacao); // atribui o texto descriptado a variável
                      
                    System.out.println("Texto Decriptado: " + textodecriptado);
               
             } catch (Exception e) {
                    e.printStackTrace();
             }
       }
  
       public static byte[] encrypt(String textopuro, String chaveencriptacao) throws Exception {
             Cipher encripta = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE"); // Cria uma instância de cipher
             SecretKeySpec key = new SecretKeySpec(chaveencriptacao.getBytes("UTF-8"), "AES"); // Converte o em  byte
             encripta.init(Cipher.ENCRYPT_MODE, key,new IvParameterSpec(IV.getBytes("UTF-8"))); // Inicializa a encriptação
             return encripta.doFinal(textopuro.getBytes("UTF-8")); //retorna o texto encriptado. 
       }
  
       public static String decrypt(byte[] textoencriptado, String chaveencriptacao) throws Exception{
             Cipher decripta = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
             SecretKeySpec key = new SecretKeySpec(chaveencriptacao.getBytes("UTF-8"), "AES");
             decripta.init(Cipher.DECRYPT_MODE, key,new IvParameterSpec(IV.getBytes("UTF-8")));
             return new String(decripta.doFinal(textoencriptado),"UTF-8");
       }
        
}
