public class ToolStore extends NormalLoc{
    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    boolean onLocation() {
        System.out.println("----------Magzaya hoşgeldiniz---------- ");
        System.out.println("1- Silahlar");
        System.out.println("2- Zırhlar ");
        System.out.println("3-Çıkış Yap");
        System.out.print("Seçim :");
        int selectCase= inp.nextInt();
        while (selectCase<1 || selectCase>3){
            System.out.println("Geçersiz değer, tekrar giriniz !!!!");
            selectCase= inp.nextInt();
        }
        switch (selectCase){
            case 1:
                printWeapon();
                buyWeapon();
                break;
            case 2:
                printArmor();
                buyArmor();
                break;
            case 3:
                System.out.println("Tekrar Bekleriz");
                return true ;

        }
        return true;
    }
    public void printWeapon(){
        System.out.println("----------Silahlar---------- ");
        System.out.println("");
        for (Weapon w:Weapon.weapon()) {
            System.out.println(w.getName() +"  Hasar = "+w.getDamage()+"  Para = "+w.getPrice());
        }

    }
    public void buyWeapon(){
        System.out.print("Bir  silah seçin :  ");
        int selectWeapon= inp.nextInt();
        while (selectWeapon<1 || selectWeapon>Weapon.weapon().length){
            System.out.println("Geçersiz değer, tekrar giriniz !!!!");
            selectWeapon= inp.nextInt();
        }
        Weapon selectedWeapon=Weapon.getWeaponObjByID(selectWeapon);
        if ( selectedWeapon!= null){
            if(selectedWeapon.getPrice() > this.getPlayer().getMoney() ){
                System.out.println("Yeterli paranız bulunmamaktadır !");
            }else {
                System.out.println(selectedWeapon.getName()+" silahını satın aldınız .");
                int balance =this.getPlayer().getMoney()-selectedWeapon.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("KAlan paranız : "+this.getPlayer().getMoney());
                this.getPlayer().getInventory().setWeapon(selectedWeapon);
                System.out.println("Silahınız :"+ getPlayer().getInventory().getWeapon().getName());
            }
        }
    }

    public  void printArmor(){
        System.out.println("--------------Zırhlar--------------");
        System.out.println("");
        for (Armor a:Armor.armors()) {
            System.out.println(a.getName() +"  Engelleme = "+a.getBlock()+"  Para = "+a.getPrice());
        }

    }
    public void buyArmor(){
        System.out.print("Bir  kalkan seçin :  ");
        int selectArmor= inp.nextInt();
        while (selectArmor<1 || selectArmor>Armor.armors().length){
            System.out.println("Geçersiz değer, tekrar giriniz !!!!");
            selectArmor= inp.nextInt();
        }
        Armor selectedArmor=Armor.getArmorObjByID(selectArmor);
        if ( selectedArmor!= null){
            if(selectedArmor.getPrice() > this.getPlayer().getMoney() ){
                System.out.println("Yeterli paranız bulunmamaktadır !");
            }else {
                System.out.println(selectedArmor.getName()+" kalkanını satın aldınız .");
                int balance =this.getPlayer().getMoney()-selectedArmor.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("Kalan paranız : "+this.getPlayer().getMoney());
                this.getPlayer().getInventory().setArmor(selectedArmor);
                System.out.println("Kalkanınız :"+ getPlayer().getInventory().getArmor().getName());
            }
        }
    }
}
