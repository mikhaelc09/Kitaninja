package istts.pbo.Classes;

import istts.pbo.Players.Stat;

public class Ninjutsu extends Job {
    public Ninjutsu(){
        super(new Stat(80,25,15,0,30,100,0,10),
                "Ninjutsu", "Ninjutsu", "src/istts/pbo/res/sprites/ninjutsu.gif");

    }
}
class Kenjutsu extends Ninjutsu {
    public Kenjutsu(Job a){
        getStats().setHealth(80);
        getStats().setAttack(25);
        getStats().setDefense(15);
        getStats().setMana(0);
        getStats().setSpeed(30);
        setClassname("Kenjutsu");
    }
}

class Shurikenjutsu extends Ninjutsu {
    public Shurikenjutsu(Job b){
        getStats().setHealth(85);
        getStats().setAttack(30);
        getStats().setDefense(15);
        getStats().setMana(0);
        getStats().setSpeed(40);
        setClassname("Shurikenjutsu");
    }
}

class Kayakujutsu extends Ninjutsu {
    public Kayakujutsu(Job c){
        getStats().setHealth(90);
        getStats().setAttack(30);
        getStats().setDefense(15);
        getStats().setMana(0);
        getStats().setSpeed(35);
        setClassname("Kayakajutsu");
    }
}

class Shinobi extends Ninjutsu {
    public Shinobi(Job d){
        getStats().setHealth(100);
        getStats().setAttack(25);
        getStats().setDefense(15);
        getStats().setMana(0);
        getStats().setSpeed(30);
        setClassname("Shinobi");
    }
}
