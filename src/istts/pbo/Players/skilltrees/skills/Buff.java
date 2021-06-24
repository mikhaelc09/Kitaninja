package istts.pbo.Players.skilltrees.skills;

public class Buff extends Skill{
    int tipe;
    int value;
    int turn;
    int manacost;
    public Buff(String name, String skillJob, String iconPath, String description, int tipe, int value, int turn, int manacost) {
        super(name, skillJob, iconPath, description);
        this.value = value;
        this.tipe = tipe;
        this.turn = turn;
        this.manacost = manacost;
    }

    public int[] useskill(){
        return new int[]{tipe,value,turn,manacost};
    }
}
