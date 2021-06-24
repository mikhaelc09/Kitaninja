package istts.pbo.Classes;

import istts.pbo.Players.Stat;
import istts.pbo.Players.skilltrees.SkillTree;
import istts.pbo.Players.skilltrees.skills.Buff;
import istts.pbo.Players.skilltrees.skills.DamageOnly;
import istts.pbo.Players.skilltrees.skills.Skill;
import istts.pbo.Players.skilltrees.skills.StatusEffect;

public class Qiqong extends Job {
    @SuppressWarnings("unchecked")
    public Qiqong() {
        super(new Stat(70,25,15,150,10,6,0,10),
                "Qiqong", "Qiqong", "src/istts/pbo/res/sprites/qigong.gif");
        this.getSkillTree().addSkill(new StatusEffect("Hadouken", "Qiqong", "src/istts/pbo/res/IconSkill/Qiqong-Hadouken.png","Melempar sebuah bola energi"));
        this.getSkillTree().addSkill(new Buff("Calm Mind",  "Qiqong", "src/istts/pbo/res/IconSkill/Qiqong-CalmMind.png","Menambah Mana"));
        this.getSkillTree().addSkill(new StatusEffect("Kamehameha", "Qiqong", "src/istts/pbo/res/IconSkill/Qiqong-Kamehameha.png","Mengumpulkan Mana untuk menyerang musuh dengan bom ki"));

        this.getSkillTree().addSkill(new StatusEffect("Hinotama", "Fire", "src/istts/pbo/res/IconSkill/Fire-Hinotama.png","Melemparkan sebuah bola api besar"));
        this.getSkillTree().addSkill(new Buff("Heatblast Form",  "Fire", "src/istts/pbo/res/IconSkill/Fire-Heatblast.png","Menyatukan wujud api dengan diri untuk menambah kekuatan namun kehilangan nyawa"));
        this.getSkillTree().addSkill(new StatusEffect("Explosion","Fire","src/istts/pbo/res/IconSkill/Fire-Explosion.png","Mengeluarkan ledakan besar dengan seluruh mana"));

        this.getSkillTree().addSkill(new StatusEffect("Rasengan", "Wind", "src/istts/pbo/res/IconSkill/Wind-Rasengan.png","Membuat pusaran angin di telapak tangan untuk menyakiti musuh"));
        this.getSkillTree().addSkill(new Buff("Wind of Nature", "Wind", "src/istts/pbo/res/IconSkill/Wind-WindOfNature.png","Memperkuat diri dengan elemen angin untuk menambah speed dan evasion"));
        this.getSkillTree().addSkill(new StatusEffect("Divine Sandstorm", "Wind", "src/istts/pbo/res/IconSkill/Wind-DivineSandstorm.png","Membuat 2 tornado di masing masing tangan dengan arah berbeda serta memperdalam luka musuh"));

        this.getSkillTree().addSkill(new StatusEffect("Mystic Snake", "Water", "src/istts/pbo/res/IconSkill/Water-MysticSnake.png","Membuat inkarnasi ular yang menyedot mana musuh"));
        this.getSkillTree().addSkill(new StatusEffect("Water Prison", "Water", "src/istts/pbo/res/IconSkill/Water-WaterPrison.png", "Membuat penjara air untuk memerangkap musuh"));
        this.getSkillTree().addSkill(new StatusEffect("Daiguren Hyoinmaru", "Water","src/istts/pbo/res/IconSkill/Water-DaigurenHyorinmaru.png","Membuat naga es yang membekukan musuh"));

        this.getSkillTree().addSkill(new StatusEffect("Sand Attack", "Earth", "src/istts/pbo/res/IconSkill/Sand-SandThrow.png","Melemparkan pasir untuk membutakan musuh"));
        this.getSkillTree().addSkill(new StatusEffect("Summon Thwomp", "Earth", "src/istts/pbo/res/IconSkill/Sand-SummonTwhomp.png","Mensummon batu berduri yang bisa stun musuh"));
        this.getSkillTree().addSkill(new Buff("Harden", "Earth", "src/istts/pbo/res/IconSkill/Sand-Harden.png","Memperkeras diri untuk meningkatkan defense"));

        ((Skill)this.getSkillTree().getAt(0)).setUnlocked(true);
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
