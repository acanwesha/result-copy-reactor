package com.resultcopy.service.impl;
import com.resultcopy.CategoryResponse;
import com.resultcopy.PatientResultResponse;
import com.resultcopy.service.ConnectionFactory;
import com.resultcopy.service.dao.CategoryDAO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.Files;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
/**
 * @author AC089545
 */
/**
 * returns category details.
 */
public class CategoryDAOImpl implements CategoryDAO {

    private ConnectionFactory connectionFactory;
    public CategoryDAOImpl(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public CategoryDAOImpl() {
    }
    public List<CategoryResponse> getCategories() {
        PatientResultResponse patientResult= null;
        List<CategoryResponse> categoryList= new ArrayList<>();
        CategoryResponse categoryResponse=null;
        Connection connection = ConnectionFactory.getConnection();
        Properties prop =new Properties();
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        String sql="SELECT * from category";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                categoryResponse=new CategoryResponse();
                categoryResponse.setId(resultSet.getInt("CATEGORY_ID"));
                categoryResponse.setDisplayName(resultSet.getString("CATEGORY_NAME"));
                categoryList.add(categoryResponse);
            }
            patientResult = new PatientResultResponse();
            patientResult.setCategory(categoryList);
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        patientResult.setCategory(categoryList);
        return categoryList;
    }
}
