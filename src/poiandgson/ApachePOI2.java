/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poiandgson;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import poiandgson.Pessoa.Pessoa;

/**
 *
 * @author queir
 */
public class ApachePOI2 {
    
    public static void main(String[] args) throws IOException {
        // Lendo Excel XLS com Apache POI e montando Lista
        
        
        // Entrada de dados
        FileInputStream entradaDados=new FileInputStream("C:\\Users\\queir\\OneDrive\\Documentos\\NetBeansProjects\\arquivo_excel.xls");
        
        HSSFWorkbook hSSFWorkbook=new HSSFWorkbook(entradaDados); // Prepara a entrada do arquivo excel para ler
        HSSFSheet planilha=hSSFWorkbook.getSheetAt(0); // Pega a primeira planilha do nosso arquivo excel
        
        // Percorrer as linhas
        Iterator<Row> linhaIterator=planilha.iterator();
        
        List<Pessoa> pessoas=new ArrayList<>();
        
        while(linhaIterator.hasNext()){ // Enquanto tiver linha no arquivo do Excel
            Row linha= linhaIterator.next(); // Dados da pessoa na linha
            // A linha tem várias celulas, cada celula é um atributo (nome, email, idade..)
            
            Iterator<Cell> celulas= linha.iterator();
            // Cada linha é uma Pessoa
            Pessoa pessoa=new Pessoa();
            
            while(celulas.hasNext()){ // Enquanto tiver celulas 
                Cell cell= celulas.next();
                
                // pegando o valor de cada uma 
                switch (cell.getColumnIndex()) {
                    case 0 -> pessoa.setNome(cell.getStringCellValue());
                    case 1 -> pessoa.setEmail(cell.getStringCellValue());
                    case 2 -> pessoa.setIdade(Double.valueOf(cell.getNumericCellValue()).intValue());
                }
            }
            
           pessoas.add(pessoa);
        }
         entradaDados.close(); // terminou de ler arquivo excel
            
            for(Pessoa p : pessoas){ // Com essa lista em mãos poderia gravar em banco de dados , mandar email...
                System.out.println(p);
            }
    }
}
