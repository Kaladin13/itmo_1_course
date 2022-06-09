package com.company;

import com.company.controller.ClientExecutor;
import com.company.controller.CommandReader;
import com.company.controller.dao.HibernateSessionFactory;
import com.company.scanner.InputParser;
import com.company.scanner.InputSource;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        ClientExecutor clientExecutor = null;
        try {
            InputParser inputParser = new InputParser(InputSource.CONSOLE);
            clientExecutor = new ClientExecutor(inputParser);
            CommandReader commandReader = new CommandReader(inputParser, clientExecutor);
            commandReader.startService();
        }
        catch (Exception ignored) {}
        finally {
            clientExecutor.closeConnection();
        }
    }
}
