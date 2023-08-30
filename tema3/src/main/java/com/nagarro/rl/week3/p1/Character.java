package com.nagarro.rl.week3.p1;

public abstract class Character {
    private int life;
    private int attack;
    private int defense;

    public Character(int life, int attack, int defense) {
        this.life = life;
        this.attack = attack;
        this.defense = defense;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    @Override
    public String toString() {
        return ", life= " + life + ", attack= " + attack + ", defense= " + defense;
    }
}
