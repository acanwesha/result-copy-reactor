/*
 * Result Copy Reactor Web Server.
 * This server contains services like getting the patient details, child details, category details of result, copy the results from mother to the child.
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.resultcopy.rest.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.resultcopy.rest.model.CategoryPost;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Baby result information that is to be copied and be linked to the baby.
 */
@Schema(description = "Baby result information that is to be copied and be linked to the baby.")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2021-06-21T13:02:06.679Z[GMT]")public class BabyResult   {
  @JsonProperty("childId")
  private Integer childId = null;

  @JsonProperty("category")
  private List<CategoryPost> category = null;

  public BabyResult childId(Integer childId) {
    this.childId = childId;
    return this;
  }

  /**
   * Identifier for a child.
   * @return childId
   **/
  @JsonProperty("childId")
  @Schema(example = "35", description = "Identifier for a child.")
  public Integer getChildId() {
    return childId;
  }

  public void setChildId(Integer childId) {
    this.childId = childId;
  }

  public BabyResult category(List<CategoryPost> category) {
    this.category = category;
    return this;
  }

  public BabyResult addCategoryItem(CategoryPost categoryItem) {
    if (this.category == null) {
      this.category = new ArrayList<CategoryPost>();
    }
    this.category.add(categoryItem);
    return this;
  }

  /**
   * List of categories available as a part of patient reports that are to be copied.
   * @return category
   **/
  @JsonProperty("category")
  @Schema(description = "List of categories available as a part of patient reports that are to be copied.")
  @Valid
  public List<CategoryPost> getCategory() {
    return category;
  }

  public void setCategory(List<CategoryPost> category) {
    this.category = category;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BabyResult babyResult = (BabyResult) o;
    return Objects.equals(this.childId, babyResult.childId) &&
        Objects.equals(this.category, babyResult.category);
  }

  @Override
  public int hashCode() {
    return Objects.hash(childId, category);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BabyResult {\n");
    
    sb.append("    childId: ").append(toIndentedString(childId)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
