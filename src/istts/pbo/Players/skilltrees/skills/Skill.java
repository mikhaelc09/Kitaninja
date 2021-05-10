package istts.pbo.Players.skilltrees.skills;

public abstract class Skill {
    protected String name;
    protected int mana;
    protected int cd;
    protected int tool;
    protected int value;

    public Skill(String name, int mana, int energy, int tool, int value) {
        this.name = name;
        this.mana = mana;
        this.cd = energy;
        this.tool = tool;
        this.value = value;
    }
}
