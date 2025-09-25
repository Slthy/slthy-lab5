public class Rotor {

    private String rotorValues;
    private final char startChar;
    
    public Rotor(String v, char c) {

        this.rotorValues = v;
        this.startChar = c;

        while (rotorValues.charAt(0) != startChar) {
            rotate();
        }
    }

    public boolean rotate() {
        char last = rotorValues.charAt(rotorValues.length() - 1);
        rotorValues = last + rotorValues.substring(0, rotorValues.length() - 1);
        return rotorValues.charAt(0) == startChar;
    }

    public int indexOf(char c) {
        return rotorValues.indexOf(c);
    }

    public char charAt(int idx) {
        return rotorValues.charAt(idx);
    }
}
