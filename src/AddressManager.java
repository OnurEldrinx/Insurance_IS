import java.util.Scanner;

public class AddressManager {

    private static Scanner scanner = new Scanner(System.in);

    public static void addAddress(User user){

        System.out.println("------------------------");
        System.out.println("1.Add a home address\n2.Add a business address");
        System.out.println("------------------------");

        System.out.print("-> Your Choice: ");
        int c = scanner.nextInt();scanner.nextLine();

        switch (c){

            case 1:
                System.out.print("\nAddress Name: ");
                String name = scanner.nextLine();
                System.out.print("\nStreet: ");
                String street = scanner.nextLine();
                System.out.print("\nOuter Door Number:");
                String outerDoor = scanner.nextLine();
                System.out.print("\nInside Door Number:");
                String insideDoor = scanner.nextLine();
                System.out.print("\nNeighborhood:");
                String neighborhood = scanner.nextLine();
                System.out.print("\nDistrict:");
                String district = scanner.nextLine();
                System.out.print("\nCity:");
                String city = scanner.nextLine();
                System.out.print("\nState:");
                String state = scanner.nextLine();
                System.out.print("\nZip Code:");
                String zipCode = scanner.nextLine();

                HomeAddress homeAddress = new HomeAddress(name,street,outerDoor,insideDoor,neighborhood,district,city,state,zipCode);
                user.getAddressList().add(homeAddress);
                System.out.println("\n-> This address is saved.\n");
                break;

            case 2:
                System.out.print("\nAddress Name: ");
                name = scanner.nextLine();
                System.out.print("\nCompany Name: ");
                String company = scanner.nextLine();
                System.out.print("\nStreet: ");
                street = scanner.nextLine();
                System.out.print("\nOuter Door Number:");
                outerDoor = scanner.nextLine();
                System.out.print("\nNeighborhood:");
                neighborhood = scanner.nextLine();
                System.out.print("\nDistrict:");
                district = scanner.nextLine();
                System.out.print("\nCity:");
                city = scanner.nextLine();
                System.out.print("\nState:");
                state = scanner.nextLine();
                System.out.print("\nZip Code:");
                zipCode = scanner.nextLine();

                BusinessAddress businessAddress = new BusinessAddress(name,company,street,outerDoor,neighborhood,district,city,state,zipCode);
                user.getAddressList().add(businessAddress);
                System.out.println("\n-> This address is saved.\n");
                break;

        }


    }

    public static void deleteAddress(User user){

        int counter = 1;

        System.out.println("Address List");
        for (Address address:user.getAddressList()) {

            System.out.println("-*-*-*-*-*-*-*-*-*- " + counter + " -*-*-*-*-*-*-*-*-*-");
            address.printAddress();
            counter++;
        }

        System.out.print("\nEnter the name of the address you want to delete : ");
        String name = scanner.nextLine().toUpperCase().trim();

        counter = 0;
        for (int i=0;i<user.getAddressList().size();i++) {

            if (user.getAddressList().get(i).addressName().equals(name)){

                user.getAddressList().remove(user.getAddressList().get(i));
                counter++;
            }
        }

        if (counter > 1) {
            System.out.println("\n-> " + counter + " addresses are deleted.");
        }else if (counter == 1){
            System.out.println("\n-> " + counter + " address is deleted.");
        }else if(counter == 0){
            System.out.println("\n-> There is not an address registered with this name.");
        }




    }


}
