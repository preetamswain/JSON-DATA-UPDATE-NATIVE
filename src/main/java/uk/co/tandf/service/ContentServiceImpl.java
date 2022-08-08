package uk.co.tandf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.co.tandf.configuration.CustomConfiguration;
import uk.co.tandf.entity.ContentDelivery;
import uk.co.tandf.entity.JournalItem;
import uk.co.tandf.entity.JrnIssn;
import uk.co.tandf.repository.DeliveryDataRepository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class ContentServiceImpl extends CustomConfiguration implements ContentService {

    @Autowired
    DeliveryDataRepository dataRepository;

    @Override
    public ContentDelivery getDeliveries(Long id) {
        ContentDelivery cd = new ContentDelivery();
        try {
            ResultSet deliveries = dataRepository.getDeliveries(id);
            int fetchSize = deliveries.getFetchSize();
            System.out.println("---fetchsize :"+fetchSize);
            if (deliveries != null & deliveries.next()) {
                cd.setId(id);
                cd.setDelivery_state(deliveries.getString(2));
                cd.setBytes_delivered(deliveries.getLong(3));
                cd.setPartner_id(deliveries.getLong(4));
                cd.setItem_id(deliveries.getLong(5));
                cd.setOrigin_id(deliveries.getString(6));
                cd.setItem_type(deliveries.getString(7));
                cd.setPublication_id(deliveries.getLong(8));
            }
            boolean realDelivery = isRealDelivery(cd.getDelivery_state() , cd.getBytes_delivered());
            cd.setRealDelivery(realDelivery);
        } catch (SQLException s) {
            System.out.println("---resultset delivery block :"+s.getMessage());
            s.printStackTrace();
        }
        return cd;
    }

    @Override
    public JournalItem getArticle(Long id) {
        JournalItem ja = new JournalItem();
        try {
            ResultSet article = dataRepository.getArticle(id);
            if (article != null & article.next()) {
                ja.setId(article.getLong(1));
                ja.setVolume(article.getInt(2));
                ja.setVolume_type(article.getString(3));
                ja.setVolume_start_int(article.getInt(4));
                ja.setVolume_end_int(article.getInt(5));
                ja.setIssue_number(article.getString(6));
                ja.setIssue_type(article.getString(7));
                ja.setIssue_start_int(article.getInt(8));
                ja.setIssue_end_int(article.getInt(9));
            }
            if (ja != null) {
                String[] requiredIssue = getRequiredIssue(ja.getIssue_type() , ja.getIssue_start_int() , ja.getIssue_end_int());
                if (requiredIssue != null) {
                    ja.setIssueNumbers(requiredIssue);
                }
                String[] requiredVolume = getRequiredVolume(ja.getVolume_type() , ja.getVolume_start_int() , ja.getVolume_end_int());
                if (requiredVolume != null) {
                    ja.setVolumeNumbers(requiredVolume);
                }
            }
        } catch (SQLException s) {
            System.out.println("---resultset article block :"+s.getMessage());
            s.printStackTrace();
        }
        return ja;
    }

    @Override
    public JournalItem getIssue(Long id) {
        JournalItem ji = new JournalItem();
        try {
            ResultSet issue = dataRepository.getIssue(id);
            if (issue != null & issue.next()) {
                ji.setId(issue.getLong(1));
                ji.setVolume(issue.getInt(2));
                ji.setVolume_type(issue.getString(3));
                ji.setVolume_start_int(issue.getInt(4));
                ji.setVolume_end_int(issue.getInt(5));
                ji.setIssue_number(issue.getString(6));
                ji.setIssue_type(issue.getString(7));
                ji.setIssue_start_int(issue.getInt(8));
                ji.setIssue_end_int(issue.getInt(9));
            }
            System.out.println("---issue data from resultset :"+ji);
            if (ji != null) {
                String[] requiredIssue = getRequiredIssue(ji.getIssue_type() , ji.getIssue_start_int() , ji.getIssue_end_int());
                if (requiredIssue != null) {
                    ji.setIssueNumbers(requiredIssue);
                }
                String[] requiredVolume = getRequiredVolume(ji.getVolume_type() , ji.getVolume_start_int() , ji.getVolume_end_int());
                if (requiredVolume != null) {
                    ji.setVolumeNumbers(requiredVolume);
                }
            }
        } catch (SQLException s) {
            System.out.println("---resultset issue block :"+s.getMessage());
            s.printStackTrace();
        }
        return ji;
    }

    @Override
    public JrnIssn getEPissn(Long id) {
        JrnIssn jrnIssn = new JrnIssn();
        try {
            ResultSet epissn = dataRepository.getEPissn(id);
            if (epissn != null & epissn.next()) {
                jrnIssn.setId(epissn.getLong(1));
                jrnIssn.setEissn(epissn.getString(2));
                jrnIssn.setPissn(epissn.getString(3));
            }
            if (jrnIssn != null) {
                String[] intStdNumbers = getIntStdNumbers(jrnIssn.getEissn() ,jrnIssn.getPissn());
                if (intStdNumbers != null) {
                    jrnIssn.setInternationalStandardNumbers(intStdNumbers);
                }
            }
        } catch (SQLException s) {
            System.out.println("---resultset issn block :"+s.getMessage());
            s.printStackTrace();
        }
        return jrnIssn;
    }

    public void setDataRepository(DeliveryDataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }
}
