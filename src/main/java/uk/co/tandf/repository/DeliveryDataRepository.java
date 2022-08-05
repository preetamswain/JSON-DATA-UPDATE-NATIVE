package uk.co.tandf.repository;

import uk.co.tandf.entity.JournalItem;
import uk.co.tandf.entity.JrnIssn;

import java.sql.ResultSet;

public interface DeliveryDataRepository {
    public ResultSet getDeliveries(Long id);
    public ResultSet getArticle(Long id);
    public ResultSet getIssue(Long id);
    public ResultSet getEPissn(Long id);
}
