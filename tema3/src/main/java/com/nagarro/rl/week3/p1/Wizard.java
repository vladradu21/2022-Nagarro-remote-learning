package com.nagarro.rl.week3.p1;

public class Wizard extends Monster {
    public Wizard(String race, int life, int attack, int defense) {
        super(race, life, attack, defense);
    }

    @Override
    public void useMagicalSkills() {
        System.out.println(this.getRace() + " attack increased by 10!");
        this.setAttack(this.getAttack() + 10);
    }
}
