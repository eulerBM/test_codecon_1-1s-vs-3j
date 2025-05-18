package org.erbr.services;

import org.erbr.json.Pessoa;
import org.erbr.json.Team;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public static void getTopCountries(List<Pessoa> usuarios){

        var getSuperUsers = usuarios.stream()
                .filter(pessoa -> pessoa.getScore() >= 900 && pessoa.isActive())
                .collect(Collectors.groupingBy(Pessoa::getCountry, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .toList();

        getSuperUsers.forEach(entry ->
                System.out.println("País: " + entry.getKey() + " - Superusuários: " + entry.getValue()));



    }

    public static void getTeamInsights(List<Pessoa> usuarios){

        var getTeamName = usuarios.stream()
                .collect(Collectors.groupingBy(Pessoa::getTeam, Collectors.counting()))
                .entrySet();

        getTeamName.forEach(entry ->
                System.out.println("Total de membros: " + entry.getValue()));

    }
}
