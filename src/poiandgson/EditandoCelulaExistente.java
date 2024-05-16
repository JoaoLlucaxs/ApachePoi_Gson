/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poiandgson;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author queir
 */
public class EditandoCelulaExistente {
    public static void main(String[] args) throws Exception{
        
        // Como editar uma celula já existente
        
        File file=new File("C:\\Users\\queir\\OneDrive\\Documentos\\NetBeansProjects\\arquivo_excel.xls");
        
        // Entrada de dados
        FileInputStream entradaDados=new FileInputStream(file);
        
        HSSFWorkbook hSSFWorkbook=new HSSFWorkbook(entradaDados); // Prepara a entrada do arquivo excel para ler
        HSSFSheet planilha=hSSFWorkbook.getSheetAt(0); // Pega a primeira planilha do nosso arquivo excel
        
        // Percorrer as linhas
        Iterator<Row> linhaIterator=planilha.iterator();
        
        while(linhaIterator.hasNext()){ // enquanto tiver linha
            Row linha=linhaIterator.next(); // dados da pessoa na linha
            
          String valorCelula=linha.getCell(0).getStringCellValue();
          
          linha.getCell(0).setCellValue(valorCelula + " * valor gravado na aula **"); // vai aparecer no nome posição 0
        }
        
        entradaDados.close();
        FileOutputStream saidaDados=new FileOutputStream(file);
        hSSFWorkbook.write(saidaDados);
        saidaDados.flush();
        saidaDados.close();
        
        
        // Tudo funciona , porém se eu edito na mão diretamente no Excel vai pedir um jar dará erro no sistema ao rodar novamente
    }
}
