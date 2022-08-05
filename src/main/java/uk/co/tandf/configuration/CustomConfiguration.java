package uk.co.tandf.configuration;

import org.springframework.util.StringUtils;

import java.util.*;

public class CustomConfiguration {

    private static final String SUPPLEMENT_ISSUE_INDICATOR = "s";

    public boolean isRealDelivery(String state,Long bytes) {
        if (state.equals("SENT") && bytes != null && bytes == 0) {
            return false;
        }
        return true;
    }

    public String [] getIntStdNumbers(String...standardNumbers) {
        Set<String> nonEmptyStandardNumbers = new HashSet<>();
        if (standardNumbers != null) {
            for (String standardNumber : standardNumbers) {
                if (StringUtils.hasText(standardNumber)) {
                    nonEmptyStandardNumbers.add(standardNumber.trim());
                }
            }
        }
        String[] strings = nonEmptyStandardNumbers.toArray(new String[nonEmptyStandardNumbers.size()]);
        System.out.println("---int numbers :"+ Arrays.toString(strings));
        return strings;
    }

    public String [] getRequiredIssue(String issueType, Integer startInt, Integer endInt) {
        List<String> searchIssueNumbers = new ArrayList<>();
        //Added as for article issue_type field can accept null value in database
        if (issueType == null){
            return null;
        }

        switch (issueType) {
            case "standard":
                // Nothing extra to add.
                break;

            case "range":
                if (startInt != null && endInt != null) {
                    searchIssueNumbers.add(String.valueOf(startInt));
                }
                break;

            case "supplement":
                if (startInt != null) {
                    searchIssueNumbers.add(SUPPLEMENT_ISSUE_INDICATOR);
                }
                break;
        }

        if (!searchIssueNumbers.isEmpty()) {
            String[] strings = searchIssueNumbers.toArray(new String[searchIssueNumbers.size()]);
            //System.out.println("--- req issue :"+strings);
            return strings;
        }

        return null;
    }

    public String [] getRequiredVolume(String volumeType, Integer startInt, Integer endInt) {
        List<String> searchVolumeNumbers = new ArrayList<>();
        //Added as for article volume_type field can accept null value in database
        if (volumeType == null){
            return null;
        }
        switch (volumeType) {
            case "standard":
                // Nothing extra to add.
                break;
            case "range":
                if (startInt != null && endInt != null) {
                    searchVolumeNumbers.add(String.valueOf(startInt));
                }
                break;
        }
        if (!searchVolumeNumbers.isEmpty()) {
            String[] strings = searchVolumeNumbers.toArray(new String[0]);
            //System.out.println("--- req volume :"+Arrays.toString(strings));
            return strings;
        }
        return null;
    }
}
