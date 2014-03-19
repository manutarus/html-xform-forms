package org.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * User: manu
 * Date: 3/18/14
 * Time: 11:11 AM
 */

public class FindReplace {



    public static void main(String[] args) {
        FindReplace fr = new FindReplace();
//        File folder = new File("/media/manu/manu/Turbo");
//        File[] listOfFiles = folder.listFiles();
//        for(int i = 0; i < listOfFiles.length; i++) {
//            if (listOfFiles[i].isFile()) {
//                System.out.println("Done " + listOfFiles[i].getName());
//
//
//            } else if (listOfFiles[i].isDirectory()) {
//                System.out.println("Directory " + listOfFiles[i].getName());
//            }
//        }
        fr.replacer();
    }

    public void replacer(){
        try {
            String content = null;
            try {
                content = FileUtils.readFileToString(new File("/media/manu/manu/Turbo/PHCT_Household_survey_v1.0.0.8_2014-01-30_07-18-53.xml"), "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
            content = content.replaceAll("provider_id\">486-1</encounter.provider_id></encounter>", "provider_id\">486-1</encounter.provider_id></encounter>");


            File tempFile = new File("/media/manu/manu/replaced/PHCT_Household_survey_v1.0.0.8_2014-01-30_07-18-53.xml");
            FileUtils.writeStringToFile(tempFile, content, "UTF-8");
        } catch (IOException e) {
            //Simple exception handling, replace with what's necessary for your use case!
            throw new RuntimeException("Generating file failed", e);
        }
    }
}
