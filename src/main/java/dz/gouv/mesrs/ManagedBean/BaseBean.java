package dz.gouv.mesrs.ManagedBean;

import dz.gouv.mesrs.services.*;
import dz.gouv.mesrs.services.nc.NomenclatureService;
import dz.gouv.mesrs.services.ppm.RefEtablissementService;
import dz.gouv.mesrs.services.ppm.RefTypePieceConstitutiveService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import java.io.IOException;
import java.util.List;


@Setter
@Getter
public abstract class BaseBean {


    public int step;
    public String nextPage;
    public String previewPage;
    public String loginPage = "/index.xhtml";
    public boolean privatePage = true;





    @Autowired
    EquipementService equipementService;



    @Autowired
    RefEtablissementService refEtablissementService;

    @Autowired
    NomenclatureService nomenclatureService;



    @Autowired
    RefTypePieceConstitutiveService refTypePieceConstitutiveService;

    public abstract void init();





    public void showErrorMessage(String msgSummaty, String msg) {
        FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, msgSummaty, msg));
    }

    public void showInfoMessage(String msgSummaty, String msg) {
        FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, msgSummaty, msg));
    }

    public void showWarningMessage() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Nb:", "Compléter vos Infotmations"));
    }

    public void showSuccesMessage(String msgSummaty, String msg) {
        FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, msgSummaty, msg));
    }

    public void redirectTo(String page) {
        String navigateTo = "";
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            ExternalContext externalContext = context.getExternalContext();
            navigateTo = externalContext.getRequestContextPath();
            externalContext.redirect(externalContext.encodeResourceURL(externalContext.getRequestContextPath()+page));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }







}

