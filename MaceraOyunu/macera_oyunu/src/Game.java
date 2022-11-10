import java.util.Scanner;

public class Game {
    private Scanner inp =new Scanner (System.in);
    public void start(){
        System.out.println("Macera Oyununa Hoşgeldiniz.");
        System.out.print("Lütfen bir isim giriniz : ");
        String playerName= inp.nextLine();
        Player player=new Player(playerName);
        System.out.println(player.getName()+ " Bu Karanlık Dünyaya Hoşgeldin :)");
        player.selecktChar();
        while (true){

            Location location =null;
           player.printInfo();
            System.out.println("");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println(" ");
            System.out.println("Gitmek istenilen haritayı seçin  ");
            System.out.println("Haritalar .");
            System.out.println("1- Güvenli Ev");
            System.out.println("2- Mağaza");
            System.out.println("3- Mağara");
            System.out.println("4- Orman");
            System.out.println("5- Nehir");
            System.out.println("6- Maden");
            System.out.print("Seçim : ");
            int selectLoc= inp.nextInt();
            switch (selectLoc){
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location= new ToolStore(player);
                    break;
                case 3:
                    if (!player.getInventory().isFood()){
                    location=new Cave(player);
                    }
                    break;
                case 4:
                    if (!player.getInventory().isFriewood()){
                    location=new Forest(player);
                    }
                    break;
                case 5:
                    if (!player.getInventory().isWater()) {
                        location = new River(player);
                    }
                    break;
                case 6:
                    location=new Coal(player);
                    break;
                default:
                    location =new SafeHouse(player);
            }
            if (getClass().getName().equals("SafeHouse")){
                if (player.getInventory().isFriewood()&& player.getInventory().isFood()&& player.getInventory().isWater()){
                    System.out.println("Tebrikler Oyunu Kazandınız");
                    break;
                }
            }
            if (! location.onLocation())
            {
                System.out.println("GAME OVER !!!!!");
             break;
            }else {

            }


        }



    }




}
