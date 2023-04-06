package com.ethesis.studentService.domain.thesis;

import com.ethesis.studentService.domain.Persistent;
import com.ethesis.studentService.domain.teacher.Faculty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

/**
 * @author erfan
 * @since 4/3/23
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table
@Entity
public class ThesisRequest extends Persistent {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "thesisRequestSeq")
    @SequenceGenerator(name = "thesisRequestSeq", sequenceName = "thesis_request_seq", allocationSize = 1)
    private long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ThesisRequestStatus thesisStatus;

    @ManyToOne
    @JoinColumn(name = "thesis_group_id")
    private ThesisGroup thesisGroup;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    /**
     * todo: implement message queue
     * send thesisRequest to the msg queue
     */
}
