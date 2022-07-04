
package services;

import com.microsoft.cognitiveservices.speech.*;
import com.microsoft.cognitiveservices.speech.audio.AudioConfig;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Archivo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        SpeechConfig speechConfig = SpeechConfig.fromSubscription("fc72c45e795f45cabeb2d9b4aa6b23f8", "eastus");
        speechConfig.setSpeechRecognitionLanguage("es-PE");
        fromFile(speechConfig);
    }

    public static void fromFile(SpeechConfig speechConfig) throws InterruptedException, ExecutionException {
        AudioConfig audioConfig = AudioConfig.fromWavFileInput("prueba.wav");
        SpeechRecognizer recognizer = new SpeechRecognizer(speechConfig, audioConfig);
        
        Future<SpeechRecognitionResult> task = recognizer.recognizeOnceAsync();
        SpeechRecognitionResult result = task.get();
        System.out.println("RECOGNIZED: Text=" + result.getText());
    }
}
