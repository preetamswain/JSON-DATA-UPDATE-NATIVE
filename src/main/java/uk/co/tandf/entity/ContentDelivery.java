package uk.co.tandf.entity;

import lombok.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ContentDelivery {
    private Long id;
    private Long item_id;
    private String item_type;
    private Long publication_id;
    private Long partner_id;
    private String origin_id;
    private String delivery_state;
    private Long bytes_delivered;

    private String [] volumeNumbers;
    private String [] issueNumbers;
    private String [] internationalStandardNumbers;
    public boolean realDelivery;
}
