package com.ethesis.studentService.domain;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

/**
 * @author erfan
 * @since 1/12/23
 */
@Getter
@Setter
@MappedSuperclass
public abstract class Persistent {

    @CreationTimestamp
    private Date created;

    @UpdateTimestamp
    private Date updated;

    private int version;
}
