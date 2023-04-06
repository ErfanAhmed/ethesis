package com.ethesis.studentService.domain.teacher;

import com.ethesis.studentService.domain.Person;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

/**
 * @author erfan
 * @since 4/2/23
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"facultyId", "initials"}))
public class Faculty extends Person {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "facultySeq")
    @SequenceGenerator(name = "facultySeq", sequenceName = "faculty_seq", allocationSize = 1)
    private long id;

    @NotEmpty
    @Column(nullable = false, length = 50)
    private String initials;

    @Length(max = 20, min = 2)
    @NotEmpty
    @Column(nullable = false, length = 20, unique = true)
    private String facultyId;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private Designation designation;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private Title title;
}
