public class BusinessAddress implements Address{

    private String name;
    private String company;
    private String streetAddress;
    private String outerDoorNumber;
    private String neighborhood;
    private String district;
    private String city;
    private String state;
    private String zipCode;

    public BusinessAddress(String name, String company, String streetAddress, String outerDoorNumber, String neighborhood, String district, String city, String state, String zipCode) {
        this.name = name;
        this.company = company;
        this.streetAddress = streetAddress;
        this.outerDoorNumber = outerDoorNumber;
        this.neighborhood = neighborhood;
        this.district = district;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public BusinessAddress() {
    }



    @Override
    public void printAddress() {

        System.out.println("-----------------------------------------");
        System.out.format("-> %-20s : %-20s","Name",this.name);
        System.out.format("\n-> %-20s : %-20s","Company",this.company);
        System.out.format("\n-> %-20s : %-20s","Street",this.streetAddress);
        System.out.format("\n-> %-20s : %-20s","Outer Door Number",this.outerDoorNumber);
        System.out.format("\n-> %-20s : %-20s","Neighborhood",this.neighborhood);
        System.out.format("\n-> %-20s : %-20s","District",this.district);
        System.out.format("\n-> %-20s : %-20s","City",this.city);
        System.out.format("\n-> %-20s : %-20s","State",this.state);
        System.out.format("\n-> %-20s : %-20s","Zip Code",this.zipCode);
        System.out.println("\n-----------------------------------------");

    }

    @Override
    public String addressName() {
        return this.name.toUpperCase().trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getOuterDoorNumber() {
        return outerDoorNumber;
    }

    public void setOuterDoorNumber(String outerDoorNumber) {
        this.outerDoorNumber = outerDoorNumber;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
