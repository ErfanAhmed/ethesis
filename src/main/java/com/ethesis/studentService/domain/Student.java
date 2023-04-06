package com.ethesis.studentService.domain;

import com.ethesis.studentService.domain.thesis.ThesisGroup;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

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
public class Student extends Person {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "studentSeq")
    @SequenceGenerator(name = "studentSeq", sequenceName = "student_seq", allocationSize = 1)
    private long id;

    @Length(max = 20, min = 4)
    @NotEmpty
    @Column(nullable = false, length = 20)
    private String studentId;

    @ManyToOne
    @JoinColumn(name = "thesis_group_id")
    private ThesisGroup thesisGroup;
}
