/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poiandgson;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
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
public class ApachePOI {
    
    public static void main(String[] args) throws IOException {
        
        // Vou criar arquivo
        File arquivo=new File("C:\\Users\\queir\\OneDrive\\Documentos\\NetBeansProjects\\arquivo_excel.xls");
        
        if(!arquivo.exists()){
            arquivo.createNewFile();
        }
        
         Pessoa pessoa1 = new Pessoa();
		pessoa1.setEmail("pessoa1@gmail.com");
		pessoa1.setIdade(50);
		pessoa1.setNome("Alex egidio");

		Pessoa pessoa2 = new Pessoa();
		pessoa2.setEmail("pessoa2@gmail.com");
		pessoa2.setIdade(25);
		pessoa2.setNome("Marcos tadeu");

		Pessoa pessoa3 = new Pessoa();
		pessoa3.setEmail("pessoa3@gmail.com");
		pessoa3.setIdade(40);
		pessoa3.setNome("Maria jesus");
                
                Pessoa pessoa4 = new Pessoa();
		pessoa4.setEmail("pessoa4@gmail.com");
		pessoa4.setIdade(40);
		pessoa4.setNome("Paulo");
                
                /*Pode vir do banco de dados ou qualquer fonte de dados*/
		      List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);
                pessoas.add(pessoa4);
                
                // Usando apache poi
                HSSFWorkbook hSSFWorkbook=new HSSFWorkbook(); // Ele vai ser usado para escrever na planilha
                HSSFSheet linhasPessoas=hSSFWorkbook.createSheet("Planilha pessoas jdev"); // Criar a planilha
                
                int numeroLinha=0; // ter controle das linhas que estão sendo criadas
                for(Pessoa p:pessoas){
                    Row linha=linhasPessoas.createRow(numeroLinha ++); // Criando a linha na planilha
                    
                    // Para cada pessoa vou criar uma linha com suas celular -> valores
                    int celula=0;
                    Cell cellNome=linha.createCell(celula ++); // celula 1
                    cellNome.setCellValue(p.getNome());
                    
                    Cell cellEmail=linha.createCell(celula ++);// celula 2
                    cellEmail.setCellValue(p.getEmail());
                    
                    Cell cellIdade=linha.createCell(celula ++);// celula 3
                    cellIdade.setCellValue(p.getIdade());
                }
                
                // Termino de montar a planilha
                
                FileOutputStream saida=new FileOutputStream(arquivo);
                hSSFWorkbook.write(saida); // vai escrever a planilha em arquivo , pois ele está carregando na referência todos os dados da planilha
                
                saida.flush();
                saida.close();
                System.out.println("Planilha foi criada");
    }
}
