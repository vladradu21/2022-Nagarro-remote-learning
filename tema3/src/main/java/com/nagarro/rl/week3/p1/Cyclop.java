package com.nagarro.rl.week3.p1;

public class Cyclop extends Monster {
    public Cyclop(String race, int life, int attack, int defense) {
        super(race, life, attack, defense);
    }

    public void useMagicalSkills() {
        System.out.println(this.getRace() + " defense increased by 10!");
        this.setDefense(this.getDefense() + 10);
    }
}
