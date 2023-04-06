package com.ethesis.studentService.domain.thesis;

import com.ethesis.studentService.domain.Department;
import com.ethesis.studentService.domain.Persistent;
import com.ethesis.studentService.domain.University;
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
public class ThesisTopic extends Persistent {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "thesisTopicSeq")
    @SequenceGenerator(name = "thesisTopicSeq", sequenceName = "thesis_topic_seq", allocationSize = 1)
    private long id;

    @NotEmpty
    @Column(nullable = false, length = 500)
    private String name;

    @ManyToOne
    @JoinColumn(name = "university_id")
    private University university;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
