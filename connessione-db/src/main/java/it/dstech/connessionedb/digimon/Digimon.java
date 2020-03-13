package it.dstech.connessionedb.digimon;

public class Digimon {

	private String name;
	private int atk;
	private int def;
	private int hp;
	private int res;
	private String evo;

	public Digimon(String name, int atk, int def, int hp, int res, String evo) {
		super();
		this.name = name;
		this.atk = atk;
		this.def = def;
		this.hp = hp;
		this.res = res;
		this.evo = evo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getRes() {
		return res;
	}

	public void setRes(int res) {
		this.res = res;
	}

	public String getEvo() {
		return evo;
	}

	public void setEvo(String evo) {
		this.evo = evo;
	}
}
