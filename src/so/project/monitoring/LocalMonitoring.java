/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.project.monitoring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Mauros
 */
public class LocalMonitoring {
        
        public static String getCPU() {
                    // CPU Usage
                String cpuCommand = "wmic cpu get loadpercentage";
                String cpuUsage = executeCommand(cpuCommand);
                return parseCpuUsage(cpuUsage);
        }
        
        public static String getMemory() {
                    // Memory Usage
                String memoryCommand = "wmic OS get FreePhysicalMemory,TotalVisibleMemorySize /Format:Value";
                String memoryUsage = executeCommand(memoryCommand);
                return parseMemoryUsage(memoryUsage);
        }
        
        public static String getDisk() {
    // Disk I/O Usage
                // Disk I/O Usage
    String diskCommand = "typeperf \"\\LogicalDisk(_Total)\\% Disk Time\" -sc 1";
    String diskUsage = executeCommand(diskCommand);
    return parseDiskUsage(diskUsage);
        }
        
    private static String executeCommand(String command) {
        StringBuilder output = new StringBuilder();
        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
            reader.close();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return output.toString();
    }

    private static String parseCpuUsage(String cpuUsage) {
        String[] lines = cpuUsage.split("\n");
        for (String line : lines) {
            line = line.trim();
            if (line.matches("\\d+")) {
                return line + "%";
            }
        }
        return "N/A";
    }

    private static String parseMemoryUsage(String memoryUsage) {
        String[] lines = memoryUsage.split("\n");
        long freeMemory = 0;
        long totalMemory = 0;
        for (String line : lines) {
            line = line.trim();
            if (line.startsWith("FreePhysicalMemory=")) {
                freeMemory = Long.parseLong(line.split("=")[1]);
            } else if (line.startsWith("TotalVisibleMemorySize=")) {
                totalMemory = Long.parseLong(line.split("=")[1]);
            }
        }
        long usedMemory = totalMemory - freeMemory;
        double memoryUsagePercent = (double) usedMemory / totalMemory * 100;
        return String.format("%.2f%%", memoryUsagePercent);
    }

private static String parseDiskUsage(String input) {
        // Define a expressão regular
        String regex = "\",\"(.*?)\"";
        String txt = null;
        // Compila a expressão regular em um padrão
        Pattern pattern = Pattern.compile(regex);

        // Cria um objeto Matcher para encontrar os padrões na string de entrada
        Matcher matcher = pattern.matcher(input);

        // Enquanto houver correspondências, imprime os valores entre as vírgulas e as aspas
        while (matcher.find()) {
           txt = matcher.group(1);
        }
    return txt;
}
    
}
