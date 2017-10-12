package serveWay.models;

public enum MaterialType {
	BREAD(1), VEGETABLE(2), SOURCE(3);
	
    private int code;
    private MaterialType(int c) {
        code = c;
    }
    public int getCode() {
        return code;
    }
}
