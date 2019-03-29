package com.example.mauri.sede;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

public class conexion {

    public String RUsuario(String url, String b,String c)
    {
        try{
            HttpClient cliente = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(url);
            List<NameValuePair> datos = new ArrayList<NameValuePair>();
            datos.add(new BasicNameValuePair("us",b));
            datos.add(new BasicNameValuePair("pas",c));

            httppost.setEntity(new UrlEncodedFormEntity(datos));

            HttpResponse r = cliente.execute(httppost);
            HttpEntity ent = r.getEntity();
            String texto = EntityUtils.toString(ent);
            return texto;
        }
        catch(Exception e){
            return e.toString();
        }
    }
    public String vertodo(String url)
    {
        try{
            HttpClient cliente = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(url);
            List<NameValuePair> datos = new ArrayList<NameValuePair>();
            httppost.setEntity(new UrlEncodedFormEntity(datos));
            HttpResponse r = cliente.execute(httppost);
            HttpEntity ent = r.getEntity();
            String texto = EntityUtils.toString(ent);
            return texto;
        }
        catch(Exception e){
            return e.toString();
        }
    }
    public String validar(String url,String u,String p){
        try{
            HttpClient cliente = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(url);
            List<NameValuePair> datos = new ArrayList<NameValuePair>();
            datos.add(new BasicNameValuePair("us",u));
            datos.add(new BasicNameValuePair("con",p));
            httppost.setEntity(new UrlEncodedFormEntity(datos));

            HttpResponse r = cliente.execute(httppost);
            HttpEntity ent = r.getEntity();
            String texto = EntityUtils.toString(ent);
            return texto;
        }
        catch(Exception e){
            return e.toString();
        }
    }

    public String aprobar(String url,String nombre){
        try{
            HttpClient cliente = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(url);
            List<NameValuePair> datos = new ArrayList<NameValuePair>();
            datos.add(new BasicNameValuePair("nombre",(nombre)));
            httppost.setEntity(new UrlEncodedFormEntity(datos));

            HttpResponse r = cliente.execute(httppost);
            HttpEntity ent = r.getEntity();
            String texto = EntityUtils.toString(ent);
            return texto;
        }
        catch(Exception e){
            return e.toString();
        }
    }
    public String rechazar(String url,String nombre){
        try{
            HttpClient cliente = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(url);
            List<NameValuePair> datos = new ArrayList<NameValuePair>();
            datos.add(new BasicNameValuePair("nombre",(nombre)));
            httppost.setEntity(new UrlEncodedFormEntity(datos));

            HttpResponse r = cliente.execute(httppost);
            HttpEntity ent = r.getEntity();
            String texto = EntityUtils.toString(ent);
            return texto;
        }
        catch(Exception e){
            return e.toString();
        }
    }
}
