package istts.pbo.Players.skilltrees;

import istts.pbo.Players.skilltrees.skills.DamageOnly;
import istts.pbo.Players.skilltrees.skills.Skill;

import java.util.ArrayList;

public class SkillTree<T> {
    private ArrayList<T> skills;

    public SkillTree() {
        skills = new ArrayList<>();
    }

    public ArrayList<T> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<T> skills) {
        this.skills = skills;
    }

    public void addDMG(String nama, int mana, int energy, int tools, int damage){
        skills.add((T)new DamageOnly(nama,mana,energy,tools,damage));
    }
}
