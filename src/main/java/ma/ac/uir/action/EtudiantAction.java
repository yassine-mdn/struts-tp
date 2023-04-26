package ma.ac.uir.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import lombok.Getter;
import lombok.Setter;
import ma.ac.uir.entity.Etudiant;
import ma.ac.uir.entity.Specialite;
import ma.ac.uir.service.EtudiantService;
import ma.ac.uir.service.SpecialiteService;
import org.apache.struts2.convention.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Namespace("/etudiant")
@ResultPath(value = "/WEB-INF/views/")
@ExceptionMappings({@ExceptionMapping(exception = "java.lang.Exception", result = "error")})
public class EtudiantAction extends ActionSupport implements ModelDriven<Etudiant> {

    private Etudiant etudiant;

    private int idE;
    private List<Etudiant> etudiantList = new ArrayList<Etudiant>();

    @Action(value = "addEtudiant", results = {
            @Result(name = "success", location = "addEtudiant.jsp"),
            @Result(name = "error", location = "error.jsp")})
    public String execute() {
        EtudiantService.saveEtudiant(etudiant);
     return SUCCESS;
    }

    @Action(value = "listerEtudiant", results = {
            @Result(name = SUCCESS, location = "listEtudiant.jsp"),
            @Result(name = ERROR, location = "error.jsp")
    })
    public String listerEtudiant() {
        etudiantList = EtudiantService.findAllEtudiant();
        return SUCCESS;
    }
    @Action(value = "deleteEtudiant", results = {
            @Result(name = SUCCESS, location = "deleted.jsp"),
            @Result(name = ERROR, location = "error.jsp")
    })
    public String deleteEtudiant(){

        EtudiantService.deleteById(idE);
        return SUCCESS;
    }

    @Override
    public Etudiant getModel() {
        return etudiant;
    }
}
