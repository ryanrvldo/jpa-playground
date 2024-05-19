package com.ryanrvldo.jpaplayground.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import java.util.List;
import java.util.Map;

/**
 * Standard Web Response
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@With
public class WebResponse<T> {

  /**
   * Code , usually same as HTTP Code
   */
  @JsonProperty("code")
  private Integer code;

  /**
   * Status, usually same as HTTP status
   */
  @JsonProperty("status")
  private String status;

  /**
   * Response data
   */
  @JsonProperty("data")
  private T data;

  /**
   * Paging information, if response is paginate data
   */
  @JsonProperty("paging")
  private PagingResponse paging;

  /**
   * Error information, if request is not valid
   */
  @JsonProperty("errors")
  private Map<String, List<String>> errors;

}
