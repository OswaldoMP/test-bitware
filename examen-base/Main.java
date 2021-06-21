import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Person myPerson = new Person();
        myPerson.setName("Oswaldo");
        myPerson.setAge(23);
        myPerson.setSex("M");
        myPerson.setHeigth(1.75f);
        myPerson.setWeigth(73.3f);

        int imc = myPerson.calculateIMC();
        System.out.println("Hola mundo" + imc); 
        System.out.println(myPerson.toString());

        menu();
        
    }

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        Person myPerson = new Person();
        char cont;
        try {
            do {
                System.out.println("======= Conoce tu IMC ======");
                System.out.println();
                System.out.println();
    
                System.out.println("Nombre: ");
                myPerson.setName(scanner.nextLine());
    
                System.out.println("Edad: ");
                myPerson.setAge(scanner.nextInt());
                scanner.nextLine();
    
                System.out.println("Sexo (H, M): ");
                myPerson.setSex(scanner.nextLine());
    
                System.out.println("Altura(Metro): ");
                myPerson.setHeigth(scanner.nextFloat());
    
                System.out.println("Peso(Kilogramos): ");
                myPerson.setWeigth(scanner.nextFloat());
                scanner.nextLine();
    
                int peso = myPerson.calculateIMC();
                String imc = myPerson.getImc(peso);
                Boolean isAdult = myPerson.isAdult();
    
                System.out.println("Tu IMC se encuentra: " + imc);
                System.out.println("Mayor de edad: " + (isAdult ? "Si": "No") );
                System.out.println(myPerson.toString());
    
                System.out.println("Continuar (S, N): ");
                cont = scanner.nextLine().charAt(0);
    
            } while (cont == 's' || cont == 'S');
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("Completa los pasos. Recuerda introducir los decimales como el siguente ejemplo: \n '1,75' ");
            menu();
        }
    }
}