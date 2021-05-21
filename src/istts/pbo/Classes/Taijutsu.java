package istts.pbo.Classes;

import istts.pbo.Players.Stat;

public class Taijutsu extends Job {
    public Taijutsu(){
        super(new Stat(100,30,20,50,15,0,0,10),
                "Taijutsu", "Taijutsu", "src/istts/pbo/res/sprites/taijutsu.gif");

    }
}
class Taekwondo extends Taijutsu {
    public Taekwondo(Job ab){
        getStats().setHealth(90);
        getStats().setAttack(30);
        getStats().setDefense(20);
        getStats().setMana(50);
        getStats().setSpeed(15);
        setClassname("Taekwondo");
    }
}

class Kungfu extends Taijutsu {
    public Kungfu(Job ac){
        getStats().setHealth(110);
        getStats().setAttack(30);
        getStats().setDefense(15);
        getStats().setMana(60);
        getStats().setSpeed(30);
        setClassname("Kungfu");
    }
}

class Aikido extends Taijutsu {
    public Aikido(Job ad){
        getStats().setHealth(140);
        getStats().setAttack(25);
        getStats().setDefense(35);
        getStats().setMana(60);
        getStats().setSpeed(30);
        setClassname("Aikido");
    }
}

class Sumo extends Taijutsu {
    public Sumo(Job ae){
        getStats().setHealth(180);
        getStats().setAttack(15);
        getStats().setDefense(35);
        getStats().setMana(50);
        getStats().setSpeed(15);
        setClassname("Sumo");
    }
}