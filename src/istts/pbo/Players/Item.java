package istts.pbo.Players;

public abstract class Item implements java.io.Serializable{
    private String name;
    private int stat;
    private int cost;
    private String spritePath;
    private int upgradecost;


    public Item(String name, int stat, int cost, String spritePath, int upgradecost) {
        this.name = name;
        this.stat = stat;
        this.cost = cost;
        this.spritePath = spritePath;
        this.upgradecost=upgradecost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStat() {
        return stat;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setStat(int stat) {
        this.stat = stat;
    }

    public String getSpritePath() {
        return spritePath;
    }

    public void setSpritePath(String spritePath) {
        this.spritePath = spritePath;
    }

    public int getUpgradecost() {
        return upgradecost;
    }

    public void setUpgradecost(int upgradecost) {
        this.upgradecost = upgradecost;
    }
}