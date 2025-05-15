package org.erbr.services;

import org.erbr.json.Pessoa;

import java.util.Date;
import java.util.List;

public class mainService {

    public static void getSuperUsers(List<Pessoa> usuarios){

        Date getDateBefore = new Date();

        usuarios.stream()
                .filter(pessoa -> pessoa.getScore() >= 900 && pessoa.isActive())
                .forEach(System.out::println);


        Date getDateAfter = new Date();

        long time = getDateAfter.getTime() - getDateBefore.getTime();

        System.out.println("Tempo em milissegundos: " + time);

    }
}
