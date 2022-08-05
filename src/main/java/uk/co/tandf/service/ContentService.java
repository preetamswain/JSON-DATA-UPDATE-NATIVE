package uk.co.tandf.service;

import uk.co.tandf.entity.ContentDelivery;
import uk.co.tandf.entity.JournalItem;
import uk.co.tandf.entity.JrnIssn;

public interface ContentService {
    public ContentDelivery getDeliveries(Long id);
    public JournalItem getArticle(Long id);
    public JournalItem getIssue(Long id);
    public JrnIssn getEPissn(Long id);
}
