package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)


    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }


    @Test
    public void equals_returns_true_for_same_team() {
        assertEquals(true, team.equals(team));
    }

    @Test
    public void equals_returns_false_for_different_class() {
        Object obj = new Object();
        assertEquals(false, team.equals(obj));
    }

    @Test
    public void equals_returns_true_for_same_fields() {
        Team team2 = new Team(team.getName());
        assertEquals(true, team.equals(team2));
    }

    @Test
    public void equals_returns_false_for_different_members() {
        Team team2 = new Team(team.getName());
        team2.addMember("different-member");
        assertEquals(false, team.equals(team2));
    }

    @Test
    public void equals_returns_false_for_different_name() {
        Team team2 = new Team("different-team");
        assertEquals(false, team.equals(team2));
    }

    @Test
    public void equals_returns_false_for_different_name_and_members() {
        Team team2 = new Team("different-team");
        team2.addMember("different-member");
        assertEquals(false, team.equals(team2));
    }

    @Test
    public void hashCode_returns_same_hash_for_same_fields() {
        Team team2 = new Team(team.getName());
        team2.setMembers(team.getMembers());
        assertEquals(team.hashCode(), team2.hashCode());
    }

    @Test
    public void hashCode_returns_different_hash_for_different_fields() {
        Team team2 = new Team("different-team");
        team2.addMember("different-member");
        assertEquals(false, team.hashCode() == team2.hashCode());
    }

    @Test
    public void hashCode_returns_different_hash_for_different_name() {
        Team team2 = new Team("different-team");
        assertEquals(false, team.hashCode() == team2.hashCode());
    }

    @Test
    public void hashCode_returns_different_hash_for_different_members() {
        Team team2 = new Team(team.getName());
        team2.addMember("different-member");
        assertEquals(false, team.hashCode() == team2.hashCode());
    }

    @Test
    public void hashCode_special_test() {
        Team t = new Team();
        int result = t.hashCode();
        int expectedResult = 1;
        assertEquals(expectedResult, result);
    }
}
