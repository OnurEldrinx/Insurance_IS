import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public abstract class Account {

    private User user;
    private ArrayList<Insurance> insurances = new ArrayList<>();
    private AuthenticationStatus loginStatus;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<Insurance> getInsurances() {
        return insurances;
    }

    public void setInsurances(ArrayList<Insurance> insurances) {
        this.insurances = insurances;
    }

    public AuthenticationStatus getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(AuthenticationStatus loginStatus) {
        this.loginStatus = loginStatus;
    }



    public final void showUserInfo(){

        System.out.println("----------------------------------------");
        System.out.format("-> %-20s : %-20s","Full Name",user.getName()+" "+user.getSurname());
        System.out.format("\n-> %-20s : %-20s","Email",user.getEmail());
        System.out.format("\n-> %-20s : %-20s","Profession",user.getProfession());
        System.out.format("\n-> %-20s : %-20s","Age",user.getAge());
        System.out.format("\n-> %-20s : %-20s","Last Login",user.getLastLogin());
        System.out.println("\n----------------------------------------");

        System.out.println("\nAddresses");
        int counter = 1;
        for (Address address:user.getAddressList()) {

            System.out.println("-*-*-*-*-*-*-*-*-*- " + counter + " -*-*-*-*-*-*-*-*-*-");
            address.printAddress();
            counter++;
        }

        System.out.println("\nInsurance Policies");
        int policyCounter = 1;
        for (Insurance insurance:this.getInsurances()) {

            System.out.println("-*-*-*-*-*-*-*-*-*- " + policyCounter + " -*-*-*-*-*-*-*-*-*-");
            System.out.println("----------------------------------------");
            System.out.format("-> %-20s : %-20s","Name",insurance.getInsuranceName());
            System.out.format("\n-> %-20s : %-20s","Fee",insurance.getInsuranceFee());
            System.out.format("\n-> %-20s : %-20s","Starting Date",insurance.getStartingDate().toString());
            System.out.format("\n-> %-20s : %-20s","Ending Date",insurance.getEndingDate().toString());
            System.out.println("\n----------------------------------------");

        }



    }

    public void login(String emailInput,String passwordInput) throws InvalidAuthenticationException {

        if (this.user.getEmail().equals(emailInput) && this.user.getPassword().equals(passwordInput)){

            System.out.println("Login is successful!");
            System.out.println("Welcome, "+this.user.getName()+" "+this.user.getSurname()+".");
            this.setLoginStatus(AuthenticationStatus.SUCCESS);

        }else{

            this.setLoginStatus(AuthenticationStatus.FAIL);
            throw new InvalidAuthenticationException("!!! Invalid Authentication Attempt");

        }


    }

    public String whatIsLoginStatus(){

        return this.loginStatus.toString();

    }

    public  void addInsurancePolicy(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("-----------------\nAvailable Options\n-----------------");
        System.out.println("1.Health Insurance");
        System.out.println("2.Residence Insurance");
        System.out.println("3.Travel Insurance");
        System.out.println("4.Car Insurance\n-----------------\n");

        System.out.print("Your Choice : ");
        int choice = scanner.nextInt();

        switch (choice){

            case 1:
                HealthInsurance healthInsurance = new HealthInsurance();
                healthInsurance.setAccount(this);
                System.out.print("Starting Year: ");
                int year = scanner.nextInt();
                System.out.print("Starting Month: ");
                int month = scanner.nextInt();
                System.out.print("Starting Day: ");
                int day = scanner.nextInt();
                Date startDate = new Date(year-1900,month-1,day);
                System.out.print("Ending Year: ");
                int endYear = scanner.nextInt();
                System.out.print("Ending Month: ");
                int endMonth = scanner.nextInt();
                System.out.print("Ending Day: ");
                int endDay = scanner.nextInt();
                Date endDate = new Date(endYear-1900,endMonth-1,endDay);

                healthInsurance.setStartingDate(startDate);
                healthInsurance.setEndingDate(endDate);
                healthInsurance.setInsuranceName("Health Insurance");
                healthInsurance.calculateFee();
                double fee = healthInsurance.getInsuranceFee();
                this.getInsurances().add(healthInsurance);
                break;

            case 2:
                ResidenceInsurance residenceInsurance = new ResidenceInsurance();
                System.out.print("Size of the residence area : ");
                int area = scanner.nextInt();
                residenceInsurance.setResidenceAreaSize(area);
                System.out.print("Starting Year: ");
                year = scanner.nextInt();
                System.out.print("Starting Month: ");
                month = scanner.nextInt();
                System.out.print("Starting Day: ");
                day = scanner.nextInt();
                startDate = new Date(year-1900,month-1,day);
                System.out.print("Ending Year: ");
                endYear = scanner.nextInt();
                System.out.print("Ending Month: ");
                endMonth = scanner.nextInt();
                System.out.print("Ending Day: ");
                endDay = scanner.nextInt();
                endDate = new Date(endYear-1900,endMonth-1,endDay);

                residenceInsurance.setStartingDate(startDate);
                residenceInsurance.setEndingDate(endDate);
                residenceInsurance.setInsuranceName("Residence Insurance");
                residenceInsurance.calculateFee();
                this.getInsurances().add(residenceInsurance);
                break;

            case 3:
                TravelInsurance travelInsurance = new TravelInsurance();
                System.out.print("Travel distance(km) : ");
                int distance = scanner.nextInt();
                travelInsurance.setDistance(distance);
                System.out.print("Starting Year: ");
                year = scanner.nextInt();
                System.out.print("Starting Month: ");
                month = scanner.nextInt();
                System.out.print("Starting Day: ");
                day = scanner.nextInt();
                startDate = new Date(year-1900,month-1,day);
                System.out.print("Ending Year: ");
                endYear = scanner.nextInt();
                System.out.print("Ending Month: ");
                endMonth = scanner.nextInt();
                System.out.print("Ending Day: ");
                endDay = scanner.nextInt();
                endDate = new Date(endYear-1900,endMonth-1,endDay);

                travelInsurance.setStartingDate(startDate);
                travelInsurance.setEndingDate(endDate);
                travelInsurance.setInsuranceName("Travel Insurance");
                travelInsurance.calculateFee();
                this.getInsurances().add(travelInsurance);
                break;

            case 4:
                CarInsurance carInsurance = new CarInsurance();
                System.out.print("Model year of the car : ");
                int modelYear = scanner.nextInt();
                carInsurance.setCarModelYear(modelYear);
                System.out.print("Starting Year: ");
                year = scanner.nextInt();
                System.out.print("Starting Month: ");
                month = scanner.nextInt();
                System.out.print("Starting Day: ");
                day = scanner.nextInt();
                startDate = new Date(year-1900,month-1,day);
                System.out.print("Ending Year: ");
                endYear = scanner.nextInt();
                System.out.print("Ending Month: ");
                endMonth = scanner.nextInt();
                System.out.print("Ending Day: ");
                endDay = scanner.nextInt();
                endDate = new Date(endYear-1900,endMonth-1,endDay);

                carInsurance.setStartingDate(startDate);
                carInsurance.setEndingDate(endDate);
                carInsurance.setInsuranceName("Car Insurance");
                carInsurance.calculateFee();
                this.getInsurances().add(carInsurance);
                break;

            default:
                System.out.println("*** Invalid Input ***");


        }

    };

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}

class Individual extends Account{

    @Override
    public void addInsurancePolicy() {
        super.addInsurancePolicy();
        for (Insurance insurance:this.getInsurances()) {

            double fee = insurance.getInsuranceFee();
            fee = fee + (fee*0.2);
            insurance.setInsuranceFee(fee);

        }
    }
}

class Enterprise extends Account{

    @Override
    public void addInsurancePolicy() {
        super.addInsurancePolicy();
        for (Insurance insurance:this.getInsurances()) {

            double fee = insurance.getInsuranceFee();
            fee = fee + (fee*0.4);
            insurance.setInsuranceFee(fee);

        }

    }
}

enum AuthenticationStatus{SUCCESS,FAIL}
