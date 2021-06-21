package com.resultcopy.service.impl;
import com.resultcopy.CategoryResponse;
import com.resultcopy.ChildResultResponse;
import com.resultcopy.ResultResponse;
import com.resultcopy.service.ConnectionFactory;
import com.resultcopy.service.dao.PatientDAO;
import com.resultcopy.service.dao.ResultDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * @author AC089545
 */
/**
 * returns result details associated with a particular category.
 */
public class ResultDAOImpl implements ResultDAO {

    private ConnectionFactory connectionFactory;
    public ResultDAOImpl(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public ResultDAOImpl() {
    }
    /**
     * @param categoryId
     *          categoryId is the unique identifier for the patient.
     */
    public List<ResultResponse> getCategories(Integer categoryId){
        PatientDAO patientDao=new PatientDAOImpl();
        ResultResponse result=null;
        CategoryResponse category=null;
        List<ResultResponse> resultList=new ArrayList<>();
        Connection connection = ConnectionFactory.getConnection();
        String sql = "SELECT rs.result_id,rs.result_name from result rs,category c where rs.category_id=c.category_id and c.category_id="+categoryId;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result=new ResultResponse();
                result.setId(resultSet.getInt("RESULT_ID"));
                result.setDisplayName(resultSet.getString("RESULT_NAME"));
                resultList.add(result);
            }
            category = new CategoryResponse();
            category.setResult(resultList);
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        category.setResult(resultList);
        return resultList;
    }
    @Override
    public List<ChildResultResponse> getChildValueById(Integer patientId) {
        List<ChildResultResponse> resultList=new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        String sql = "select  pr.CHILD_ID,pr.value,rs.RESULT_ID from patient p,result rs ," +
                     "patient_result pr,result_details rd,category c, child ch " +
                      "where p.patient_ID=pr.patient_Id and " +
                      "pr.patient_result_ID=rd.Patient_result_ID and " +
                      "rd.result_ID=rs.result_ID and "+
                      "rs.category_ID=c.category_ID and " +
                      "p.patient_ID=ch.patient_ID and " +
                      "p.patient_ID= "+patientId;
        try{
            PreparedStatement pStmt = con.prepareStatement(sql);
            ResultSet rs = pStmt.executeQuery();
            ChildResultResponse patientResult = null;
            while (rs.next()) {
                patientResult=new ChildResultResponse();
                patientResult.setChildId(rs.getInt("CHILD_ID"));
                patientResult.setResultId(rs.getInt("RESULT_ID"));
                patientResult.setValue(rs.getString("VALUE"));
                resultList.add(patientResult);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return resultList;
    }
}
