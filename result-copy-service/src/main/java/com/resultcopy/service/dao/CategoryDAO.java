package com.resultcopy.service.dao;
import com.resultcopy.CategoryResponse;

import java.io.FileNotFoundException;
import java.util.List;
/**
 * @author AC089545
 */
/**
 * Interface CategoryDAO containing all the methods to get the list of categories and the respective results associated with categories.
 */
public interface CategoryDAO {
    public List<CategoryResponse> getCategories() ;
}
