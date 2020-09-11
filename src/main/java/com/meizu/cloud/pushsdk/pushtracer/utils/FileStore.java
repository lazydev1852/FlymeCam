package com.meizu.cloud.pushsdk.pushtracer.utils;

import android.content.Context;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class FileStore {
    private static final String TAG = "FileStore";

    public static boolean saveMapToFile(String str, Map map, Context context) {
        try {
            Logger.m4854d(TAG, "Attempting to save: %s", map);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(context.openFileOutput(str, 0));
            objectOutputStream.writeObject(map);
            objectOutputStream.close();
            Logger.m4854d(TAG, " + Successfully saved KV Pairs to: %s", str);
            return true;
        } catch (IOException e) {
            Logger.m4855e(TAG, " + Exception saving vars map: %s", e.getMessage());
            return false;
        }
    }

    public static Map getMapFromFile(String str, Context context) {
        try {
            Logger.m4854d(TAG, "Attempting to retrieve map from: %s", str);
            ObjectInputStream objectInputStream = new ObjectInputStream(context.openFileInput(str));
            HashMap hashMap = (HashMap) objectInputStream.readObject();
            objectInputStream.close();
            Logger.m4854d(TAG, " + Retrieved map from file: %s", hashMap);
            return hashMap;
        } catch (IOException | ClassNotFoundException e) {
            Logger.m4855e(TAG, " + Exception getting vars map: %s", e.getMessage());
            return null;
        }
    }

    public static boolean deleteFile(String str, Context context) {
        boolean deleteFile = context.deleteFile(str);
        Logger.m4854d(TAG, "Deleted %s from internal storage: %s", str, Boolean.valueOf(deleteFile));
        return deleteFile;
    }
}
