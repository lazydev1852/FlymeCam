package com.mediatek.accessor.util;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockFileUtils {
    private static Map<String, ReadWriteLock> sLockCollections = new HashMap();

    public static void readLock(String str) {
        ReadWriteLock readWriteLock;
        TraceHelper.beginSection(">>>>ReadWriteLockFileUtils-readLock");
        if (sLockCollections.isEmpty() || !sLockCollections.containsKey(str)) {
            ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
            sLockCollections.put(str, reentrantReadWriteLock);
            readWriteLock = reentrantReadWriteLock;
        } else {
            readWriteLock = sLockCollections.get(str);
        }
        readWriteLock.readLock().lock();
        TraceHelper.endSection();
    }

    public static void readUnlock(String str) {
        ReadWriteLock readWriteLock;
        TraceHelper.beginSection(">>>>ReadWriteLockFileUtils-readUnlock");
        if (sLockCollections.isEmpty() || !sLockCollections.containsKey(str)) {
            ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
            sLockCollections.put(str, reentrantReadWriteLock);
            readWriteLock = reentrantReadWriteLock;
        } else {
            readWriteLock = sLockCollections.get(str);
        }
        readWriteLock.readLock().unlock();
        TraceHelper.endSection();
    }

    public static void writeLock(String str) {
        ReadWriteLock readWriteLock;
        TraceHelper.beginSection(">>>>ReadWriteLockFileUtils-writeLock");
        if (sLockCollections.isEmpty() || !sLockCollections.containsKey(str)) {
            ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
            sLockCollections.put(str, reentrantReadWriteLock);
            readWriteLock = reentrantReadWriteLock;
        } else {
            readWriteLock = sLockCollections.get(str);
        }
        readWriteLock.writeLock().lock();
        TraceHelper.endSection();
    }

    public static void writeUnlock(String str) {
        ReadWriteLock readWriteLock;
        TraceHelper.beginSection(">>>>ReadWriteLockFileUtils-writeUnlock");
        if (sLockCollections.isEmpty() || !sLockCollections.containsKey(str)) {
            ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
            sLockCollections.put(str, reentrantReadWriteLock);
            readWriteLock = reentrantReadWriteLock;
        } else {
            readWriteLock = sLockCollections.get(str);
        }
        readWriteLock.writeLock().unlock();
        TraceHelper.endSection();
    }
}
