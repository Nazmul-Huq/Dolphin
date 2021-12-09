package Admin;

import java.util.ArrayList;

/**
 * written by Nazmul
 */
public class Team {

    /**
     *
     */
    private int teamId;
    private String teamName;
    private ArrayList<Integer> teamMembers;

    /**
     *
     */
    public Team(int teamId, String teamName, ArrayList<Integer> teamMembers) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.teamMembers = teamMembers;
    }

    /**
     * get team id
     */
    public int getTeamId() {
        return teamId;
    }

    /**
     * get team name
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * set team name
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    /**
     * get team members
     */
    public ArrayList<Integer> getTeamMembers() {
        return teamMembers;
    }

    /**
     * set team members
     */
    public void setTeamMembers(ArrayList<Integer> teamMembers) {
        this.teamMembers = teamMembers;
    }

    /**
     * format the to string
     */
    @Override
    public String toString() {
        return teamId + "," + teamName + "," +  teamMembers;
    }
}