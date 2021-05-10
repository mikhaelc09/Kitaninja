package istts.pbo.Players;

public abstract class Item {
    private String name;
    private int stat;

    public Item(String name, int stat) {
        this.name = name;
        this.stat = stat;
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

    public void setStat(int stat) {
        this.stat = stat;
    }
}

//Inherit

class Head extends Item{
    public Head(String name, int stat) {
        super(name, stat);
    }
}

class Body extends Item{
    public Body(String name, int stat) {
        super(name, stat);
    }
}

class Boots extends Item{
    public Boots(String name, int stat) {
        super(name, stat);
    }
}

class Weapon extends Item{
    public Weapon(String name, int stat) {
        super(name, stat);
    }
}

class Accesories extends Item{
    public Accesories(String name, int stat) {
        super(name, stat);
    }
}

class Tools extends Item{
    public Tools(String name, int stat) {
        super(name, stat);
    }
}
