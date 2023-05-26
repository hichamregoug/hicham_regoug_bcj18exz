package com.school.managementapi.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("S")
@NoArgsConstructor
@Getter
@Setter
public class Student extends Person {
}
