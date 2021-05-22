package istts.pbo.Players.skilltrees;

import istts.pbo.Players.skilltrees.skills.DamageOnly;
import istts.pbo.Players.skilltrees.skills.Skill;

import java.util.ArrayList;

public class SkillTree<T> {
    private ArrayList<T> skills;
    private String baseJob;

    public SkillTree(String baseJob) {
        this.baseJob = baseJob;
        skills = new ArrayList<>();
    }

    public void addSkill(T skill){
        skills.add(skill);
    }

    public T getAt(int i){
        return skills.get(i);
    }

    public ArrayList<T> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<T> skills) {
        this.skills = skills;
    }

    public String getBaseJob() {
        return baseJob;
    }

    public void setBaseJob(String baseJob) {
        this.baseJob = baseJob;
    }
}
