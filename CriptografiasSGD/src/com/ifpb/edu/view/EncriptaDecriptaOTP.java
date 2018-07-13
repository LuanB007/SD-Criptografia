package com.ifpb.edu.view;

import java.util.Random;
  
public class EncriptaDecriptaOTP {
        
        //Método para criptografar.
        public String criptografa(String mensagem, String chave) {
                if (mensagem.length() != chave.length()) error("O tamanho da mensagem e da chave devem ser iguais.");
                int[] im = charArrayToInt(mensagem.toCharArray());//Mensagem em caractere, depois em inteiro.
                int[] ik = charArrayToInt(chave.toCharArray());//chave em caractere, depois em inteiro.
                int[] data = new int[mensagem.length()];//array de inteiro do tamanho da mensagem.
                
                for (int i=0;i<mensagem.length();i++) {
                        //Soma o inteiro da mensagem que representa o caractere com o inteiro da chave para 
                        //formar um novo caractere.
                        data[i] = im[i] + ik[i];
                }
                
                return new String(intArrayToChar(data));
        }
        
        //Metódo para decriptografar usando a lógica inversa da criptografia.
        public String decriptografa(String mensagem, String chave) {
                if (mensagem.length() != chave.length()) error("O tamanho da mensagem e da chave devem ser iguais.");
                int[] im = charArrayToInt(mensagem.toCharArray());
                int[] ik = charArrayToInt(chave.toCharArray());
                int[] data = new int[mensagem.length()];
                
                for (int i=0;i<mensagem.length();i++) {
                        data[i] = im[i] - ik[i];
                }
                
                return new String(intArrayToChar(data));
        }
        
        //Gerando a chave.
        public String genKey(int tamanho) {
                Random randomico = new Random();
                char[] key = new char[tamanho]; 
                for (int i=0;i<tamanho;i++) {
                        key[i] = (char) randomico.nextInt(132);
                        if ((int) key[i] < 97) key[i] = (char) (key[i] + 72);
                        if ((int) key[i] > 122) key[i] = (char) (key[i] - 72);
                }
                return new String(key);
        }
        
        public static void main(String[] args){
                EncriptaDecriptaOTP otp = new EncriptaDecriptaOTP();
                String menssagem = "Hello World";
                String chave = otp.genKey(menssagem.length());//Gera a chave de acordo com o tamanho da mensagem.
                String msgCriptografada = otp.criptografa(menssagem, chave);
                String msgDecriptografada = otp.decriptografa(msgCriptografada, chave);
                
                System.out.println("Mensagem: "+menssagem);
                System.out.println("Chave: "+chave);
                System.out.println("Mensagem Criptografada: "+msgCriptografada);
                System.out.println("Mensagem Decriptografada: "+msgDecriptografada);
                
        }
        
        private int chartoInt(char c) {
                return (int) c;
        }
        
        private char intToChar(int i) {
                return (char) i;
        }
        
        private int[] charArrayToInt(char[] cc) {
                int[] ii = new int[cc.length];
                for(int i=0;i<cc.length;i++){
                        ii[i] = chartoInt(cc[i]);
                }
                return ii;
        }
        
        private char[] intArrayToChar(int[] ii) {
                char[] cc = new char[ii.length];
                for(int i=0;i<ii.length;i++){
                        cc[i] = intToChar(ii[i]);
                }
                return cc;
        }
        
        private void error(String msg) {
                System.out.println(msg);
                System.exit(-1);
        }
}