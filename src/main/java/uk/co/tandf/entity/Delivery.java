package uk.co.tandf.entity;

import java.util.Arrays;

public class Delivery {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPartner_id() {
        return partner_id;
    }

    public void setPartner_id(String partner_id) {
        this.partner_id = partner_id;
    }

    public String getPartner_name() {
        return partner_name;
    }

    public void setPartner_name(String partner_name) {
        this.partner_name = partner_name;
    }

    public String getOrigin_id() {
        return origin_id;
    }

    public void setOrigin_id(String origin_id) {
        this.origin_id = origin_id;
    }

    public String getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(String delivery_date) {
        this.delivery_date = delivery_date;
    }

    public boolean isReal() {
        return real;
    }

    public void setReal(boolean real) {
        this.real = real;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public String[] getIntl_std_no() {
        return intl_std_no;
    }

    public void setIntl_std_no(String[] intl_std_no) {
        this.intl_std_no = intl_std_no;
    }

    public String getIntl_std_no_display() {
        return intl_std_no_display;
    }

    public void setIntl_std_no_display(String intl_std_no_display) {
        this.intl_std_no_display = intl_std_no_display;
    }

    public String[] getVolume() {
        return volume;
    }

    public void setVolume(String[] volume) {
        this.volume = volume;
    }

    public String getVolume_display() {
        return volume_display;
    }

    public void setVolume_display(String volume_display) {
        this.volume_display = volume_display;
    }

    public String[] getIssue() {
        return issue;
    }

    public void setIssue(String[] issue) {
        this.issue = issue;
    }

    public String getIssue_display() {
        return issue_display;
    }

    public void setIssue_display(String issue_display) {
        this.issue_display = issue_display;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public String getPub_code() {
        return pub_code;
    }

    public void setPub_code(String pub_code) {
        this.pub_code = pub_code;
    }

    public String[] getPublication_codes() {
        return publication_codes;
    }

    public void setPublication_codes(String[] publication_codes) {
        this.publication_codes = publication_codes;
    }

    public String getPub_title() {
        return pub_title;
    }

    public void setPub_title(String pub_title) {
        this.pub_title = pub_title;
    }

    public String getArticle_title() {
        return article_title;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Integer getNum_children() {
        return num_children;
    }

    public void setNum_children(Integer num_children) {
        this.num_children = num_children;
    }

    public Delivery(String id , String partner_id , String partner_name , String origin_id , String delivery_date , boolean real , String status , String doi , String[] intl_std_no , String intl_std_no_display , String[] volume , String volume_display , String[] issue , String issue_display , String acronym , String pub_code , String[] publication_codes , String pub_title , String article_title , String filename , Integer num_children) {
        this.id = id;
        this.partner_id = partner_id;
        this.partner_name = partner_name;
        this.origin_id = origin_id;
        this.delivery_date = delivery_date;
        this.real = real;
        this.status = status;
        this.doi = doi;
        this.intl_std_no = intl_std_no;
        this.intl_std_no_display = intl_std_no_display;
        this.volume = volume;
        this.volume_display = volume_display;
        this.issue = issue;
        this.issue_display = issue_display;
        this.acronym = acronym;
        this.pub_code = pub_code;
        this.publication_codes = publication_codes;
        this.pub_title = pub_title;
        this.article_title = article_title;
        this.filename = filename;
        this.num_children = num_children;
    }

    public Delivery() {
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "id='" + id + '\'' +
                ", partner_id='" + partner_id + '\'' +
                ", partner_name='" + partner_name + '\'' +
                ", origin_id='" + origin_id + '\'' +
                ", delivery_date='" + delivery_date + '\'' +
                ", real=" + real +
                ", status='" + status + '\'' +
                ", doi='" + doi + '\'' +
                ", intl_std_no=" + Arrays.toString(intl_std_no) +
                ", intl_std_no_display='" + intl_std_no_display + '\'' +
                ", volume=" + Arrays.toString(volume) +
                ", volume_display='" + volume_display + '\'' +
                ", issue=" + Arrays.toString(issue) +
                ", issue_display='" + issue_display + '\'' +
                ", acronym='" + acronym + '\'' +
                ", pub_code='" + pub_code + '\'' +
                ", publication_codes=" + Arrays.toString(publication_codes) +
                ", pub_title='" + pub_title + '\'' +
                ", article_title='" + article_title + '\'' +
                ", filename='" + filename + '\'' +
                ", num_children=" + num_children +
                '}';
    }
}
