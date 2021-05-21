package bo.edu.ucb.ingsoft.demorest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
public class RecompensaController {
    @Autowired
    public DataSource dataSource;

}
