package org.cesar;

import org.cesar.dao.ClientDAO;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ClientDAO clientDAO = new ClientDAO();
        Scanner scanner = new Scanner(System.in);

        int opc = 0;

        while(opc != 5){
            System.out.println("~ Client Database ~\n1. Add New Client\n2. Delete Client\n3. Update Client\n4. Show All Clients\n5. Exit");
            System.out.print("Select An Option: ");
            opc = scanner.nextInt();

            switch(opc){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
            }


        }
    }
}
