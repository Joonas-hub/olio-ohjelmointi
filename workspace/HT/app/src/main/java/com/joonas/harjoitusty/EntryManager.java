package com.joonas.harjoitusty;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EntryManager {
    // Singleton class for creating new log entries.
    private static EntryManager EntryManagerInstance = null;
    private String logFileName = "log.txt";
    private File logFile;

    private EntryManager(File filePath){
        // Constructor creates a new log file if it doesn't exist, or sets up the existing log file.
        this.logFile = new File(filePath, logFileName);
    }

    public static EntryManager getInstance(File filePath){
        if (EntryManagerInstance == null){
            EntryManagerInstance = new EntryManager(filePath);
        }
        return EntryManagerInstance;
    }
    public void saveDietEntry(float meat, float veg){
        // Creates a new diet entry from user inputs and writes it to the logfile.
        DietEntry entry = new DietEntry(meat, veg);
        System.out.println("Getting log entry");
        String entryString = entry.getLogEntry();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true));
            writer.append(entryString).append("\n");
            writer.close();
            System.out.println("Entry Saved");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

public String getLogFileName(){
        return logFileName;
}
}
