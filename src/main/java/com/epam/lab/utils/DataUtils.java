package com.epam.lab.utils;

import com.epam.lab.model.Letter;
import com.epam.lab.model.Letters;
import com.epam.lab.model.User;
import com.epam.lab.model.Users;
import org.apache.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.List;
import java.util.ArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.stream.Collectors;

public class DataUtils {
    private final static Logger LOG = Logger.getLogger(DataUtils.class);

    public static List<User> getListUsersFromXML(File importFile) {
        try {
            Users users;
            JAXBContext context = JAXBContext.newInstance(Users.class);
            Unmarshaller um = context.createUnmarshaller();
            users = (Users) um.unmarshal(importFile);
            return users.getUsers();
        } catch (JAXBException e) {
            LOG.error("Can't parse file");
            e.printStackTrace();
        }
        return null;
    }

    public static List<Letter> getListLettersFromXML(File importFile) {
        try {
            Letters letters;
            JAXBContext context = JAXBContext.newInstance(Letters.class);
            Unmarshaller um = context.createUnmarshaller();
            letters = (Letters) um.unmarshal(importFile);
            return letters.getLetters();
        } catch (JAXBException e) {
            LOG.error("Can't parse file");
            e.printStackTrace();
        }
        return null;
    }

    public static List<User> getListUsersFromCSV(File importFile) throws FileNotFoundException, IOException {
        CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');
        CSVParser parser = new CSVParser(new FileReader(importFile), format);

        List<User> users = new ArrayList<>();
        for (CSVRecord record : parser) {
            User user = new User();
            user.setLogin(record.get("login"));
            user.setPassword(record.get("password"));
            users.add(user);
        }
        parser.close();
        return users;
    }

    public static List<Letter> getListLettersFromCSV(File importFile) throws FileNotFoundException, IOException {
        CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');
        CSVParser parser = new CSVParser(new FileReader(importFile), format);

        List<Letter> letters = new ArrayList<>();
        for (CSVRecord record : parser) {
            Letter letter = new Letter();
            letter.setTo(record.get("to"));
            letter.setSubject(record.get("subject"));
            letter.setContent(record.get("content"));
            letters.add(letter);
        }
        parser.close();
        return letters;
    }


    @Deprecated
    public static List<Letter> getListLettersFromExcel(File importFile) throws IOException {
        List<Letter> letters = new ArrayList<>();
        Letter letter = new Letter();
        InputStream myExcelBook = new FileInputStream(importFile);
        XSSFWorkbook wb = new XSSFWorkbook(myExcelBook);
        XSSFSheet sheet = wb.getSheetAt(0);
        XSSFRow row;
        XSSFCell cell;

        Iterator rows = sheet.rowIterator();
        int counter = 0;
        while (rows.hasNext()) {
            row = (XSSFRow) rows.next();
            Iterator cells = row.cellIterator();
            while (cells.hasNext()) {
                cell = (XSSFCell) cells.next();
                if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
                    if (counter == 0) {
                        letter.setTo(cell.getStringCellValue());
                    } else if (counter == 1) {
                        letter.setSubject(cell.getStringCellValue());
                    } else if (counter == 2) {
                    } else if (cell.getStringCellValue() != null)
                        letter.setContent(cell.getStringCellValue());
                }
                ++counter;
            }
        }
        counter = 0;
        letters.add(letter);
//        return letters.stream().filter(message -> !(message.getContent() == null)).collect(Collectors.toList());
        return letters;
    }
}
