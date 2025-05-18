package org.erbr;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.erbr.json.Pessoa;
import org.erbr.services.mainService;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        try {
            List<Pessoa> usuarios = mapper.readValue(new File("usuarios_1000.json"), mapper.getTypeFactory().constructCollectionType(List.class, Pessoa.class));

            mainService.getTeamInsights(usuarios);


        } catch (IOException e) {

            e.printStackTrace();

        }
    }
}
