package org.erbr;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            Usuario usuario = mapper.readValue(new File("usuario.json"), Usuario.class);
            System.out.println("Nome: " + usuario.getNome());
            System.out.println("Idade: " + usuario.getIdade());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}