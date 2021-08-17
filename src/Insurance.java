import java.util.Date;

public abstract class Insurance {

    private String insuranceName;
    private double insuranceFee;
    private Date startingDate;
    private Date endingDate;

    public abstract void calculateFee();

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public double getInsuranceFee() {
        return insuranceFee;
    }

    public void setInsuranceFee(double insuranceFee) {
        this.insuranceFee = insuranceFee;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public Date getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }
}

class HealthInsurance extends Insurance{

    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public void calculateFee() {

        double fee = (60 - account.getUser().getAge()) * (this.getEndingDate().getYear()-this.getStartingDate().getYear())*10;
        this.setInsuranceFee(fee);

    }
}

class ResidenceInsurance extends Insurance{

    private int residenceAreaSize;

    public int getResidenceAreaSize() {
        return residenceAreaSize;
    }

    public void setResidenceAreaSize(int residenceAreaSize) {
        this.residenceAreaSize = residenceAreaSize;
    }

    @Override
    public void calculateFee() {

        double fee = residenceAreaSize * (this.getEndingDate().getYear()-this.getStartingDate().getYear())*10;
        this.setInsuranceFee(fee);
    }
}

class TravelInsurance extends Insurance{

    private int distance;

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public void calculateFee() {

        double fee = distance * (this.getEndingDate().getYear()-this.getStartingDate().getYear())*10;
        this.setInsuranceFee(fee);

    }
}

class CarInsurance extends Insurance{

    private int carModelYear;


    @Override
    public void calculateFee() {

        double fee = (this.getEndingDate().getYear() - carModelYear) * (this.getEndingDate().getYear()-this.getStartingDate().getYear())*10;
        this.setInsuranceFee(fee);

    }

    public int getCarModelYear() {
        return carModelYear;
    }

    public void setCarModelYear(int carModelYear) {
        this.carModelYear = carModelYear;
    }
}
