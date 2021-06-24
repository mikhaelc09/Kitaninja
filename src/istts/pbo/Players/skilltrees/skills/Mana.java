package istts.pbo.Players.skilltrees.skills;

public class Mana extends Skill{
    int value;
    public Mana(String name, String skillJob, String iconPath, String description, int value) {
        super(name, skillJob, iconPath, description);
        this.value = value;
    }

    public int useSkill(){
        return value;
    }
}
