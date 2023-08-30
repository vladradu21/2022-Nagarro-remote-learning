package com.nagarro.rl.week3.p1;

public class Game {
    public static void main(String[] args) {
        Hero myHero = new Hero("Chuck", 0, 100, 10, 5);
        Monster cyclopsMonsters = new Cyclop("Rock skin cyclops", 30, 5, 5);
        Monster wizardsMonsters = new Wizard("Fire wizard", 10, 10, 0);

        loadBattleScenario1(myHero, cyclopsMonsters, wizardsMonsters);
    }

    public static void loadBattleScenario1(Hero chuck, Monster cyclopM, Monster wizardM){
        chuck.attack(cyclopM);
        cyclopM.useMagicalSkills();
        chuck.attack(cyclopM);
        wizardM.attack(chuck);
        wizardM.useMagicalSkills();
        wizardM.attack(chuck);
    }
}
