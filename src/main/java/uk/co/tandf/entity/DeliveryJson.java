package uk.co.tandf.entity;

import lombok.*;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class DeliveryJson {
    private String id;
    private String partner_id;
    private String partner_name;
    private String origin_id;
    private String delivery_date;
    private boolean real;
    private String status;
    private String doi;
    private String intl_std_no [];
    private String intl_std_no_display;
    private String volume [];
    private String volume_display;
    private String issue [];
    private String issue_display;
    private String acronym;
    private String pub_code;
    private String publication_codes [];
    private String pub_title;
    private String article_title;
    private String filename;
    private Integer num_children;
}
