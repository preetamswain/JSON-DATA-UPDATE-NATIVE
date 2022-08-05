package uk.co.tandf.entity;

import lombok.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JournalItem {
    private Long id;
    private Integer volume;
    private String volume_type;
    private Integer volume_start_int;
    private Integer volume_end_int;
    private String issue_number;
    private String issue_type;
    private Integer issue_start_int;
    private Integer issue_end_int;
}
