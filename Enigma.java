public class Enigma{

    private String rotorInit[] = {"#GNUAHOVBIPWCJQXDKRYELSZFMT",
        "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY",
        "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"};


    private Rotor rotors[];
        
    public Enigma(int id1, int id2, int id3, String start){

        rotors = new Rotor[3];
        rotors[0] = new Rotor(rotorInit[id1-1], start.charAt(0));   // inner rotor
        rotors[1] = new Rotor(rotorInit[id2-1], start.charAt(1));   // middle rotor
        rotors[2] = new Rotor(rotorInit[id3-1], start.charAt(2));   // outer rotor
        
    }


    public String decrypt(String message){        
        String output = "";
        for (char c : message.toCharArray()){
            char step_one = this.rotors[2].charAt(this.rotors[0].indexOf(c));
            char step_two = this.rotors[1].charAt(this.rotors[2].indexOf(step_one));
            output += this.rotors[2].charAt(this.rotors[1].indexOf(step_two));
            //rotate
        }
        return output;
    }


    
    public String encrypt(String message){
        String output = "";
        for (char c : message.toCharArray()){
            char step_one = this.rotors[2].charAt(this.rotors[1].indexOf(c));
            char step_two = this.rotors[1].charAt(this.rotors[2].indexOf(step_one));
            output +=  this.rotors[2].charAt(this.rotors[0].indexOf(step_two));

            //rotate
        }
        return output;
    }

    
    private void rotate(){
        if(rotors[0].rotate()){
            if(rotors[1].rotate()){
                rotors[2].rotate();
            }
        }
    }
    
}