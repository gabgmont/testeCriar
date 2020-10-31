package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        String local = "C:\\Users\\gabgm\\OneDrive\\Documentos\\Gabriel\\arquivos\\log.txt";

        try(BufferedReader leitor = new BufferedReader (new FileReader(local))){
            String linha = leitor.readLine();
            while(leitor.readLine() != null){
                System.out.println(linha);
                linha = leitor.readLine();
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
