package com.checkers.client;

import com.checkers.domain.vo.Field;

import java.io.*;
import java.net.Socket;

/**
 * Created by Isaiev on 01.10.2015.
 */
public class Client {

    public static void main(String[] args)  {
        CheckersBot bot = new CheckersBot();
        Socket clsock = null;
        ObjectInputStream inObject=null;
        ObjectOutputStream outObj = null;
        String color = null;
        try {
            clsock = new Socket("localhost",8181);
            System.out.println("Connection established");

            inObject = new ObjectInputStream(clsock.getInputStream());
            outObj = new ObjectOutputStream(clsock.getOutputStream());
            while (true) {
                color = (String)inObject.readObject();
                if(color!=null){
                    System.out.println(color);
                    Field currentField = (Field)inObject.readObject();
                    if(currentField!=null){
                        outObj.writeObject(bot.calculateNextStep(currentField));
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Client error! " + e);
        } catch (ClassNotFoundException e) {
            System.err.println("Client error! " + e);
        }finally {
            try {
                clsock.close();
                inObject.close();
                outObj.close();
            } catch (IOException e) {
                System.err.println("Client error while closing! " + e);
            }

        }
    }
}
