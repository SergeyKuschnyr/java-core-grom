package lesson35.repository;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by Kushn_000 on 10.12.2017.
 */
public class OrderRepository extends GeneralRepository {
    private File orderDB;

    public void bookRoom(long roomId, long userId) throws Exception {
        bookValidate(roomId, userId);
        roomDBUpdate(roomId);
        orderDBUpdate(roomId, userId);
    }

    public void cancelReservation(long roomId, long userId) throws Exception {
        bookValidate(roomId, userId);
        roomDBUpdate(roomId);
        cancelOrder(roomId, userId);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    private void roomDBUpdate(long roomId) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("C:/Lesson35_DBFile/roomFile.txt"));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:/Lesson35_DBFile/roomFile.txt", true))) {
            String string = "";
            StringBuilder stringBuilder = new StringBuilder();
            while ((string = bufferedReader.readLine()) != null) {
                String[] strings = string.split(",");
                if (strings[0].equals(Long.toString(roomId))) {
                    strings[5] = (new Date(2017, 12, 29)).toString();
                    string = "";
                    string = Arrays.toString(strings);
                }
                stringBuilder.append(string).append("\n");
            }
            FileUtils.write(new File("C:/Lesson35_DBFile/roomFile.txt"), "");
            bufferedWriter.append(stringBuilder.toString());
        } catch (IOException e) {
            System.out.println("Can't handled file: " + "C:/Lesson35_DBFile/roomFile.txt");
        }
    }

    private void cancelOrder(long roomId, long userId) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("C:/Lesson35_DBFile/orderFile.txt"));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:/Lesson35_DBFile/orderFile.txt", true))) {
            String string = "";
            StringBuilder stringBuilder = new StringBuilder();
            while ((string = bufferedReader.readLine()) != null) {
                String[] strings = string.split(",");
                if (strings[1].equals(Long.toString(roomId)) && strings[2].equals(Long.toString(userId))) {
                    continue;
                }
                stringBuilder.append(string).append("\n");
            }
            FileUtils.write(new File("C:/Lesson35_DBFile/orderFile.txt"), "");
            bufferedWriter.append(stringBuilder.toString());
        } catch (IOException e) {
            System.out.println("Can't handled file: " + "C:/Lesson35_DBFile/orderFile.txt");
        }
    }

    private void orderDBUpdate(long roomId, long userId) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:/Lesson35_DBFile/orderFile.txt", true))) {
            bufferedWriter.append(setID()).append(",");
            bufferedWriter.append(Long.toString(roomId)).append(",");
            bufferedWriter.append(Long.toString(userId)).append("\n");
        } catch (IOException e) {
            System.out.println("Can't write to file: " + "C:/Lesson35_DBFile/orderFile.txt");
        }
    }

    private void bookValidate(long roomId, long userId) throws Exception {
        if (UserRepository.getUser() == null) {
            throw new Exception("Please login");
        }
        if (roomId == 0 || userId == 0) {
            throw new Exception("Booking error: date error");
        }
    }
}






