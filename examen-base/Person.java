import java.util.Random;

public class Person {
    private String name = "";
    private int age = 0;
    private String nss;
    private String sex = "H";
    private float weigth = 0;
    private float heigth = 0;

    Person(String name, int age, String nss, String sex, float weigth, float heigth) {
        this.name = name;
        this.age = age;
        this.nss = nss;
        this.sex = sex;
        this.weigth = weigth;
        this.heigth = heigth;
        createNSS();
    }

    Person() {
        createNSS();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public void setSex(String sex) {
        Boolean isValid = validateSex(sex);
        if (isValid) {
            this.sex = sex;
        }
    }

    public void setWeigth(float weigth) {
        this.weigth = weigth;
    }

    public void setHeigth(float heigth) {
        this.heigth = heigth;
    }

    public int calculateIMC() {

        float res = (weigth / (heigth * heigth));
        if (sex.equals("H") || sex.equals("h")) {
            return IMC(res, 20, 25);
        } else {
            return IMC(res, 19, 24);
        }
    }
    public boolean isAdult() {
        if (age >= 18) {
            return true;
        }
        return false;
    }

    public String getImc(int peso) {
        String imc = "";
        switch(peso) {
            case -1:
                imc = "Por debajo del peso";
            break;

            case 0: 
                imc = "Peso ideal";
            break;

            case 1:
                imc = "Sobre peso";
            break;
        }
        return imc;
     }

    private int IMC(float res, int value1, int value2) {
        if (res < value1) {
            return -1;
        }

        if (res <= value2) {
            return 0;
        }

        return 1;

    }

    private boolean validateSex(String sex) {
        char sexo = sex.charAt(0);

        if (sexo == 'h' || sexo == 'H') {
            return true;
        }
        if (sexo == 'm' || sexo == 'M') {
            return true;
        }

        return false;
    }

    private void createNSS() {
        String preNSS = "";
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            Boolean type = random.nextBoolean();
            if (type) {
                preNSS += random.nextInt(10);
            } else {
                preNSS += (char) (random.nextInt(26) + 'a');
            } 
        }
        this.nss = preNSS;
    }

    @Override
    public String toString() {
        return  (name + " --> [Edad=" + age + ", Altura=" + heigth + ", Nombre=" + name + ", Número de Seguro Social=" + nss + ", Sexo=" + sex
                + ", Peso=" + weigth + "]");
    }
}
