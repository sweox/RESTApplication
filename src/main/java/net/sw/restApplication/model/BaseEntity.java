package net.sw.restApplication.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Base class with property ID.
 */
//Т.к. нет реальной сущности и класс используется как базовый
@MappedSuperclass
@Getter
@Setter
@ToString
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
}
