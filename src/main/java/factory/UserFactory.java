package factory;
import model.*;

public class UserFactory {

    public static UserModel CreateUser(String name ,String email ,String password ,Role role)
    {
        switch(role)
        {
            case ADMIN:
                return new AdminModel(name,email,password,role);

            case CUSTOMER:
                return new CustomerModel(name,email,password,role);


        }
        return null;

    }
}
