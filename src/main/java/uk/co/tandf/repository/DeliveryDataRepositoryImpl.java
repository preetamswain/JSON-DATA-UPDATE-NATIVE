package uk.co.tandf.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uk.co.tandf.connection.DBConnection;
import uk.co.tandf.entity.ContentDelivery;
import uk.co.tandf.entity.JournalItem;
import uk.co.tandf.entity.JrnIssn;

import javax.management.Query;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Queue;

@Repository
public class DeliveryDataRepositoryImpl extends DBConnection implements DeliveryDataRepository {

    private static String innerJoin = " INNER JOIN ";
    private static String select = " SELECT ";
    private static String from = " FROM ";
    private static String where = " WHERE ";

    @Override
    public ResultSet getDeliveries(Long id) {
        Connection dbConnection = getDBConnection();
        String deliveryQuery = select +
                " cd.id,cd.delivery_state,cd.bytes_delivered,cd.partner_id,cd.item_id," +
                "ci.origin_id,ci.item_type,ci.publication_id " +
                from +
                " content_delivery cd"
                + innerJoin +
                " item ci ON cd.item_id=ci.id "+
                where +
                " cd.id =?";
        try {
            if (dbConnection != null) {
                System.out.println("--- before time now :"+ LocalDateTime.now());
                PreparedStatement statement = dbConnection.prepareStatement(deliveryQuery);
                System.out.println("---creating prepare statement :"+ LocalDateTime.now());
                statement.setLong(1,id);
                System.out.println("---creating prepare statement :"+ statement.toString());
                System.out.println("---set delivery id :"+ LocalDateTime.now());
                statement.setFetchSize(1);
                ResultSet resultSet = statement.executeQuery();
                System.out.println("fetch size in cd :"+resultSet.getFetchSize());
                //resultSet.setFetchSize(1);
                System.out.println("fetch size in cd :"+resultSet.getFetchSize());
                System.out.println("---after prepare statement execution :"+ LocalDateTime.now());
                if (resultSet !=null) {
                    return resultSet;
                }
            }
        } catch (SQLException s) {
            s.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultSet getArticle(Long id) {
        Connection dbConnection = getDBConnection();
        String itemQuery = select+
                " ja.id,ja.volume,ja.volume_type,ja.volume_start_int," +
                "ja.volume_end_int,ja.issue_number,ja.issue_type," +
                "ja.issue_start_int,ja.issue_end_int " +
                from +
                " jrn_article ja "+
                where +
                " ja.id=?";
        try {
            if (dbConnection != null) {
                PreparedStatement statement = dbConnection.prepareStatement(itemQuery);
                statement.setLong(1,id);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet !=null) {
                    return resultSet;
                }
            }
        } catch (SQLException s) {
            s.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultSet getIssue(Long id) {
        Connection dbConnection = getDBConnection();
        String itemQuery = select +
                " ji.id,ji.volume,ji.volume_type,ji.volume_start_int," +
                "ji.volume_end_int,ji.issue_number,ji.issue_type," +
                "ji.issue_start_int,ji.issue_end_int " +
                from +
                " jrn_issue ji "+
                where +
                " ji.id=?";
        try {
            if (dbConnection != null) {
                PreparedStatement statement = dbConnection.prepareStatement(itemQuery);
                statement.setLong(1,id);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet !=null) {
                    return resultSet;
                }
            }
        } catch (SQLException s) {
            s.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultSet getEPissn(Long id) {
        Connection dbConnection = getDBConnection();
        String itemQuery = select +
                " jil.id,jil.eissn,jil.pissn " +
                from +
                " jrn_issn_lookup jil " +
                where +
                " jil.id=?";
        try {
            if (dbConnection != null) {
                PreparedStatement statement = dbConnection.prepareStatement(itemQuery);
                statement.setLong(1,id);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet !=null) {
                    return resultSet;
                }
            }
        } catch (SQLException s) {
            s.printStackTrace();
        }
        return null;
    }
}
