package com.resultcopy.service.impl;
import com.resultcopy.BabyResultResponse;
import com.resultcopy.service.ConnectionFactory;
import com.resultcopy.service.dao.BabyResultDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
/**
 * @author AC089545
 */
/**
 * returns the baby result details that are copied for a child.
 */
public class BabyResultDAOImpl implements BabyResultDAO {
    private ConnectionFactory connectionFactory;
    public BabyResultDAOImpl(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }
    public BabyResultDAOImpl() {

    }
    /**
     * @param childId
     *          childId is the unique identifier for the child.
     */
    @Override
    public BabyResultResponse getBabyPatientByChildId(Integer childId) {
        Connection connection = ConnectionFactory.getConnection();
        String sql = " SELECT * FROM Baby_Result WHERE CHILD_ID =  "+childId;
        System.out.println("SQL :"+sql);
        BabyResultResponse babyResultResponse = null;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                babyResultResponse = new BabyResultResponse();
                babyResultResponse.setDateTime(resultSet.getDate("DATE_TIME"));
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return babyResultResponse;
    }
    @Override
    public String createBabyResult(Integer patientId) {
        Connection connection = ConnectionFactory.getConnection();
        BabyResultResponse babyResultResponse=new BabyResultResponse();
        String sql =    "insert into baby_result(child_id,value,category_name,result_name,date_time) " +
                " select distinct ch.child_id,pr.value,c.category_name,rs.result_name,curtime() " +
                " from child ch, patient_result pr, category c,result rs,patient p,result_details rd " +
                " where p.patient_id=pr.patient_id and " +
                " p.patient_id=ch.patient_id and " +
                " ch.child_id=pr.child_id and " +
                " pr.patient_result_id=rd.patient_result_id and " +
                " rd.result_id=rs.result_id and " +
                " rs.category_id=c.category_id and " +
                " p.patient_id = "+patientId;
        System.out.println("Baby Result Post Request SQL : "+sql);
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();

            return  "SUCCESS" ;
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return   "FAILED" ;
    }
}
