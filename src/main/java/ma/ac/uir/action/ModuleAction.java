package ma.ac.uir.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import lombok.Getter;
import lombok.Setter;
import ma.ac.uir.entity.Etudiant;
import ma.ac.uir.entity.Module;
import ma.ac.uir.service.ModuleService;
import org.apache.struts2.convention.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Namespace("/module")
@ResultPath(value = "/WEB-INF/views/")
@ExceptionMappings({@ExceptionMapping(exception = "java.lang.Exception", result = "error")})
public class ModuleAction extends ActionSupport implements ModelDriven<Module> {
    
    private Module module;
    private List<Module> moduleList = new ArrayList<>();

    @Action(value = "addModule", results = {
            @Result(name = "success", location = "addModule.jsp"),
            @Result(name = "error", location = "error.jsp")})
    public String execute() {
        ModuleService.saveModule(module);
        return SUCCESS;
    }

    @Action(value = "listerModule", results = {
            @Result(name = SUCCESS, location = "listModule.jsp"),
            @Result(name = ERROR, location = "error.jsp")
    })
    public String listerModule() {
        moduleList = ModuleService.findAllModule();
        return SUCCESS;
    }
    
    @Override
    public Module getModel() {
        return module;
    }
}
