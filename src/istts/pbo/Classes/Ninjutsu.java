package istts.pbo.Classes;

import istts.pbo.Players.Stat;
import istts.pbo.Players.skilltrees.skills.*;

public class Ninjutsu extends Job {
    @SuppressWarnings("unchecked")
    public Ninjutsu(){
        super(new Stat(80,25,15,20,30,6,0,10),
                "Ninjutsu", "Ninjutsu", "src/istts/pbo/res/sprites/ninjutsu.gif");
        this.getSkillTree().addSkill(new DamageOnly("Shuriken Throw", "Ninjutsu", "src/istts/pbo/res/IconSkill/Ninjutsu-ShurikenThrow.png","Melempar sebuah shuriken untuk menyakiti musuh", (int) (20+getStats().getAttack()*0.5),1));
        this.getSkillTree().addSkill(new Mana("Backpack", "Ninjutsu", "src/istts/pbo/res/IconSkill/Ninjutsu-Backpack.png","Menambah kapasitas ransel untuk menambah weapon",2));
        this.getSkillTree().addSkill(new DamageOnly("Caltrops", "Ninjutsu", "src/istts/pbo/res/IconSkill/Ninjutsu-Caltrops.png","meletakkan duri duri yang membuat musuh terdamage",30,3));

        this.getSkillTree().addSkill(new DamageOnly("Oni Giri", "Kenjutsu", "src/istts/pbo/res/IconSkill/Kenjutsu-Onigiri.png","Menebas sangat kuat pada musuh", (int) (getStats().getAttack()*1.5), 0));
        this.getSkillTree().addSkill(new DamageOnly("Hekireki Issen", "Kenjutsu", "src/istts/pbo/res/IconSkill/Kenjutsu-HekirekiIssen.png","Tebasan maju secepat kilat", getStats().getAttack()+ getStats().getSpeed(), 0));
        this.getSkillTree().addSkill(new DamageOnly("Startburst Stream", "Kenjutsu", "src/istts/pbo/res/IconSkill/Kenjutsu-StarburstStream.png","Tebasan beruntun dan mematikan",3* getStats().getAttack(),0));

        this.getSkillTree().addSkill(new DamageOnly("Poison Shuriken", "Shurikenjutsu", "src/istts/pbo/res/IconSkill/Shurikenjutsu-PoisonShuriken.png","Melemparkan jarum beracun",20,1));
        this.getSkillTree().addSkill(new DamageOnly("Kunai With Chain", "Shurikenjutsu", "src/istts/pbo/res/IconSkill/Shurikenjutsu-KunaiWithChain.png","Melempar kunai berrantai lalu menarik musuh",30,1));
        this.getSkillTree().addSkill(new DamageOnly("Bloonjitsu", "Shurikenjutsu", "src/istts/pbo/res/IconSkill/Shurikenjutsu-Bloonjitsu.png","Melemparkan 5 shuriken pada musuh",100,5));

        this.getSkillTree().addSkill(new StatusEffect("Smoke Bomb", "Kayakujutsu", "src/istts/pbo/res/IconSkill/Kayakujutsu-SmokeBomb.png","Melemparkan bom berasap",2,50,2,2));
        this.getSkillTree().addSkill(new DamageOnly("Flare", "Kayakujutsu", "src/istts/pbo/res/IconSkill/Kayakujutsu-Flare.png","Melemparkan suar pada musuh ",20+ getStats().getAttack(),2));
        this.getSkillTree().addSkill(new DamageOnly("C4", "Kayakujutsu", "src/istts/pbo/res/IconSkill/Kayakujutsu-C4.png","Menanam bom yang akan meledak setelah 3 turn",50+5* getStats().getAttack(),5));

        this.getSkillTree().addSkill(new StatusEffect("Kawarimi no Jutsu", "Shinobi", "src/istts/pbo/res/IconSkill/Shinobi-KawarimiNoJutsu.png","Menukar diri dengan benda lain apabila terkena damage",4,1,1,3));
        this.getSkillTree().addSkill(new Buff("Chocho", "Shinobi", "src/istts/pbo/res/IconSkill/Shinobi-Chocho.png","Mengintai musuh untuk mengetahui serangan musuh berikutnya",2,100,2,3));
        this.getSkillTree().addSkill(new DamageOnly("Hakke", "Shinobi", "src/istts/pbo/res/IconSkill/Shinobi-Hakke.png","Menyerang titik lemah musuh",2* getStats().getAttack(),7));

        ((Skill)this.getSkillTree().getAt(0)).setUnlocked(true);
    }
}
