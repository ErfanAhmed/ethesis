package com.ethesis.studentService.domain.thesis;

import com.ethesis.studentService.domain.teacher.Faculty;
import com.ethesis.studentService.domain.Persistent;
import com.ethesis.studentService.domain.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * @author erfan
 * @since 4/2/23
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table
@Entity
public class ThesisGroup extends Persistent {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "thesisGroupSeq")
    @SequenceGenerator(name = "thesisGroupSeq", sequenceName = "thesis_group_seq", allocationSize = 1)
    private long id;

    @Column(length = 20)
    private String name;

    @Column(length = 500)
    private String thesisTitle;

    @Column(columnDefinition = "TEXT")
    private String thesisSummary;

    @Enumerated(EnumType.STRING)
    private GroupStatus status;

    @ManyToOne
    @JoinColumn(name = "thesis_topic_id")
    private ThesisTopic thesisTopic;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

//    @OneToMany(mappedBy = "thesisGroup")
//    private List<Student> students;

    /**
     * thesis paper content as lob
     * or, google doc link
     * comments/feedback loop
     */
}
