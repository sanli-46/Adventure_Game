public class Obstacie {
    private int id;
    private int damage;
    private int health;
    private  String name;
    private int award;

    private  int defHealt;

    public Obstacie(String name,int id, int damage, int health,int award) {
        this.id = id;
        this.damage = damage;
        this.health = health;
        this.defHealt = health;
        this.name=name;
        this.award=award;
    }

    public int getDefHealt() {
        return defHealt;
    }

    public void setDefHealt(int defHealt) {
        this.defHealt = defHealt;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health<0){
            health=0;
        }
        this.health = health;
    }
}
