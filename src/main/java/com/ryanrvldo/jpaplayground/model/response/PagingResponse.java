package com.ryanrvldo.jpaplayground.model.response;

import com.ryanrvldo.jpaplayground.model.request.SortBy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@With
public class PagingResponse {

  private Integer page;

  private Integer pageSize;

  private Integer totalPage;

  private Long totalItem;

  private List<SortBy> sortBy;

}
