package com.example.jkey2.jkeyAndroid;

import android.widget.Toast;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.IDN;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;

public class JacksonThread
{
  static WasherDto md;

  public static String start()
  {
    Thread jacksonParseThread = new Thread(new Runnable()
    {
      @Override
      public void run()
      {
        try{
          ObjectMapper mapper = new ObjectMapper();
          try{
            URL ParseUrl = new URL("http://192.168.0.46:8080/android/1");
            ResultDto result = mapper.readValue(ParseUrl,ResultDto.class);

            md = result.getItems().get(0);

          } catch (MalformedURLException e) {

          } catch (JsonParseException e) {

          } catch (JsonMappingException e) {

          } catch (IOException e) {
          }
        }
        catch (Exception ex){

        }
      }
    });
    jacksonParseThread.start();

    return "parse:" + md.getId() + "\nParseAmount:" + md.getElectricPower() + "\nParseMeasure:" + md.getMeasuredAt() +"\nParseState:" + md.getState();
  }

}
