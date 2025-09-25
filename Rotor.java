public class Rotor {

    
    private String rotorValues;
    private char startChar;
        
    public Rotor(String v, char c){
        this.rotorValues = v;
        this.startChar = c;

        
        while(!this.rotate());
            
    }
    
    public boolean rotate() {
        rotorValues = rotorValues.substring(1) + rotorValues.charAt(0);
        return rotorValues.charAt(0) == startChar;
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
    