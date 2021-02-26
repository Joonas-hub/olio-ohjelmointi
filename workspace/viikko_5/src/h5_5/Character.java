package h5_5;

public class Character {
	String characterType = "";
	String weaponType = "";
	
	public Character(int characterSelection, int weaponSelection) {
		switch (characterSelection) {
		case 1:
			characterType = "King";
			break;
		case 2:
			characterType = "Knight";
			break;
		case 3:
			characterType = "Queen";
			break;
		case 4:
			characterType = "Troll";
			break;
		}
		Weapon weapon = new Weapon(weaponSelection);
		weaponType = weapon.getWeapon();
	}
	public String[] getCharacter() {
		String[] character = new String[2];
		character[0] = characterType;
		character[1] = weaponType;
		return character;
		}
	
	public class Weapon{
		String weaponType;
		public Weapon(int weaponSelection) {
			switch (weaponSelection) {
			case 1:
				weaponType = "Knife";
				break;
			case 2:
				weaponType = "Axe";
				break;
			case 3:
				weaponType = "Sword";
				break;
			case 4:
				weaponType = "Club";
				break;
			}
		}
		public String getWeapon() {
			return weaponType;
		}
	}
}
