package uk.co.tandf.service;

import org.springframework.beans.factory.annotation.Autowired;
import uk.co.tandf.configuration.CustomConfiguration;
import uk.co.tandf.entity.ContentDelivery;
import uk.co.tandf.entity.JournalItem;
import uk.co.tandf.entity.JrnIssn;
import uk.co.tandf.repository.DeliveryDataRepository;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContentServiceImpl extends CustomConfiguration implements ContentService {

    @Autowired
    DeliveryDataRepository dataRepository;

    @Override
    public ContentDelivery getDeliveries(Long id) {
        ContentDelivery cd = new ContentDelivery();
        try {
            ResultSet deliveries = dataRepository.getDeliveries(id);
            if (deliveries !=null) {
                cd.setId(deliveries.getLong(1));
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
            s.printStackTrace();
        }
        return null;
    }

    @Override
    public JournalItem getArticle(Long id) {
        JournalItem ji = new JournalItem();
        try {
            ResultSet article = dataRepository.getArticle(id);
            if (article !=null) {
                ji.setId(article.getLong(1));
                ji.setVolume(article.getInt(2));
                ji.setVolume_type(article.getString(3));
                ji.setVolume_start_int(article.getInt(4));
                ji.setVolume_end_int(article.getInt(5));
                ji.setIssue_number(article.getString(6));
                ji.setIssue_type(article.getString(7));
                ji.setIssue_start_int(article.getInt(8));
                ji.setIssue_end_int(article.getInt(9));
            }
        } catch (SQLException s) {
            s.printStackTrace();
        }
        return null;
    }

    @Override
    public JournalItem getIssue(Long id) {
        return null;
    }

    @Override
    public JrnIssn getEPissn(Long id) {
        return null;
    }

    public void setDataRepository(DeliveryDataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }
}
