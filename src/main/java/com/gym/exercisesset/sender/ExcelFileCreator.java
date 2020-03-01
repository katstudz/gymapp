package com.gym.exercisesset.sender;

import com.gym.exercisesset.model.Exercise;
import com.gym.exercisesset.model.Training;
import com.gym.exercisesset.traininglist.ExerciseWithRepeat;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class ExcelFileCreator {
    private static String[] columns = {"Powtorzenia", "Ćwiczenia", "Link"};
    private Workbook workbook;
    private Sheet sheet;

    public String createFile(String name, Training training) throws IOException{
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("training");
        addStyle();
        addExerciseFromTraining(training);
        for(int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }
        return saveFile(name);
    }

    private String saveFile(String name)  throws IOException {
        String fileName = name+ "_trening.xlsx";
        FileOutputStream fileOut = new FileOutputStream(fileName);
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
        return fileName;
    }

    private void addExerciseFromTraining(Training training) {
        int rowNumber = 0;
        for (ExerciseWithRepeat exerciseWithRepeat : training.getExercisesWithRepeat()){
            Exercise exercise = exerciseWithRepeat.getExercise();
            Row row = sheet.createRow(rowNumber++);
            row.createCell(0)
                    .setCellValue(exerciseWithRepeat.getRepeat());
            row.createCell(1)
                    .setCellValue(exercise.getName());
            row.createCell(2)
                    .setCellValue(exercise.getYoutubeSource());
        }
    }

    private void addStyle(){
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());

        Row headerRow = sheet.createRow(0);
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);
        for(int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }
    }
}
