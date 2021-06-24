package istts.pbo.Players.skilltrees.skills;

public class Heal extends Skill{
    int value;
    int cost;
    public Heal(String name, String skillJob, String iconPath, String description, int value,int cost) {
        super(name, skillJob, iconPath, description);
        this.value = value;
        this.cost = cost;
    }

    public int[] useSkill(){
        return new int[]{value,cost};
    }
}
