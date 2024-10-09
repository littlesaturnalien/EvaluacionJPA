package org.cesar;

import org.cesar.dao.ClientDAO;
import org.cesar.models.Client;

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
                    System.out.print("Enter Client Name: ");
                    String name = scanner.next();
                    System.out.print("Enter Client Email: ");
                    String email = scanner.next();
                    System.out.print("Enter Client Phone: ");
                    String phone = scanner.next();
                    System.out.print("Enter Client Register Date (Format: YYYY-MM-DD): ");
                    String date = scanner.next();

                    Client client = new Client(name, email, phone, date);
                    clientDAO.saveClient(client);
                    break;

                case 2:
                    System.out.print("Enter Client Id: ");
                    Long id = scanner.nextLong();
                    clientDAO.deleteClient(id);
                    break;
                case 3:
                    System.out.print("Enter Client Id:");
                    Long id2 = scanner.nextLong();
                    Client lookForUpdate = clientDAO.getClientById(id2);
                    if(lookForUpdate != null){
                        System.out.print("Enter Client New Name: ");
                        String newName = scanner.next();
                        System.out.print("Enter Client New Email: ");
                        String newEmail = scanner.next();
                        System.out.print("Enter Client New Phone: ");
                        String newPhone = scanner.next();
                        System.out.print("Enter Client New Register Date (Format: YYYY-MM-DD): ");
                        String newDate = scanner.next();
                        clientDAO.updateClient(new Client(id2,newName, newEmail, newPhone, newDate));
                    }
                    break;
                case 4:
                    System.out.println("~ All Clients ~");
                    clientDAO.getAllClients().forEach(System.out::println);
                    break;
                case 5:
                    System.out.println("See you <3");
                    break;
            }


        }
    }
}
