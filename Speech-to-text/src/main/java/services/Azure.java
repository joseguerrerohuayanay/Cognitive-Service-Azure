package services;

import com.microsoft.cognitiveservices.speech.*;
import com.microsoft.cognitiveservices.speech.audio.AudioConfig;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import model.Datos;

public class Azure {

   
    
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Datos dato = new Datos();
        recognizeFromMic(dato);
        System.out.println("data ="+ dato.getResultado());
   
    }

    public static void recognizeFromMic(Datos dato) throws InterruptedException, ExecutionException {
        
                
        SpeechConfig speechConfig = SpeechConfig.fromSubscription("4fc336e622604ecd84b091e17964933f", "eastus");
        speechConfig.setSpeechRecognitionLanguage("es-PE");
        AudioConfig audioConfig = AudioConfig.fromDefaultMicrophoneInput();
        SpeechRecognizer recognizer = new SpeechRecognizer(speechConfig, audioConfig);

        System.out.println("Speak into your microphone.");
        Future<SpeechRecognitionResult> task = recognizer.recognizeOnceAsync();
        SpeechRecognitionResult result = task.get();
        dato.setResultado(result.getText());
        System.out.println("RECOGNIZED: Text=" + result.getText());
    }

}
