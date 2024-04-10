package so;

public enum ProcessPriority {
BAIXA(0),MEDIA(1),ALTA(2),ALTISSIMA(2000);

	private int level;
ProcessPriority(int level) {
	this.level = level;
	// TODO Auto-generated constructor stub
}
public int getLevel() {
	return level;
}

}
