/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EscreveJSON;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author queir
 */
public class EscreveJson {
    public static void main(String[] args) throws IOException {
        
        // Meta -> Escrever JSON em arquivo TXT com Gson
        
        // Pegar um objeto colocar dados nele, depois converter em json e escrever em um arquivo
        
        Usuario usuario1=new Usuario();
        usuario1.setCpf("444.555.443-33");
        usuario1.setNome("Joao");
        usuario1.setLogin("João Lucas");
        usuario1.setSenha("3435325");
        
        Usuario usuario2=new Usuario();
        usuario2.setCpf("777.555.443-55");
        usuario2.setNome("Lucas");
        usuario2.setLogin("Lucas Q");
        usuario2.setSenha("54545");
        
        List<Usuario>usuarios=new ArrayList<>();
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        
        // ele deixa mais organizado
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        
        String jsonUser=gson.toJson(usuarios);
        System.out.println(jsonUser); // [{chave: valor}]
        
        // Escrever em arquivo
        FileWriter fileWriter=new FileWriter("C:\\Users\\queir\\OneDrive\\Documentos\\NetBeansProjects\\jsonFile.json");
        fileWriter.write(jsonUser);
        fileWriter.flush();
        fileWriter.close();
        
        // Se tiver problema de acento futuramente :
        //OutputStreamWriter escrever_no_arquivo=new OutputStreamWriter(new FileOutputStream(ARQUVO AQUI), "UTF-8");
        
        
        //======================================== LENDO ARQUIVO JSON ===================================================
        
        // muito util para fazer integração , exportação
        
        
        // reader - ler
        FileReader fileReader=new FileReader("C:\\Users\\queir\\OneDrive\\Documentos\\NetBeansProjects\\jsonFile.json");
        
        // um JsonArray extend de JsonElement por isso foi utilizado no for
        JsonArray jsonArray= (JsonArray) JsonParser.parseReader(fileReader);
        
        // vou ler e colocar em uma lista de usuário
        List<Usuario> listaUsuario=new ArrayList<>();
        
        for(JsonElement jsonElement : jsonArray){ // para cada elemento converte para tipo usuario e insere na lista
            Usuario usuario=new Gson().fromJson(jsonElement, Usuario.class); // ele vai pegar e converter para um Usuario
            listaUsuario.add(usuario);
        }
        
        System.out.println("LEITURA DO ARQUIVO JSON : " + listaUsuario);
    }
}
