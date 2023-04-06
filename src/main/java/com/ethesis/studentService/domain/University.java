package com.ethesis.studentService.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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
public class University extends Persistent {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "universitySeq")
    @SequenceGenerator(name = "universitySeq", sequenceName = "university_seq", allocationSize = 1)
    private int id;

    @NotEmpty
    @Column(nullable = false, length = 200)
    private String name;

    /**
     * logo .img
     * address
     */
}
