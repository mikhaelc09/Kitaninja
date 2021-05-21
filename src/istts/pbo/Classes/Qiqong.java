package istts.pbo.Classes;

import istts.pbo.Players.Stat;
import istts.pbo.Players.skilltrees.SkillTree;
import istts.pbo.Players.skilltrees.skills.Buff;
import istts.pbo.Players.skilltrees.skills.DamageOnly;
import istts.pbo.Players.skilltrees.skills.Skill;

public class Qiqong extends Job {
    @SuppressWarnings("unchecked")
    public Qiqong() {
        super(new Stat(70,25,15,150,10,0,0,10),
                "Qiqong", "Qiqong", "src/istts/pbo/res/sprites/qigong.gif");
        
    }
}
class Fire extends Qiqong{
    public Fire(Job ba){
        getStats().setHealth(70);
        getStats().setAttack(45);
        getStats().setDefense(15);
        getStats().setMana(250);
        getStats().setSpeed(10);
        setClassname("Fire");
    }
}

class Water extends Qiqong{
    public Water(Job bb){
        getStats().setHealth(80);
        getStats().setAttack(30);
        getStats().setDefense(20);
        getStats().setMana(200);
        getStats().setSpeed(10);
        setClassname("Water");
    }
}

class Wind extends Qiqong{
    public Wind(Job bc){
        getStats().setHealth(75);
        getStats().setAttack(35);
        getStats().setDefense(15);
        getStats().setMana(200);
        getStats().setSpeed(10);
        setClassname("Wind");
    }

}

class Earth extends Qiqong{
    public Earth(Job bd){
        getStats().setHealth(100);
        getStats().setAttack(25);
        getStats().setDefense(25);
        getStats().setMana(150);
        getStats().setSpeed(10);
        setClassname("Earth");
    }
}
