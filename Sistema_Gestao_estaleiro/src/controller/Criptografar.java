/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 *
 * @author Nelson Matsinhe
 */
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.SecureRandom;


public class Criptografar {
    private static final SecureRandom random = new SecureRandom();

    public static String encriptografar(String senha) {
        String salt = new BigInteger(130, random).toString(32);
        String senhaComSalt = senha + salt;
        String retorno = "";
        MessageDigest md;

        try {
            md = MessageDigest.getInstance("SHA-256");
            BigInteger hash = new BigInteger(1, md.digest(senhaComSalt.getBytes()));
            retorno = hash.toString(16) + ":" + salt;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return retorno;
    }

    public static boolean verificarSenha(String senha, String hashComSalt) {
        String[] parts = hashComSalt.split(":");
        String hashArmazenado = parts[0];
        String salt = parts[1];
        String senhaComSalt = senha + salt;
        String hashCalculado = "";

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            BigInteger hash = new BigInteger(1, md.digest(senhaComSalt.getBytes()));
            hashCalculado = hash.toString(16);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return hashCalculado.equals(hashArmazenado);
    }
}


