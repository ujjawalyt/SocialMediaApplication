package com.socialmedia.entity;

import java.util.List;

import com.socialmedia.dto.TweetsDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TweetsResponse {

	
	private List<TweetsDto> content;
	private Integer PageNumber;
	private Integer PageSize;
	private Long totalElement;
	private Integer totalpages;
	private boolean lastPage;
	
}
