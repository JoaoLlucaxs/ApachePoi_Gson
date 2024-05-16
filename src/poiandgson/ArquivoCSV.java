/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poiandgson;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import poiandgson.Pessoa.Pessoa;

/**
 *
 * @author queir
 */
public class ArquivoCSV {
    public static void main(String[] args) throws FileNotFoundException {
         // arquivo csv também é uma estrutura muito utilizada para arquivo EXCEL
         
           // Entrada de dados
           // basta colocar .csv (se já obtiver esse arquivo em bloco de notas configure o formato para csv)
        FileInputStream entradaArquivo=new FileInputStream(new File("C:\\Users\\queir\\OneDrive\\Documentos\\NetBeansProjects\\arquivo.csv"));
        
        // Vamos ler as linhas
        
        Scanner lerArquivo=new Scanner(entradaArquivo,"UTF-8");
        
        List<Pessoa> pessoas=new ArrayList<>();
        
        while(lerArquivo.hasNext()){
            String linha=lerArquivo.nextLine();
            
            if(linha != null && !linha.isEmpty()){
                String[] dados=linha.split("\\;"); // o delimitador , que está entre os dados no txt é o ";"
                Pessoa pessoa=new Pessoa();
                pessoa.setNome(dados[0]);
                pessoa.setEmail(dados[1]);
                pessoa.setIdade(Integer.parseInt( dados[2]));
                
                pessoas.add(pessoa);
            }
           
       }
        //System.out.println(pessoas); 
        for(Pessoa p : pessoas){ // Poderia gravar no banco, enviar e-mail, gerar boleto
            System.out.println(p);
        }
    }
}
