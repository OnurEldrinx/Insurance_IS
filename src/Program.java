import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        User admin = new User();
        admin.setName("admin");
        admin.setEmail("admin");
        admin.setPassword("admin");
        Individual individualAdmin = new Individual();
        individualAdmin.setUser(admin);
        Enterprise enterpriseAdmin = new Enterprise();
        enterpriseAdmin.setUser(admin);

        AccountManager accountManager = new AccountManager();
        accountManager.getAccounts().add(individualAdmin);
        accountManager.getAccounts().add(enterpriseAdmin);

        String firstMenu = "\n--------------------\n1.Create new account\n2.Login\n0.Exit\n--------------------\n";

        boolean flag = true;

        while (flag){

            System.out.println(firstMenu);
            System.out.print("Your Choice: ");
            int c1 = scanner.nextInt();
            switch (c1){

                case 1:
                    User user = new User();
                    System.out.println("\n1.Create an individual account\n2.Create an enterprise account\n");
                    System.out.print("Your Choice : ");
                    int accountType = scanner.nextInt();scanner.nextLine();

                    if (accountType == 1){

                        Individual individual = new Individual();
                        System.out.print("Name : ");
                        user.setName(scanner.nextLine());
                        System.out.print("Surname : ");
                        user.setSurname(scanner.nextLine());
                        System.out.print("Email : ");
                        user.setEmail(scanner.nextLine());
                        System.out.print("Profession : ");
                        user.setProfession(scanner.nextLine());
                        System.out.print("Age : ");
                        user.setAge(scanner.nextInt());scanner.nextLine();
                        System.out.print("Password : ");
                        user.setPassword(scanner.nextLine());
                        AddressManager.addAddress(user);
                        user.setLastLogin(new Date());
                        individual.setUser(user);
                        individual.addInsurancePolicy();
                        accountManager.getAccounts().add(individual);

                    }else if (accountType == 2){

                        Enterprise enterprise = new Enterprise();
                        System.out.print("Name : ");
                        user.setName(scanner.nextLine());
                        System.out.print("Surname : ");
                        user.setSurname(scanner.nextLine());
                        System.out.print("Email : ");
                        user.setEmail(scanner.nextLine());
                        System.out.print("Profession : ");
                        user.setProfession(scanner.nextLine());
                        System.out.print("Age : ");
                        user.setAge(scanner.nextInt());scanner.nextLine();
                        System.out.print("Password : ");
                        user.setPassword(scanner.nextLine());
                        AddressManager.addAddress(user);
                        user.setLastLogin(new Date());
                        enterprise.setUser(user);
                        enterprise.addInsurancePolicy();
                        accountManager.getAccounts().add(enterprise);

                    }

                    break;

                case 2:
                    System.out.print("\nYour Email: ");scanner.nextLine();
                    String emailInput = scanner.nextLine();
                    System.out.print("\nYour Password: ");
                    String passwordInput = scanner.nextLine();

                    Account currentAccount = accountManager.login(emailInput,passwordInput);

                    if (currentAccount != null && currentAccount.whatIsLoginStatus().equals(AuthenticationStatus.SUCCESS.toString())){

                        boolean flag2 = true;
                        while (flag2){

                            System.out.println("\n1.Add Policy\n2.Add new address\n3.Delete an address\n4.Show User Information\n5.Exit");
                            System.out.print("Your Choice: ");
                            int choice = scanner.nextInt();

                            switch (choice){

                                case 1:
                                    currentAccount.addInsurancePolicy();
                                    break;

                                case 2:
                                    AddressManager.addAddress(currentAccount.getUser());
                                    break;

                                case 3:
                                    AddressManager.deleteAddress(currentAccount.getUser());
                                    break;

                                case 4:
                                    currentAccount.showUserInfo();
                                    break;

                                case 5:
                                    System.out.println("Logged out successfully.");
                                    flag2 = false;
                                    break;

                                default:
                                    System.out.println("Invalid Input");
                                    break;

                            }

                        }

                    }
                    break;

                case 0:
                    System.out.println("Goodbye!\nProgram is terminated!");
                    flag = false;
                    break;

                default:
                    System.out.println("Invalid Input");
                    break;

            }



        }


    }
}
