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

    @Autowired
    EquipementService equipementService;

    @Autowired
    RefEtablissementService refEtablissementService;

    @Autowired
    NomenclatureService nomenclatureService;


    @Autowired
    RefTypePieceConstitutiveService refTypePieceConstitutiveService;

    public abstract void init();

}

