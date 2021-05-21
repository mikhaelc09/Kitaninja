package istts.pbo.Classes;

import istts.pbo.Players.Stat;
import istts.pbo.Players.skilltrees.SkillTree;

public class Job {
    private String classname;
    private Stat stats;
    private SkillTree skillTree;
    private String spritePath;

    public Job(Stat stats, String classname, String baseJob,  String spritePath) {
        this.stats = stats;
        this.classname = classname;
        this.skillTree = new SkillTree(baseJob);
        this.spritePath = spritePath;
    }

    public Stat getStats() {
        return stats;
    }

    public void setStats(Stat stats) {
        this.stats = stats;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public SkillTree getSkillTree() {
        return skillTree;
    }

    public void setSkillTree(SkillTree skillTree) {
        this.skillTree = skillTree;
    }

    public String getSpritePath() {
        return spritePath;
    }

    public void setSpritePath(String spritePath) {
        this.spritePath = spritePath;
    }
}
