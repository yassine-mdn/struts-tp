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
@Namespace("/specialite")
@ResultPath(value = "/WEB-INF/views/")
@ExceptionMappings({@ExceptionMapping(exception = "java.lang.Exception", result = "error")})
public class SpecialiteAction  extends ActionSupport implements ModelDriven<Specialite> {

    private Specialite specialite;
    private List<Specialite> specialiteList = new ArrayList<>();

    @Action(value = "addSpecialite", results = {
            @Result(name = "success", location = "addSpecialite.jsp"),
            @Result(name = "error", location = "error.jsp")})
    public String execute() {
        SpecialiteService.saveSpecialite(specialite);
        return SUCCESS;
    }

    @Action(value = "listerSpecialite", results = {
            @Result(name = SUCCESS, location = "listSpecialite.jsp"),
            @Result(name = ERROR, location = "error.jsp")
    })
    public String listerSpecialite() {
        specialiteList = SpecialiteService.findAllSpecialite();
        return SUCCESS;
    }
    @Override
    public Specialite getModel() {
        return specialite;
    }

}
