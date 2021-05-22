package istts.pbo.Players.skilltrees.skills;

public abstract class Skill {
    protected String name;
    protected String iconPath;
    protected boolean unlocked;
    protected String skillJob;
    protected String description;

    public Skill(String name,  String skillJob, String iconPath, String description) {
        this.name = name;
        this.unlocked = false;
        this.skillJob = skillJob;
        this.iconPath = iconPath;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isUnlocked() {
        return unlocked;
    }

    public void setUnlocked(boolean unlocked) {
        this.unlocked = unlocked;
    }

    public String getSkillJob() {
        return skillJob;
    }

    public void setSkillJob(String skillJob) {
        this.skillJob = skillJob;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
