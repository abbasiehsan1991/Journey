package codenevisha.ir.app.journey.util;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Global executor pools for the whole application.
 * Used for database and other stuffs in application
 */
public class AppExecutors {

  private static final int THREAD_COUNT = 3;

  private final Executor diskIO;

  private final Executor networkIO;

  private final Executor mainThread;

  @VisibleForTesting
  AppExecutors(Executor diskIO, Executor networkIO, Executor mainThread) {
    this.diskIO = diskIO;
    this.networkIO = networkIO;
    this.mainThread = mainThread;
  }

  public AppExecutors() {
    this(
      new DiskIOThreadExecutor(),
      Executors.newFixedThreadPool(THREAD_COUNT),
      new MainThreadExecutor());
  }

  public Executor diskIO() {
    return diskIO;
  }

  public Executor networkIO() {
    return networkIO;
  }

  public Executor mainThread() {
    return mainThread;
  }


}
