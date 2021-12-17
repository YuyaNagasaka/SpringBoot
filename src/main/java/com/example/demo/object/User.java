package com.example.demo.object;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class User {
  private String id;
  @NotBlank
  @Length(min = 1,max = 20)
  private String name;
  @NotBlank
  @Length(min = 1,max = 100)
  private String password; 
}
