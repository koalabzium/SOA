package notDefault;

import javax.faces.annotation.FacesConfig;

import static javax.faces.annotation.FacesConfig.Version.JSF_2_3;

@FacesConfig(
// Activates CDI build-in beans
        version = JSF_2_3
)
public class ConfigurationBean {

}
