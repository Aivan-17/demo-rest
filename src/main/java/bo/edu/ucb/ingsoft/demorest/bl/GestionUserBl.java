package bo.edu.ucb.ingsoft.demorest.bl;

import bo.edu.ucb.ingsoft.demorest.dao.UserDao;
import bo.edu.ucb.ingsoft.demorest.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestionUserBl {
    @Autowired
    UserDao userDao;
    public User crearUser(User user){

    }
}
