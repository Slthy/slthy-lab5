public class Enigma{

    private String rotorInit[] = {"#GNUAHOVBIPWCJQXDKRYELSZFMT",
        "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY",
        "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"};


    private Rotor rotors[];
        
    public Enigma(int id1, int id2, int id3, String start){

        rotors = new Rotor[3];
        rotors[0] = new Rotor(rotorInit[id1-1], start.charAt(0));
        rotors[1] = new Rotor(rotorInit[id2-1], start.charAt(1));
        rotors[2] = new Rotor(rotorInit[id3-1], start.charAt(2));
        
    }

    public String encrypt(String message) {
        String output = "";

        for (char c : message.toCharArray()) {
            int step_one = rotors[0].indexOf(c);
            char step_two = rotors[2].charAt(step_one);
            int step_three = rotors[1].indexOf(step_two);
            char step_four = rotors[2].charAt(step_three);
            output += step_four;

            rotate();
        }
        return output;
    }

    public String decrypt(String message) {
        String output = "";

        for (char c : message.toCharArray()) {
            int step_one = rotors[2].indexOf(c);
            char step_two = rotors[1].charAt(step_one);
            int step_three = rotors[2].indexOf(step_two);
            char step_four = rotors[0].charAt(step_three);
            output += step_four;

            rotate();
        }
        return output.toString();
    }

    
    private void rotate(){
        if(rotors[0].rotate()){
            if(rotors[1].rotate()){
                rotors[2].rotate();
            }
        }
    }
}