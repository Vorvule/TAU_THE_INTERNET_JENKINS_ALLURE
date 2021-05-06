package upload;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FileUploadPage;

    public class FileUploadTests extends BaseTests {

        @Test
        public void testFileUpload() {
            FileUploadPage fileUploadPage = homePage.clickFileUpload();
            fileUploadPage.uploadFile
                    ("C:/Users/USER/Google Drive/TAU_THE_INTERNET_JENKINS/src/test/resources/chromedriver.exe");
            // iOS: assert equals just "chromedriver"
            Assert.assertEquals(fileUploadPage.getUploadFiles(), "chromedriver.exe", "Wrong upload.upload");
        }
    }
