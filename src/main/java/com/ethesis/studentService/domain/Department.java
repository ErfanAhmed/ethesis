package com.ethesis.studentService.domain;

import jakarta.persistence.*;
import lombok.*;

/**
 * @author erfan
 * @since 3/30/23
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table
@Entity
public class Department extends Persistent {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "departmentSeq")
    @SequenceGenerator(name = "departmentSeq", sequenceName = "department_seq", allocationSize = 1)
    private int id;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(nullable = false, length = 10)
    private String code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "university_id")
    private University university;
}
