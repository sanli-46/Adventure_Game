import java.util.Random;

public abstract class BattelLoc extends Location{

private Obstacie obstacie;
private String aword;


private int maxObstacie;
    public BattelLoc(Player player, String name,Obstacie obstacie,String aword,int maxObstacie) {
        super(player, name);
        this.obstacie=obstacie;
        this.aword=aword;
        this.maxObstacie=maxObstacie;

    }

    @Override
    boolean onLocation() {
        int obsNum=this.rondomObstacleNumber();
        System.out.println("Şuan buradasınız :"+this.getName());
        System.out.println("Dikkatli ol "+ obsNum+ "  "+this.getObstacie().getName()+" buralarda!!!!");
        System.out.print("<S>avaş veya <K>aç  : ");
        String selectCase=inp.nextLine();
        selectCase=selectCase.toUpperCase() ;
        if (selectCase.equals("S")){
           if (combat(obsNum)){
               System.out.println(this.getName()+ " tüm düşmanları yendiniz");
           if (this.aword.equals("Food")&&getPlayer().getInventory().isFood()== false){
               this.getPlayer().getInventory().setFood(true);
               System.out.println(this.aword+ " envantere eklendi .");
           } else if (this.aword.equals("Water")&&getPlayer().getInventory().isWater() == false) {
               this.getPlayer().getInventory().setWater(true);
               System.out.println(this.aword+" envantere eklendi .");
           } else if (this.aword.equals("firewood")&& getPlayer().getInventory().isFriewood()==false) {
               this.getPlayer().getInventory().setWater(true);
               System.out.println(this.aword+ "envantere eklendi .");
           }

               return true;
           }

        }
        if(this.getPlayer().getHealth()<=0){

            System.out.println("Öldünüz !!!");
            return false;
        }
        return true;
    }
    public boolean combat(int obsNum){

            for(int i=1;i<=obsNum;i++){
                this.getObstacie().setHealth(this.getObstacie().getDefHealt());
                playerStats();
                obstacStats(i);
                while (this.getPlayer().getHealth()>0 &&this.getObstacie().getHealth()>0){
                    System.out.println("----------------");
                    System.out.print("<V>ur veya <K>aç : ");

                    String selectCombat=inp.nextLine().toUpperCase();
                    if (selectCombat.equals("V")){
                        System.out.println("---------------------");
                        System.out.println("Siz vurdunuz ! ");

                       this.getObstacie().setHealth(this.getObstacie().getHealth() - this.getPlayer().getTotalDamage());
                        afterHit();
                        if(this.getObstacie().getHealth()>0){
                            System.out.println();
                            System.out.println("----------------");
                            System.out.println("Canavar size vurdu !");
                         int obstacleDamage=this.getObstacie().getDamage()-this.getPlayer().getInventory().getArmor().getBlock();
                         if (obstacleDamage<0){
                             obstacleDamage=0;
                         }
                            this.getPlayer().setHealth(this.getPlayer().getHealth()-obstacleDamage);
                         afterHit();
                        }
                    }else {
                        return false;
                    }
                }

                if (this.getObstacie().getHealth()<this.getPlayer().getHealth()){
                    System.out.println(this.getObstacie().getName()+" Öldürdünüz !!!");
                    System.out.println(this.getObstacie().getAward()+" para kazandınız :)");
                    this.getPlayer().setMoney(this.getPlayer().getMoney()+this.getObstacie().getAward());
                    System.out.println("GÜncel Paranız : "+this.getPlayer().getMoney());
                }else {
                    return false;
                }
            }



        return false;
    }
    public void afterHit(){
        System.out.println("Canınız : " +this.getPlayer().getHealth());
        System.out.println( this.getObstacie().getName()+" Canı : " +this.getObstacie().getHealth());
        System.out.println("");
    }
    public void  playerStats(){
        System.out.println("Oyuncu değerleri : ");
        System.out.println("--------------------------------------------");
        System.out.println("Sağlık : "+ this.getPlayer().getHealth());
        System.out.println("Hasar : "+ this.getPlayer().getTotalDamage());
        System.out.println("Para : "+getPlayer().getMoney());
        System.out.println("Silah : "+this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Zırh : "+ this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Bloklama : "+this.getPlayer().getInventory().getArmor().getBlock());

    }
    public void obstacStats(int i){
        System.out.println(i+"."+this.getObstacie().getName()+" Degerleri");
        System.out.println("----------------------------------------------");
        System.out.println("Sağlık : "+this.getObstacie().getHealth());
        System.out.println("Hasar : "+this.getObstacie().getDamage());
        System.out.println("Ödülü : "+this.getObstacie().getAward());
    }


    public int rondomObstacleNumber(){
        Random r=new Random();
        return r.nextInt(this.maxObstacie)+1;
    }


    public int getMaxObstacie() {
        return maxObstacie;
    }

    public void setMaxObstacie(int maxObstacie) {
        this.maxObstacie = maxObstacie;
    }

    public Obstacie getObstacie() {
        return obstacie;
    }

    public void setObstacie(Obstacie obstacie) {
        this.obstacie = obstacie;
    }

    public String getAword() {
        return aword;
    }

    public void setAword(String aword) {
        this.aword = aword;
    }
}
