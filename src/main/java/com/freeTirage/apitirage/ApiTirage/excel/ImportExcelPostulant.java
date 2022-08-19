package com.freeTirage.apitirage.ApiTirage.excel;

import com.freeTirage.apitirage.ApiTirage.models.Postulant;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import com.freeTirage.apitirage.ApiTirage.models.Postulant;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ImportExcelPostulant {
    public List<Postulant> excelImport(){
        List<Postulant> listPostulant=new ArrayList<>();
        long id=0;
        String nom="";
        String prenom="";
        String numero="";
        String email="";

        String excelFilePath="C:\\Users\\MTTRAORE\\Desktop\\import.xlsx";

        long start = System.currentTimeMillis();

        FileInputStream inputStream;
        try {
            inputStream = new FileInputStream(excelFilePath);
            Workbook workbook=new XSSFWorkbook(inputStream);
            Sheet firstSheet=workbook.getSheetAt(0);
            Iterator<Row> rowIterator=firstSheet.iterator();
            rowIterator.next();

            while(rowIterator.hasNext()) {
                Row nextRow = rowIterator.next();
                Iterator<Cell> cellIterator=nextRow.cellIterator();
                while(cellIterator.hasNext()) {
                    Cell nextCell=cellIterator.next();
                    int columnIndex=nextCell.getColumnIndex();
                    switch (columnIndex) {
                        case 0:
                            id=(long)nextCell.getNumericCellValue();
                            System.out.println(id);
                            break;
                        case 1:
                            nom=nextCell.getStringCellValue();
                            System.out.println(nom);
                            break;
                        case 2:
                            prenom=nextCell.getStringCellValue();
                            System.out.println(prenom);
                            break;
                        case 3:
                            numero=nextCell.getStringCellValue();
                            System.out.println(numero);
                            break;
                        case 4:
                            email=nextCell.getStringCellValue();
                            System.out.println(email);
                            break;

                    }
                    listPostulant.add(new Postulant(id, nom, prenom, numero, email));
                }
            }

            workbook.close();
            long end = System.currentTimeMillis();
            System.out.printf("Import done in %d ms\n", (end - start));

        } catch (Exception e) {
            // TODO Auto-generated catch block

            e.printStackTrace();
        }

        return listPostulant;
    }


}
