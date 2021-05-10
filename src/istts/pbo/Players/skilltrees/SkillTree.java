package istts.pbo.Players.skilltrees;

import istts.pbo.Players.skilltrees.skills.Skill;

import java.util.ArrayList;

public class SkillTree {
    private ArrayList<Skill> skills;

    public SkillTree(ArrayList<Skill> skills) {
        this.skills = skills;
    }

    public ArrayList<Skill> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<Skill> skills) {
        this.skills = skills;
    }
}
