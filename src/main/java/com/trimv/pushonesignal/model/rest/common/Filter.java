


package com.trimv.pushonesignal.model.rest.common;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.util.HashSet;
import java.util.Objects;

/**
 * Filter
 */
@Data
@AllArgsConstructor
public class Filter {
  private static final long serialVersionUID = 1L;

  private String field;

  private String key;

  private String value;

  /**
   * Operator of a filter expression.
   */
  public enum RelationEnum {
    GREATER_THAN(">"),
    
    LESS_THAN("<"),
    
    EQUAL("="),
    
    NOT_EQUAL("!="),
    
    EXISTS("exists"),
    
    NOT_EXISTS("not_exists"),
    
    TIME_ELAPSED_GT("time_elapsed_gt"),
    
    TIME_ELAPSED_LT("time_elapsed_lt");

    private String value;

    RelationEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static RelationEnum fromValue(String value) {
      for (RelationEnum b : RelationEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

  }


  private RelationEnum relation;

  public Filter() { 
  }

  public Filter field(String field) {
    
    this.field = field;
    return this;
  }

   /**
   * Name of the field to use as the first operand in the filter expression.
   * @return field
  **/


  public String getField() {
    return field;
  }


  public void setField(String field) {
    this.field = field;
  }


  public Filter key(String key) {
    
    this.key = key;
    return this;
  }

   /**
   * If &#x60;field&#x60; is &#x60;tag&#x60;, this field is *required* to specify &#x60;key&#x60; inside the tags.
   * @return key
  **/


  public String getKey() {
    return key;
  }


  public void setKey(String key) {
    this.key = key;
  }


  public Filter value(String value) {
    
    this.value = value;
    return this;
  }

   /**
   * Constant value to use as the second operand in the filter expression. This value is *required* when the relation operator is a binary operator.
   * @return value
  **/

  public String getValue() {
    return value;
  }


  public void setValue(String value) {
    this.value = value;
  }


  public Filter relation(RelationEnum relation) {
    
    this.relation = relation;
    return this;
  }

   /**
   * Operator of a filter expression.
   * @return relation
  **/

  public RelationEnum getRelation() {
    return relation;
  }


  public void setRelation(RelationEnum relation) {
    this.relation = relation;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Filter filter = (Filter) o;
    return Objects.equals(this.field, filter.field) &&
        Objects.equals(this.key, filter.key) &&
        Objects.equals(this.value, filter.value) &&
        Objects.equals(this.relation, filter.relation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(field, key, value, relation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Filter {\n");
    sb.append("    field: ").append(toIndentedString(field)).append("\n");
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    relation: ").append(toIndentedString(relation)).append("\n");
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


  public static HashSet<String> openapiFields;
  public static HashSet<String> openapiRequiredFields;

  static {
    // a set of all properties/fields (JSON key names)
    openapiFields = new HashSet<String>();
    openapiFields.add("field");
    openapiFields.add("key");
    openapiFields.add("value");
    openapiFields.add("relation");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
    openapiRequiredFields.add("field");
    openapiRequiredFields.add("relation");
  }


 /**
  * Create an instance of Filter given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of Filter
  * @throws IOException if the JSON string is invalid with respect to Filter
  */



}

