package modals;

import base.BaseTestsNew;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EntryAdPageNew;

public class ModalTestsNew extends BaseTestsNew {

    @Test
    public void testModal() {

        EntryAdPageNew entryAdPageNew = homePageNew.clickEntryAd();
        Assert.assertEquals(entryAdPageNew.getTitle(), "THIS IS A MODAL WINDOW", "Wrong modal title");
        entryAdPageNew.closeModal();

    }

}
