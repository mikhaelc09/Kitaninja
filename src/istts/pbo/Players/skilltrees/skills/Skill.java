package istts.pbo.Players.skilltrees.skills;

public abstract class Skill {
    protected String name;
    protected int mana;
    protected int energy;
    protected int tool;
    protected int value;
    protected String iconPath;
    protected boolean unlocked;
    protected String skillJob;

    public Skill(String name, int mana, int energy, int tool, int value, String skillJob, String iconPath) {
        this.name = name;
        this.mana = mana;
        this.energy = energy;
        this.tool = tool;
        this.value = value;
        this.unlocked = false;
        this.skillJob = skillJob;
        this.iconPath = iconPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getTool() {
        return tool;
    }

    public void setTool(int tool) {
        this.tool = tool;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
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
}
