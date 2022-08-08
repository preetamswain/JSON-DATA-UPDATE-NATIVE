package uk.co.tandf;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import uk.co.tandf.entity.ContentDelivery;
import uk.co.tandf.entity.Delivery;
import uk.co.tandf.entity.JournalItem;
import uk.co.tandf.entity.JrnIssn;
import uk.co.tandf.service.ContentService;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JsonDataUpdateDbApplication {

	public static String jsonFilePath = "C:\\darts-projects-setups\\FILES\\deliveries.json";
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(JsonDataUpdateDbApplication.class , args);
		ContentService contentService = context.getBean(ContentService.class);
		List<Delivery> jsonDeliveries = new ArrayList<>();
		Path jsonPath = new File(jsonFilePath).toPath();
		try (
				InputStream inputStream = Files.newInputStream(jsonPath);
				JsonReader reader = new JsonReader(new InputStreamReader(inputStream));
		) {
			reader.setLenient(true);
			while (reader.hasNext()) {
				Delivery delivery = new Gson().fromJson(reader , Delivery.class);
				System.out.println("---delivery json before :"+delivery.toString());
				ContentDelivery deliveries = contentService.getDeliveries(Long.valueOf(delivery.getId()));
				System.out.println(deliveries);
				if (deliveries != null) {
					delivery.setPartner_id(deliveries.getPartner_id().toString());
					delivery.setOrigin_id(deliveries.getOrigin_id());
					/*JrnIssn ePissn = contentService.getEPissn(deliveries.getPublication_id());
					delivery.setIntl_std_no(ePissn.getInternationalStandardNumbers());
					//System.out.println("---issn :"+ePissn);
					if (deliveries.getItem_type().equals("jrn_article")) {
						JournalItem article = contentService.getArticle(deliveries.getItem_id());
						//System.out.println("---article :"+article);
						if (delivery.getVolume() == null) {
							delivery.setVolume(article.getVolumeNumbers());
						}
						if (delivery.getIssue() == null) {
							delivery.setIssue(article.getIssueNumbers());
						}
					} else if (deliveries.getItem_type().equals("jrn_issue")) {
						JournalItem issue = contentService.getIssue(deliveries.getItem_id());
						//System.out.println("---issue :"+issue);
						if (delivery.getVolume() == null) {
							delivery.setVolume(issue.getVolumeNumbers());
						}
						if (delivery.getIssue() == null) {
							delivery.setIssue(issue.getIssueNumbers());
						}
					}*/
				}
				System.out.println("---delivery json after :"+delivery.toString());
				//jsonDeliveries.add(delivery);
			}
		} catch (IOException i) {
		}
	}

	public static void writeJson() {

	}
}
