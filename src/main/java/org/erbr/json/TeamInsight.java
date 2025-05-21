package org.erbr.json;

public class TeamInsight {
    private String teamName;
    private long totalMembers;
    private long totalLeaders;
    private long completedProjects;
    private double activePercentage;

    public TeamInsight(String teamName, long totalMembers, long totalLeaders, long completedProjects, double activePercentage) {
        this.teamName = teamName;
        this.totalMembers = totalMembers;
        this.totalLeaders = totalLeaders;
        this.completedProjects = completedProjects;
        this.activePercentage = activePercentage;
    }

    @Override
    public String toString() {
        return "TeamInsight{" +
                "teamName='" + teamName + '\'' +
                ", totalMembers=" + totalMembers +
                ", totalLeaders=" + totalLeaders +
                ", completedProjects=" + completedProjects +
                ", activePercentage=" + activePercentage +
                '}';
    }
}
