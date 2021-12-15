package com.example.demo.object;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class Output {
  private int id;
  private int user_id;
  @NotBlank
  @Length(min = 1,max = 20)
  private String title;
  @NotBlank
  @Length(min = 1,max = 50)
  private String description;
  @NotBlank
  @Length(min = 1,max = 20)
  private String keyword;
}
