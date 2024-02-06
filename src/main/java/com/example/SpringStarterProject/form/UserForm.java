package com.example.SpringStarterProject.form;

import jakarta.validation.constraints.NotEmpty;

/**
 * UserForm
 */
public class UserForm {

  @NotEmpty(message = "名前は必須です")
  private String name;
  @NotEmpty(message = "年齢は必須です")
  private String age;
  @NotEmpty(message = "コメントは必須です")
  private String comment;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  @Override
  public String toString() {
    return "UserForm [name=" + name + ", age=" + age + ", comment=" + comment + "]";
  }
}
