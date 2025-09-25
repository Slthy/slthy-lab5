public class Rotor {

    
    private String rotorValues;
    private char startChar;

    private boolean rotate_upper;
    private int rotations;

        
    public Rotor(String v, char c){
        this.rotorValues = new String(v);
        this.startChar = c;

        
        while(!this.rotate());
            
    }
    
    public boolean rotate(){
        char last_char = this.rotorValues.charAt(rotorValues.length() - 1);
        this.rotorValues = last_char + rotorValues.substring(0, rotorValues.length() - 1);
        return rotorValues.charAt(0) == this.startChar;
        
    }
    

    public int indexOf(char c){
        for(int idx = 0; idx < rotorValues.length(); idx++){
            if(rotorValues.charAt(idx) == c) return idx;
        }
        return -1;
    }

    public char charAt(int idx){
        return this.rotorValues.charAt(idx);
    }
}
    