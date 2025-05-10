package org.erbr.json;

import java.util.List;

public class Pessoa {
    private String id;
    private String name;
    private int age;
    private int score;
    private boolean active;
    private String country;
    private Team team;
    private List<Log> logs;

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    public int getScore() { return score; }

    public void setScore(int score) { this.score = score; }

    public boolean isActive() { return active; }

    public void setActive(boolean active) { this.active = active; }

    public String getCountry() { return country; }

    public void setCountry(String country) { this.country = country; }

    public Team getTeam() { return team; }

    public void setTeam(Team team) { this.team = team; }

    public List<Log> getLogs() { return logs; }

    public void setLogs(List<Log> logs) { this.logs = logs; }
}
