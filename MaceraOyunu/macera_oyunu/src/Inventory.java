public class Inventory {
   private Weapon weapon;
   private Armor armor;
   private boolean food;
   private boolean friewood;
   private boolean water;


    public Inventory() {
        this.weapon = new Weapon("Yumruk",-1,0,0);
        this.armor=new Armor("Kalkan yok",-1,0,0);
        this.food=false;
        this.friewood=false;
        this.water=false;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isFriewood() {
        return friewood;
    }

    public void setFriewood(boolean friewood) {
        this.friewood = friewood;
    }

    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }
}
