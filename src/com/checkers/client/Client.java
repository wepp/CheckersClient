package com.checkers.client;

import com.checkers.domain.vo.Field;
import com.checkers.domain.vo.Step;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by Isaiev on 01.10.2015.
 */
public class Client {

    public static void main(String[] args)  {
        Socket clsock = null;
        ObjectInputStream inObject = null;
        ObjectOutputStream outObj = null;
        CheckersAbstractBot bot;
        String className = args[0];
        String host = args[1];
        Integer port;
        try {
            port = Integer.valueOf(args[2]);
            bot = (CheckersAbstractBot) Class.forName(className).newInstance();

            System.out.println("newInstance created");
            clsock = new Socket(host, port);
            System.out.println("Connection established");

            inObject = new ObjectInputStream(clsock.getInputStream());
            outObj = new ObjectOutputStream(clsock.getOutputStream());
            Step userStep = null;
            long timer;
            while (true) {
                Field currentField = (Field)inObject.readObject();
                System.out.println(currentField);
                timer = System.currentTimeMillis();
                if(currentField != null){
                    userStep = bot.calculateNextStep(currentField);
                }
                timer = System.currentTimeMillis() - timer;
                userStep.setUsedTime(timer);
                outObj.writeObject(userStep);
            }
        } catch (IOException e) {
            System.err.println("Client error! " + e);
        } catch (ClassNotFoundException e) {
            System.err.println("Client error! " + e);
        } catch (InstantiationException e) {
        e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
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
