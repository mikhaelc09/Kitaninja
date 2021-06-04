package istts.pbo.Players;

import istts.pbo.Classes.Job;
import istts.pbo.Players.skilltrees.skills.Skill;

import java.util.ArrayList;

public class Player {

    private String name;
    private int gold;
    private int level;
    private int xp;
    private int skillPoint;
    private Stat stats;
    private Job playerClass;
    private Equipment equipment;
    private ArrayList<Item> items;
    private ArrayList<Skill> equippedSkills;

    public Player(String name, Job playerClass) {
        this.name = name;
        this.gold = 100;
        this.level = 1;
        this.xp = 0;
        this.skillPoint = 0;
        this.stats = playerClass.getStats();
        this.playerClass = playerClass;
        this.equipment = new Equipment();
        this.items = new ArrayList<>();
        this.equippedSkills = new ArrayList<>();
        this.items.add(new Tools("Tools",0,1,"src/istts/pbo/res/Item/Tools.png"));
        for (int i = 0; i < 24; i++) {
            this.items.add(new Weapon("-",0,0,"src/istts/pbo/res/Item/Blank.png"));
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public Stat getStats() {
        return stats;
    }

    public void setStats(Stat stats) {
        this.stats = stats;
    }

    public Job getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(Job playerClass) {
        this.playerClass = playerClass;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public ArrayList<Skill> getEquippedSkills() {
        return equippedSkills;
    }

    public void setEquippedSkills(ArrayList<Skill> equippedSkills) {
        this.equippedSkills = equippedSkills;
    }

    public int getSkillPoint() {
        return skillPoint;
    }

    public void setSkillPoint(int skillPoint) {
        this.skillPoint = skillPoint;
    }
}
