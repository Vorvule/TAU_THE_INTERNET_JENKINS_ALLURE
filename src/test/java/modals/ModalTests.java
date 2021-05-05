package modals;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EntryAdPage;

public class ModalTests extends BaseTests {

    @Test
    public void testModal() {
        EntryAdPage entryAdPage = homePage.clickEntryAd();
        String modalTitle = entryAdPage.getModalTitle();
        Assert.assertEquals(modalTitle, "THIS IS A MODAL WINDOW", "Wrong modal title");
        System.out.println(entryAdPage.getModalHeader());
        entryAdPage.closeModal();
    }
}
