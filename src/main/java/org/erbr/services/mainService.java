package org.erbr.services;

import org.erbr.json.Pessoa;
import org.erbr.json.Project;
import org.erbr.json.Team;
import org.erbr.json.TeamInsight;

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
                .filter(pessoa -> pessoa.getTeam() != null && pessoa.getTeam().getName() != null)
                .collect(Collectors.groupingBy(pessoa -> pessoa.getTeam().getName()))
                .entrySet()
                .stream()
                .map(entry -> {

                    String teamName = entry.getKey();
                    List<Pessoa> membros = entry.getValue();

                    long totalMembers = membros.size();
                    long totalLeaders = membros.stream()
                            .filter(p -> p.getTeam().isLeader())
                            .count();

                    long completedProjects = membros.stream()
                            .flatMap(p -> p.getTeam().getProjects().stream())
                            .filter(Project::isCompleted)
                            .count();

                    long activeCount = membros.stream()
                            .filter(Pessoa::isActive)
                            .count();

                    double activePercentage = totalMembers == 0 ? 0.0 :
                            (activeCount * 100.0) / totalMembers;

                    return new TeamInsight(teamName, totalMembers, totalLeaders, completedProjects, activePercentage);
                })
                .toList();


            getTeamName.forEach(System.out::println);
    }
}
