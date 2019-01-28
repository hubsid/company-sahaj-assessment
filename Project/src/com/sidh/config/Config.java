package com.sidh.config;

public interface Config {
    InputType INPUT_SOURCE = InputType.FROM_FILE;
    String INPUT_FILE = "csv.txt";
    String CSV_SEPARATOR = ",";
    OutputType OUTPUT_DESTINATION = OutputType.TO_FILE;
    String OUTPUT_FILE = "csv-out.csv";
}
