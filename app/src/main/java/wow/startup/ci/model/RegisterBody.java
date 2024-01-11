package wow.startup.ci.model;

public class RegisterBody {
    private  String fullname;
    private String password;
    private String phone;

    public RegisterBody(String fullname, String password, String phone) {
        this.fullname = fullname;
        this.password = password;
        this.phone = phone;
    }
}
