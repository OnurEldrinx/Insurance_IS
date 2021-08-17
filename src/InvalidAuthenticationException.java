public class InvalidAuthenticationException extends Exception{

    public InvalidAuthenticationException(String message) {
        super(message);
        System.out.println("!!! You entered the wrong email or password.");
    }

}
