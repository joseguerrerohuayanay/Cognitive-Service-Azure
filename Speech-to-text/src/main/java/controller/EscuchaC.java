package controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.concurrent.ExecutionException;
import model.Datos;
import services.Azure;

@Named(value = "escuchaC")
@SessionScoped
public class EscuchaC implements Serializable {

    private Datos model;
    private Azure servicio;

    public EscuchaC() {

        model = new Datos();
        servicio = new Azure();

    }

    public void Resultado() throws Exception {

        try {
            Azure.recognizeFromMic(model);
        } catch (InterruptedException | ExecutionException e) {

            System.out.println("ERROR" + e.getMessage());

        }

    }

    public void prueba() {

        try {
            Azure.recognizeFromMic(model);
        } catch (InterruptedException | ExecutionException e) {

            System.out.println("ERROR" + e.getMessage());

        }

    }

    public Datos getModel() {
        return model;
    }

    public void setModel(Datos model) {
        this.model = model;
    }

    public Azure getServicio() {
        return servicio;
    }

    public void setServicio(Azure servicio) {
        this.servicio = servicio;
    }

}
