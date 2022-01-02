package com.enoca.demo.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  @Column(name = "firstName")
  private String firstName;
  @Column(name = "lastName")
  private String lastName;
  @Column(name = "age")
  private int age;
  @OneToMany(mappedBy = "customer")
  private List<Order> orders;
  
  protected Customer() {}

  public Customer(String firstName, String lastName, int age) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
  }

  @Override
  public String toString() {
    return String.format(
        "Customer[id=%d, firstName='%s', lastName='%s']",
        id, firstName, lastName);
  }

  public Long getId() {
    return this.id;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public int getAge() {
    return this.age;
  }

  public void setFirstName(String value) {
    this.firstName = value;
  }

  public void setLastName(String value) {
    this.lastName = value;
  }
  public void setAge(int value) {
    this.age = value;
  }
}