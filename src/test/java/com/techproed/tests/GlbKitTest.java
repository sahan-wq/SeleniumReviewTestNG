package com.techproed.tests;

import com.techproed.pages.GlbKitPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.Driver;
import org.testng.annotations.Test;

public class GlbKitTest {

    @Test
    public void test(){
        Driver.getDriver().get(ConfigurationReader.getProperty("glb_kitchen"));
        GlbKitPage glbKitPage= new GlbKitPage();
        glbKitPage.urunLinki.click();
        String aciklama = glbKitPage.aciklama.getText();
        String baslik = glbKitPage.baslik.getText();
        String fiyat = glbKitPage.fiyat.getText();

        System.out.println(baslik);
        System.out.println(fiyat);
        System.out.println(aciklama);

    }
}
