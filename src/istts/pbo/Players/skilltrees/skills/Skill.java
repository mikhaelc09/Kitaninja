package istts.pbo.Players.skilltrees.skills;

public abstract class Skill {
    protected String name;
    protected int mana;
    protected int cd;
    protected int tool;

    public Skill(String name, int mana, int cd, int tool) {
        this.name = name;
        this.mana = mana;
        this.cd = cd;
        this.tool = tool;
    }
}

abstract class DamageOnly extends Skill{
    public DamageOnly(String name, int mana, int cd, int tool) {
        super(name, mana, cd, tool);
    }
}

abstract class Buff extends Skill{
    public Buff(String name, int mana, int cd, int tool) {
        super(name, mana, cd, tool);
    }
}

abstract class StatusEffect extends Skill{
    public StatusEffect(String name, int mana, int cd, int tool) {
        super(name, mana, cd, tool);
    }
}
