import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int defhealth;
    private int money;
    private String name;
    private String charName;
    private Scanner inp=new Scanner(System.in);

    private Inventory inventory;
    public Player (String name)
    {
        this.name=name;
        this.inventory =new Inventory();
    }

    public void selecktChar(){


        GameChar[] charList ={new Samurai(),new Knight(),new Archer()};
        for(GameChar gameChar : charList){
            System.out.println("---------------------------------------------------------------------------");
            System.out.println( gameChar.getName()+" Karakterin :" + " Hasarı = "+gameChar.getDamage()+" Saglıgı = "+ gameChar.getHealth()+ " Parası = "+gameChar.getMoney());

        }
        System.out.println("-------------------------------------------------------------------------------");
        System.out.print("Lütfen bir karakter seçin : ");
        int selectChar= inp.nextInt();
        switch (selectChar){
            case 1:
                initPlayer(new Samurai());
                System.out.println("Samuray emrinde <!>");
                break;
            case 2:
                initPlayer(new Knight());
                System.out.println("Şovalye emrinde <?>");
                break;
            case 3:
                initPlayer(new Archer());
                System.out.println("Okçu emrinde <+>");
                break;
            default:
                initPlayer(new Samurai());
                System.out.println("Samuray emrinde <!>");

        }
    }
    public void initPlayer(GameChar gameChare){
        this.setDamage(gameChare.getDamage());
        this.setHealth(gameChare.getHealth());
        this.setDefhealth(gameChare.getHealth());
        this.setMoney(gameChare.getMoney());
    }

    public boolean isWin(Player player) {
        return getInventory().isWater() && getInventory().isFood() && getInventory().isFriewood();}



    public void printInfo(){
        System.out.println(
                " Silahınız :"+getInventory().getWeapon().getName() +
                " Kalkanınız :"+getInventory().getArmor().getName()+
                " Hasar : " + this.getTotalDamage()+
                " Sağlık : "+ this.getHealth()+
                " Para : "+ this.getMoney());
    }

public int getTotalDamage(){
    return damage + this.getInventory().getWeapon().getDamage();
}
    public int getDamage() {
        return damage ;
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

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getDefhealth() {
        return defhealth;
    }

    public void setDefhealth(int defhealth) {
        this.defhealth = defhealth;
    }
}
