package uk.co.tandf.entity;

import lombok.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JrnIssn {
    private Long id;
    private String eissn;
    private String pissn;
}
