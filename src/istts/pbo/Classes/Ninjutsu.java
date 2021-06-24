package istts.pbo.Classes;

import istts.pbo.Players.Stat;
import istts.pbo.Players.skilltrees.skills.Buff;
import istts.pbo.Players.skilltrees.skills.DamageOnly;
import istts.pbo.Players.skilltrees.skills.Skill;
import istts.pbo.Players.skilltrees.skills.StatusEffect;

public class Ninjutsu extends Job {
    @SuppressWarnings("unchecked")
    public Ninjutsu(){
        super(new Stat(80,25,15,20,30,6,0,10),
                "Ninjutsu", "Ninjutsu", "src/istts/pbo/res/sprites/ninjutsu.gif");
        this.getSkillTree().addSkill(new StatusEffect("Shuriken Throw", "Ninjutsu", "src/istts/pbo/res/IconSkill/Ninjutsu-ShurikenThrow.png","Melempar sebuah shuriken untuk menyakiti musuh"));
        this.getSkillTree().addSkill(new Buff("Backpack", "Ninjutsu", "src/istts/pbo/res/IconSkill/Ninjutsu-Backpack.png","Menambah kapasitas ransel untuk menambah weapon"));
        this.getSkillTree().addSkill(new StatusEffect("Caltrops", "Ninjutsu", "src/istts/pbo/res/IconSkill/Ninjutsu-Caltrops.png","meletakkan duri duri yang membuat musuh terdamage"));

        this.getSkillTree().addSkill(new StatusEffect("Oni Giri", "Kenjutsu", "src/istts/pbo/res/IconSkill/Kenjutsu-Onigiri.png","Menebas sangat kuat pada musuh"));
        this.getSkillTree().addSkill(new StatusEffect("Hekireki Issen", "Kenjutsu", "src/istts/pbo/res/IconSkill/Kenjutsu-HekirekiIssen.png","Tebasan maju secepat kilat"));
        this.getSkillTree().addSkill(new StatusEffect("Startburst Stream", "Kenjutsu", "src/istts/pbo/res/IconSkill/Kenjutsu-StarburstStream.png","Tebasan beruntun dan mematikan"));

        this.getSkillTree().addSkill(new StatusEffect("Poison Shuriken", "Shurikenjutsu", "src/istts/pbo/res/IconSkill/Shurikenjutsu-PoisonShuriken.png","Melemparkan jarum beracun"));
        this.getSkillTree().addSkill(new StatusEffect("Kunai With Chain", "Shurikenjutsu", "src/istts/pbo/res/IconSkill/Shurikenjutsu-KunaiWithChain.png","Melempar kunai berrantai lalu menarik musuh"));
        this.getSkillTree().addSkill(new StatusEffect("Bloonjitsu", "Shurikenjutsu", "src/istts/pbo/res/IconSkill/Shurikenjutsu-Bloonjitsu.png","Melemparkan 5 shuriken pada musuh"));

        this.getSkillTree().addSkill(new Buff("Smoke Bomb", "Kayakujutsu", "src/istts/pbo/res/IconSkill/Kayakujutsu-SmokeBomb.png","Melemparkan bom berasap"));
        this.getSkillTree().addSkill(new StatusEffect("Flare", "Kayakujutsu", "src/istts/pbo/res/IconSkill/Kayakujutsu-Flare.png","Melemparkan suar pada musuh "));
        this.getSkillTree().addSkill(new StatusEffect("C4", "Kayakujutsu", "src/istts/pbo/res/IconSkill/Kayakujutsu-C4.png","Menanam bom yang akan meledak setelah 3 turn"));

        this.getSkillTree().addSkill(new Buff("Kawarimi no Jutsu", "Shinobi", "src/istts/pbo/res/IconSkill/Shinobi-KawarimiNoJutsu.png","Menukar diri dengan benda lain apabila terkena damage"));
        this.getSkillTree().addSkill(new Buff("Chocho", "Shinobi", "src/istts/pbo/res/IconSkill/Shinobi-Chocho.png","Mengintai musuh untuk mengetahui serangan musuh berikutnya"));
        this.getSkillTree().addSkill(new StatusEffect("Hakke", "Shinobi", "src/istts/pbo/res/IconSkill/Shinobi-Hakke.png","Menyerang titik lemah musuh"));

        ((Skill)this.getSkillTree().getAt(0)).setUnlocked(true);
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
