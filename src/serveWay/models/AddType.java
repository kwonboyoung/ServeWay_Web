package serveWay.models;

public enum AddType {
	EXTRA(1), DRINK(2), COOKIE(3);
	
    private int code;
    private AddType(int c) {
        code = c;
    }
    public int getCode() {
        return code;
    }
}
