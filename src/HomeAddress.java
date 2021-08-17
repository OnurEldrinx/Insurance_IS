public class HomeAddress implements Address {

    private String name;
    private String streetAddress;
    private String outerDoorNumber;
    private String insideDoorNumber;
    private String neighborhood;
    private String district;
    private String city;
    private String state;
    private String zipCode;

    public HomeAddress(String name, String streetAddress, String outerDoorNumber, String insideDoorNumber, String neighborhood, String district, String city, String state, String zipCode) {
        this.name = name;
        this.streetAddress = streetAddress;
        this.outerDoorNumber = outerDoorNumber;
        this.insideDoorNumber = insideDoorNumber;
        this.neighborhood = neighborhood;
        this.district = district;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public HomeAddress() {
    }


    @Override
    public void printAddress() {

        System.out.println("-----------------------------------------");
        System.out.format("-> %-20s : %-20s","Name",this.name);
        System.out.format("\n-> %-20s : %-20s","Street",this.streetAddress);
        System.out.format("\n-> %-20s : %-20s","Outer Door Number",this.outerDoorNumber);
        System.out.format("\n-> %-20s : %-20s","Inside Door Number",this.insideDoorNumber);
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

    public String getInsideDoorNumber() {
        return insideDoorNumber;
    }

    public void setInsideDoorNumber(String insideDoorNumber) {
        this.insideDoorNumber = insideDoorNumber;
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
