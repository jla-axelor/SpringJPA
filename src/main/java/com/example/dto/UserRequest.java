package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequest {
	@NotNull(message = "username shouldn't be null")
    private String userName;
    @Email(message = "Invalid email address")
    private String email;
    @Pattern(regexp = "^\\d{10}$",message = "Invalid mobile number entered ")
    private String mobile;
    @Min(18)
    @Max(60)
    private int age;
}
