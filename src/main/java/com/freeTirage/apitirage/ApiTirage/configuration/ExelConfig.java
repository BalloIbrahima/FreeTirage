package com.freeTirage.apitirage.ApiTirage.configuration;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.formula.atp.Switch;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.freeTirage.apitirage.ApiTirage.models.Postulant;

public class ExelConfig {

    static String excelType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String listeExcel = "Postulants";

    // Methode qui verifi si le fichier est un fichier Excel
    public static Boolean verifier(MultipartFile file) {

        if (excelType.equals(file.getContentType())) {
            return true;
        } else {
            return false;
        }
    }

    // Methode qui retourne la liste des postulants à travers le fichier excel
    // fournit
    public static List<Postulant> postulantsExcel(MultipartFile file) {

        try {
            // lecture du fichier
            Workbook workbook = new XSSFWorkbook(file.getInputStream());
            Sheet sheet = workbook.getSheet(listeExcel);
            Iterator<Row> ligne = sheet.iterator();

            // creation d'une liste dans la quelle on va mettre la liste recuperée
            List<Postulant> postulants = new ArrayList<>();

            int numeroLigne = 0;
            // parcour du fichier excel ligne par ligne
            while (ligne.hasNext()) {
                // Recuperation de la ligne courante
                Row ligneCourante = ligne.next();
                // on lui dit de sauter la première ligne du fichier, qui est l'entête
                if (numeroLigne == 0) {
                    numeroLigne++;
                    continue;
                }

                // Après avoir recuperer une ligne, on crée un postulant et on recupère ses
                // attributs;
                Postulant postulant = new Postulant();

                Iterator<Cell> colonne = ligneCourante.iterator();
                int numeroColonne = 0;
                // parcour des colonnes d'une ligne
                while (colonne.hasNext()) {
                    // Recuperation de la colonne courante
                    Cell colonneCourante = colonne.next();
                    // recuperation des infos de chaque colonne
                    switch (numeroColonne) {
                        // première colonne contenant le nom
                        case 0:
                            postulant.setNom(colonneCourante.getStringCellValue());
                            break;
                        // deuxième colonne contenant le prenom
                        case 1:
                            postulant.setPrenom(colonneCourante.getStringCellValue());
                            break;
                        // troixième colonne contenant le numero
                        case 2:
                            postulant.setNumero(colonneCourante.getStringCellValue());
                            break;
                        // dernière colonne contenant l'adresse mail
                        case 3:
                            postulant.setEmail(colonneCourante.getStringCellValue());
                            break;
                        default:
                            break;
                    }
                    numeroColonne++;
                }
                postulants.add(postulant);
            }
            workbook.close();
            return postulants;

        } catch (Exception e) {
            // TODO: handle exception
            return null;
        }

    }
}
