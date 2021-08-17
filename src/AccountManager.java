import java.util.Comparator;
import java.util.TreeSet;

public class AccountManager {

    private TreeSet<Account> accounts = new TreeSet<>(new Comparator<Account>() {
        @Override
        public int compare(Account o1, Account o2) {
                return o1.getUser().getName().compareTo(o2.getUser().getName());
        }
    });

    public Account login(String email,String password){

        Object o = new Object();

        for (Account account:this.getAccounts()) {

            if (account.getUser().getEmail().equals(email)) {

                try {

                    account.login(email, password);
                    o = account;


                } catch (Exception e) {

                    System.out.println(e.getMessage());

                }

                break;

            }

        }

        if (o instanceof Account) {
            return (Account) o;
        }else{
            return null;
        }

    }

    public TreeSet<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(TreeSet<Account> accounts) {
        this.accounts = accounts;
    }

}
