package dz.gouv.mesrs.ManagedBean;


import dz.gouv.mesrs.model.Equipement;
import org.springframework.context.annotation.Scope;

import javax.inject.Named;
import java.util.List;

@Named("equipementBean")
@Scope("request")
public class EquipementBean extends  BaseBean{

    List<Equipement> equipements ;
    @Override
    public void init() {

    }

    public void getAll(){
        equipements = equipementService.findAll();
        equipements.stream().forEach(e-> System.out.println("-----------------------"+e.getIdentifiantName()));

    }

}
