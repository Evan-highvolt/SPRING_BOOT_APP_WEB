package fr.afpa.pompey.cda.AppWeb.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConfigurationProperties(prefix = "fr.afpa.pompey.cda.appweb")
@Data
public class CustomProperties {
    private String urlAPI;


//    public String getUrlAPI() {
//        return urlAPI;
//    }
//
//    public void setUrlAPI(String urlAPI) {
//        this.urlAPI = urlAPI;
//    }
}
