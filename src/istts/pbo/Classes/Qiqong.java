package istts.pbo.Classes;

import istts.pbo.Players.skilltrees.SkillTree;
import istts.pbo.Players.skilltrees.skills.Skill;

public class Qiqong extends Job {
    SkillTree<Skill> skilltree = new SkillTree<>();

    public Qiqong() {
        super(70,25,15,150,10,1,0,0,"qiqong");
        skilltree.addDMG("Hadouken",20,0,0,20);
    }
}
class Fire extends Qiqong{
    public Fire(Job ba){
        this.health=70;
        this.attack=45;
        this.def=15;
        this.mana=250;
        this.speed=10;
        this.classname="Fire";
    }
}

class Water extends Qiqong{
    public Water(Job bb){
        this.health=80;
        this.attack=30;
        this.def=20;
        this.mana=200;
        this.speed=10;
        this.classname="Water";
    }
}

class Wind extends Qiqong{
    public Wind(Job bc){
        this.health=75;
        this.attack=35;
        this.def=15;
        this.mana=200;
        this.speed=10;
        this.classname="Wind";

    }

}

class Earth extends Qiqong{
    public Earth(Job bd){
        this.health=100;
        this.attack=25;
        this.def=25;
        this.mana=150;
        this.speed=10;
        this.classname="Earth";

    }
}
