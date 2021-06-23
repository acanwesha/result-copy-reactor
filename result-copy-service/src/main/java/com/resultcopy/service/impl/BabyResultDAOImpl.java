package com.resultcopy.service.impl;
import com.resultcopy.BabyRequest;
import com.resultcopy.BabyResultResponse;
import com.resultcopy.CategoryRequest;
import com.resultcopy.ResultRequest;
import com.resultcopy.service.ConnectionFactory;
import com.resultcopy.service.dao.BabyResultDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.List;
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
    public boolean createBabyResult(BabyRequest babyRequest) {
        String status = "SUCCESS";

        Connection connection = ConnectionFactory.getConnection();
        BabyResultResponse babyResultResponse=new BabyResultResponse();

        List<CategoryRequest> categoryList = babyRequest.getCategory();
        for(CategoryRequest categoryRequest:categoryList){

            List<ResultRequest> result = categoryRequest.getResult();

            for(ResultRequest resultRequest:result){
                String sql =    "insert into baby_result(child_id,value,category_name,result_name,date_time) " +
                        "Values ( "+babyRequest.getChildId()+" ,  "+resultRequest.getValue() + " , " +
                        categoryRequest.getDisplayName() + " , " + resultRequest.getDisplayName() + " , curtime() )";

                System.out.println("Baby Result Post Request SQL : "+sql);
                PreparedStatement preparedStatement = null;

                try {
                    preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.executeUpdate();
                }catch (SQLException ex){
                    ex.printStackTrace();
                    status = "FAILED";
                    return false;
                }
            }
        }
        return   true;
    }
}
