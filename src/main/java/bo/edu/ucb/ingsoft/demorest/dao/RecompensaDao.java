package bo.edu.ucb.ingsoft.demorest.dao;

import bo.edu.ucb.ingsoft.demorest.dto.RecompensaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

@Service
public class RecompensaDao {
    @Autowired
    private SequenceDao sequenceDao;
    @Autowired
    private DataSource dataSource;
    public RecompensaDTO crearRecompensa(RecompensaDTO recompensa){
        recompensa.setRecompensaId(sequenceDao.getPrimaryKeyForTable("recompensas"));
        Connection conn=null;
        try{
            conn= dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO recompensas VALUES (?,?,?,?,?)");
            pstmt.setInt(1,recompensa.getRecompensaId());
            pstmt.setDouble(2,recompensa.getRangoInicial());
            pstmt.setDouble(3,recompensa.getRangoFinal());
            pstmt.setString(4,recompensa.getRecompensa());
            pstmt.setInt(5,recompensa.getProyectoId());
            //pstmt.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return recompensa;
    }
}

