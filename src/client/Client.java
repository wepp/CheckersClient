package client;

import vo.Field;
import vo.Step;

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
        BufferedReader br=null;
        try {
            clsock = new Socket(""+args[0],Integer.parseInt(args[1]));
            System.out.println("Connection established");

            inObject = new ObjectInputStream(clsock.getInputStream());
            outObj = new ObjectOutputStream(clsock.getOutputStream());
            br = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                Field currentField = (Field)inObject.readObject();
                if(currentField!=null){
                    outObj.writeObject(bot.calculateNextStep(currentField));
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
                br.close();
            } catch (IOException e) {
                System.err.println("Client error while closing! " + e);
            }

        }
    }
}
