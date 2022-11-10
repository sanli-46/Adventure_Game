# Adventure_Game
A text-based adventure game.

#Class Diagram;
ADVENTUREGAME

#Charcters;
Character	Id	Damage	Health	Money
-Samurai	1	5	21	15
-Archer	2	7	18	20
-Knight	3	8	24	5
#Monsters;
Monster	Id	Damage	Health	Money
-Zombie	1	3	10	4
-Vampire	2	4	14	7
-Bear	3	7	20	12
-Snake	4	Random	12	0
#Places;
-Safe House
Feature: Regenerating Health
-Cave
Monster : Zombie (1-3)
Attribute: War + Loot
Item: Food (Food)
-Forest
Monster: Vampire (1-3 Pieces)
Attribute: War + Loot
Item: Wood (Firewood)
-River
Monster : Bear (1-3 Pieces)
Attribute: War + Loot
Item: Water (Water)
-ToolStore
Feature: Buying Supporting Items
Weapon: Pistol, Sword, Rifle
Armor: Light, Medium, Heavy
A snippet of the game output:

![image](https://user-images.githubusercontent.com/81872331/201117314-f270b302-fc44-4b97-8468-bfea7b287e08.png)
