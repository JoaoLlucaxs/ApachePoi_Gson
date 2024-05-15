/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poiandgson;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author queir
 */
public class LerArquivoTXT {
    public static void main(String[] args) throws FileNotFoundException {
        
        // Entrada de dados
        FileInputStream entradaArquivo=new FileInputStream(new File("C:\\Users\\queir\\OneDrive\\Documentos\\NetBeansProjects\\arquivo.txt"));
        
        // Vamos ler as linhas
        
        Scanner lerArquivo=new Scanner(entradaArquivo,"UTF-8");
        
        while(lerArquivo.hasNext()){
            String linha=lerArquivo.nextLine();
            
            if(linha != null && !linha.isEmpty()){
                 System.out.println(linha);
            }
           
        }
    }
}
