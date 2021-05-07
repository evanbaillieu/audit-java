/* package fr.snowsdy.app.service;

import fr.snowsdy.app.entity.Champ;
import fr.snowsdy.app.entity.Image;
import fr.snowsdy.app.entity.Modele;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

public class ModeleService {

    @Autowired
    ModeleServiceImpl modeleServiceImpl;

    public static final String springMessage = "Spring Service";

    public ModeleService() {
    }

    public String sayHello() {
        return springMessage;
    }


    @GetMapping("/Modeleid")
    public Optional<Modele> getById(@RequestParam(value = "id", defaultValue = "0") long id) {
        return modeleServiceImpl.getById(id);
    }


    @GetMapping("/Modeleadd")
    public Modele getModele(@RequestParam("Champ") Champ champ,
                                @RequestParam(value = "Image", required = false) Image image) {
        return modeleServiceImpl.save(new Modele(champ, image));
    }

    @GetMapping("/Modeleend")
    public void end() {
        System.exit(0);
    }
*/
    /*
    Normalement, le service est une interface, sauf que comme
    on l'utilise pour être l'api, on déclare les méthodes en lien
    avec la BdD en **abstract** pour que quand tu créera ta classe
    PersonneServiceImpl (par exemple), elle implémentera PersonneService
    qui implémentera les méthodes ci-dessous :
     */
/*
    public void deleteById(int id){
        // TODO HERE:
    }

    @GetMapping("/Modeleall")
    public @ResponseBody
    Iterable<Modele> getAllPersonne(){
        return modeleServiceImpl.getAll();
    }

    @GetMapping("/Modeletest")
    public String test(){
        return modeleServiceImpl.test();
    }

    public ModeleServiceImpl getModeleServiceImpl() {
        return modeleServiceImpl;
    }

    public void setModeleServiceImpl(ModeleServiceImpl personneServiceImpl) {
        this.modeleServiceImpl = modeleServiceImpl;
    }

}
*/