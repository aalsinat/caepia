package com.caepia.app.api.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class LoginResult {
	private Integer errorCode;
	private String errorMessage;
}
