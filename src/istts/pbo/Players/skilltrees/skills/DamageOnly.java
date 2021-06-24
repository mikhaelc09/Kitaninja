package istts.pbo.Players.skilltrees.skills;

public class DamageOnly extends Skill{
    int dmg;
    int manacost;
    public DamageOnly(String name, String skillJob, String iconPath, String description, int dmg, int manacost) {
        super(name, skillJob, iconPath, description);
        this.dmg = dmg;
        this.manacost = manacost;
    }

    public int[] useSkill(){
        return new int[]{dmg,manacost};
    }

}
